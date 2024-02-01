package com.DWR.DWR_Record;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class DrwRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrwRecordApplication.class, args);
	}

}
