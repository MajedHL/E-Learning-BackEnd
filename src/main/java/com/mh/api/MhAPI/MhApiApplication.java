package com.mh.api.MhAPI;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MhApiApplication {
	@Autowired
	private ApplicationContext applicationContext;
	public static void main(String[] args) {
		SpringApplication.run(MhApiApplication.class, args);
	}

	@PostConstruct
	public void printBeans() {
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println("BEAN:"+beanName);
		}
	}

}
