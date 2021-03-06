package com.example.courserating.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.example.courserating")
@PropertySource("application.properties")
public class SpringConfig {

}
