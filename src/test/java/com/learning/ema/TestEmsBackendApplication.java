package com.learning.ema;

import org.springframework.boot.SpringApplication;

public class TestEmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.from(EmsBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
