package com.anizmocreations.multistore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

@EnableAutoConfiguration
@EntityScan("com.anizmocreations")
@ComponentScan({"com.anizmocreations"})
@SpringBootApplication
public class MultistoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultistoreApplication.class, args);
	}

}
