package com.example.goodcontroller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author hp
 */
@SpringBootApplication(scanBasePackages ="com.example.goodcontroller" )
public class GoodControllerApp {
	public static void main(String[] args) {
		SpringApplication.run(GoodControllerApp.class);
	}
}