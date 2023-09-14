package br.com.planets.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@ComponentScan("br.com.planets")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
