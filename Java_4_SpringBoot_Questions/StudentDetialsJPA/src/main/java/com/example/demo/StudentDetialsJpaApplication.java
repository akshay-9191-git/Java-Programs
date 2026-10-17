package com.example.demo;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentDetialsJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentDetialsJpaApplication.class, args);
	}
	
	@Bean
	CommandLineRunner testDatabaseConnection(DataSource datasource ) {
		return args -> {
			try(Connection connection = datasource.getConnection()){
				System.out.println("PostgreSQL connected successfully!");
                System.out.println("Database: " + connection.getCatalog());
			}
			
		};
	}

}
