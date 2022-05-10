package com.dio.santander.bankline.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class BanklineApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(BanklineApiApplication.class, args);
	}

}
