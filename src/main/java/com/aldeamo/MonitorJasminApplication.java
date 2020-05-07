package com.aldeamo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonitorJasminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorJasminApplication.class, args);
	}

}
