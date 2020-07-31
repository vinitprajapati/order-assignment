package com.knowarth.api.order.item;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderItemApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderItemApiApplication.class, args);
	}

}
