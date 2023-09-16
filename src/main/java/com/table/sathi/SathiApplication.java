package com.table.sathi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(info = @Info(title = "Your API", version = "1.0", description = "Your API Documentation"))
public class SathiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SathiApplication.class, args);
	}

}
