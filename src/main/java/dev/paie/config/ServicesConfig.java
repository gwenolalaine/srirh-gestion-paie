package dev.paie.config;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dev.paie.spring.DataSourceMySQLConfig;
import dev.paie.spring.JpaConfig;

@Configuration
@ComponentScan({"dev.paie.service", "dev.paie.util", "dev.paie.spring", "dev.paie.menu"})
@Import({JpaConfig.class, DataSourceMySQLConfig.class})
@EnableJpaRepositories("dev.paie.repository")
public class ServicesConfig {

	@Bean
	public Scanner scanner(){
		return new Scanner(System.in);
	}
	/** LOG Logger */
	@Bean
	public Logger logger(){
		return LoggerFactory.getLogger(ServicesConfig.class);
	}	
}
