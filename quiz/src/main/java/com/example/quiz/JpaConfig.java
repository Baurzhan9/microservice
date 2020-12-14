//package com.example.quiz;
//
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories
//public class JpaConfig implements TransactionManagementConfigurer {
//    @Value("${spring.datasource.driver-class-name}")
//    private String driver;
//    @Value("${spring.datasource.url}")
//    private String url;
//    @Value("${spring.datasource.username}")
//    private String username;
//    @Value("${spring.datasource.password}")
//    private String password;
//
////    @Bean
////    public DataSource dataSource() {
////        final HikariConfig config = new HikariConfig();
////        config.setDriverClassName(driver);
////        config.setJdbcUrl(url);
////        config.setUsername(username);
////        config.setPassword(password);
////        return new HikariDataSource(config);
////    }
//
////    @Bean(name="transactionManager")
////    public PlatformTransactionManager annotationDrivenTransactionManager() {
////        return new JpaTransactionManager();
////    }
//}
