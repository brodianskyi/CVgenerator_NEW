package com.codecentric.cvgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
@EnableTransactionManagement
public class CvGeneratorApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CvGeneratorApplication.class, args);
	}
	 @Override
	 protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
	        return application.sources( CvGeneratorApplication.class);
	}
}
