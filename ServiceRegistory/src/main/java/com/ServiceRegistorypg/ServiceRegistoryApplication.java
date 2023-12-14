package com.ServiceRegistorypg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistoryApplication {

	public static void main(String[] args) {
		System.out.println("working....");
		SpringApplication.run(ServiceRegistoryApplication.class, args);
	}

}
