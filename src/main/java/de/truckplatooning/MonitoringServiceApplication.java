package de.truckplatooning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
public class MonitoringServiceApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return  new RestTemplate();
	}


	public static void main(String[] args) throws IOException {
		SpringApplication.run(MonitoringServiceApplication.class, args);

		Scanner sc = new Scanner(System.in);
		System.out.println("PID: " + ProcessHandle.current().pid());
		String processToKill = sc.nextLine();
		String cmd = "kill -9 " + processToKill;
		Runtime.getRuntime().exec(cmd);


	}


}
