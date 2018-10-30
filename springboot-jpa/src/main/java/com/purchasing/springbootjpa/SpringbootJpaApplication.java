package com.purchasing.springbootjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.purchasing.springbootjpa.entity")
public class SpringbootJpaApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}
}
