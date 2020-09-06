package com.startup.OnlineStore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.CommandLinePropertySource;

@SpringBootApplication
public class OnlineStoreApplication implements CommandLineRunner {
		private static final Logger log = LoggerFactory.getLogger(OnlineStoreApplication.class);
	public static void main(String[] args) {
		System.out.println("Current Directory = " + System.getProperty("user.dir"));
		SpringApplication.run(OnlineStoreApplication.class, args);
		log.info("-------------------just a test info logasdasfdas");
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
