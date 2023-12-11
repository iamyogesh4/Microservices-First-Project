package com.registory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistory1Application {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistory1Application.class, args);
	}

}
