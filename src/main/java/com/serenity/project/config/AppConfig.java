package com.serenity.project.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.serenity.project")
@PropertySource("classpath:database.properties")
public class AppConfig {

    @Value("${datasource.drive}")
    private String driver;


    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource source = new SimpleDriverDataSource();
        source.setDriverClass(org.postgresql.Driver.class);
        source.setUrl("jdbc:postgresql://localhost:5433/postgres");
        source.setUsername("postgres");
        source.setPassword("");
        return source;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        return sqlSessionFactoryBean;
    }
}
