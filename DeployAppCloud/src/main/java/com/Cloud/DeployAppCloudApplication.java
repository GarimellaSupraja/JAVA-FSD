package com.Cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.Cloud")
public class DeployAppCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeployAppCloudApplication.class, args);
	}

}