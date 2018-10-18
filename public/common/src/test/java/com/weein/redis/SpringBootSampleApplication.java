package com.weein.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.weein")
public class SpringBootSampleApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringBootSampleApplication.class);
		// application.setBanner(new AppBanner());
		application.run(args);
	}

}
