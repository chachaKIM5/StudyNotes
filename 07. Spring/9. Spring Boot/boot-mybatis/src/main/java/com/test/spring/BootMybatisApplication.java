package com.test.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = "com.test.spring")
//@ComponentScan(basePackages = "com.test.controller")
//@ComponentScan(basePackages = "com.test.service")
//@ComponentScan(basePackages = "com.test.repository")
//@ComponentScan(basePackages = {"com.test.controller", "com.test.service", "com.test.repository"})
//@ComponentScan(basePackages = "com.test.*")
//But component scan 대상은 최소한으로...


@SpringBootApplication
@ComponentScan(basePackages = {"com.test.controller", "com.test.repository"})
public class BootMybatisApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BootMybatisApplication.class, args);
	}

}
