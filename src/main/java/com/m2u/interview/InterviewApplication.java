package com.m2u.interview;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "classpath:vendor.properties" })
public class InterviewApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(InterviewApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
