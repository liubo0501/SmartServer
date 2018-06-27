package com.smart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.smart.mapper")
public class SmartServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartServerApplication.class, args);
	}
}
