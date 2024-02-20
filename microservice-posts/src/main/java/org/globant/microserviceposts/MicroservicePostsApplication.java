package org.globant.microserviceposts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicePostsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePostsApplication.class, args);
	}

}
