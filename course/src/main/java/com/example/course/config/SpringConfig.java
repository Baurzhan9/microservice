package com.example.course.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.example.course")
@PropertySource("application.properties")
@EnableJpaRepositories("com.example.course.repository")
public class SpringConfig {

}
