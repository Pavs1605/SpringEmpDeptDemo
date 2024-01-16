package org.apps.workforce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.apps.workforce")
public class WorkforceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkforceApplication.class, args);
	}

}
