package com.fat;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = {"com.fat.Controller", "access"}) // finding all controllers in followed paths
@EnableJpaRepositories
@EntityScan(basePackages = "com.fat") // finding all entities in followed repository path
@ComponentScan(basePackages = "com.fat")
public class AccessApplication {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
	

	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(AccessApplication.class, args);


	}




}
