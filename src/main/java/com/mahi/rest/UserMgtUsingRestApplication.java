package com.mahi.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author Mahendra
 * This class is a boot strap class for Spring boot
 * This makes the project a web project
 */
@SpringBootApplication
public class UserMgtUsingRestApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(UserMgtUsingRestApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(UserMgtUsingRestApplication.class, args);
	}
}
