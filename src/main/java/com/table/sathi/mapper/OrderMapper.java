package com.table.sathi.mapper;

import com.table.sathi.constant.SathiConstant;
import com.table.sathi.dao.order.Item;
import com.table.sathi.dao.order.OrderRequest;
import com.table.sathi.exception.ErrorResponse;
import com.table.sathi.exception.RestaurantInfoException;
import com.table.sathi.model.menu.MenuCategory;
import com.table.sathi.model.menu.MenuItem;
import com.table.sathi.model.menu.RestaurantInfo;
import com.table.sathi.model.order.GST;
import com.table.sathi.model.order.Order;
import com.table.sathi.model.order.OrderItem;
import com.table.sathi.service.RestaurantInfoService;
import com.table.sathi.utils.OrderCalculationResult;
import com.table.sathi.utils.OrderCalculationUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static com.table.sathi.utils.SathiUtils.buildErrorResponse;

@Component
public class OrderMapper {
    @Autowired
    RestaurantInfoService restaurantInfoService;
    @Autowired
    OrderCalculationUtility calculationUtility;
    public Order mapOrderRequestWithOrder(OrderRequest orderRequest) {
        List<OrderItem> orderItems=getOrderItems(orderRequest.getItems(),orderRequest.getResturantId());
        OrderCalculationResult orderCalculationResult=calculationUtility.calculateGSTAndTotal(orderItems);
        return Order.builder()
                .orderId(orderRequest.getOrderId())
                .status(orderRequest.getOrderFinalStatus())
                .couponCode(orderRequest.getCouponCode())
                .deliveryAddress(orderRequest.getDeliveryAddress())
                .deliveryMethod(orderRequest.getDeliveryMethod())
                .orderStatus(orderRequest.getOrderStatus())
                .orderItemItems(orderItems)
                .restruantName(orderRequest.getRestruantName())
                .resturantId(orderRequest.getResturantId())
                .gst(GST.builder()
                        .cgstAmount(orderCalculationResult.getTotalCGST())
                        .sgstAmount(orderCalculationResult.getTotalSGST())
                        .build())
                .subTotal(orderCalculationResult.getSubtotal())
                .total(orderCalculationResult.getTotalAmount())
                .build();
    }


    //Will add some caching logic to execute it only once per resturent to save time
    private List<OrderItem> getOrderItems(List<Item> items, String resturantId) {
        HashMap<String, MenuItem> menuItemHashMap=getMenuItemMapForResturent(resturantId);
        List<OrderItem> orderItems=new ArrayList<>();
        items.forEach(item ->
        {
            orderItems.add(mapItemWithOrderItem(item,menuItemHashMap.get(item.getItemId())));
        });
        return orderItems;
    }

    private OrderItem mapItemWithOrderItem(Item item, MenuItem menuItem) {
        return OrderItem.builder()
                .itemId(item.getItemId())
                .itemTitle(menuItem.getTitle())
                .itemQuantity(item.getQuantity())
                .itemPrice(menuItem.getCost())
                .imageLink(menuItem.getImageSrc())
                .itemOrderTime(LocalDateTime.now())
                .gstRate(menuItem.getGstRate())
                .build();
    }

    private HashMap<String, MenuItem> getMenuItemMapForResturent(String resturantId) {
        Optional<RestaurantInfo> optionalRestaurantInfo=restaurantInfoService.fetchResturant(resturantId);
        if(optionalRestaurantInfo.isPresent())
        {
            List<MenuCategory> menu=optionalRestaurantInfo.get().getMenu().getMenu();
            return getMenuItemMapFromMenuCategory(menu);
        }
        else
        {
            ErrorResponse errorResponse = buildErrorResponse(
                    "Resturent not found",
                    SathiConstant.DEFAULT_EXCEPTION_MESSAGE,
                    HttpStatus.NOT_FOUND,
                    null
            );
            throw new RestaurantInfoException(errorResponse);
        }
    }

    private HashMap<String, MenuItem> getMenuItemMapFromMenuCategory(List<MenuCategory> menu) {

        HashMap<String,MenuItem> menuItemHashMap=new HashMap<>();
        menu.forEach(menuCategory ->
        {
            List<MenuItem> menuItemList=    menuCategory.getItems();
            menuItemList.forEach(menuItem ->
            {
                menuItemHashMap.put(menuItem.getMenuItemId(),menuItem);
            });

        });
        return menuItemHashMap;
    }
}
