package com.serenity.project.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:api.properties")
public class DataConfiguration {

    @Value("${base.url}")
    private String urlApis;
    @Value("${base.crud.url}")
    private String urlCrud;

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(urlApis);
        return ds;
    }

    @Bean
    public BasicDataSource dataSourceCrud(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(urlCrud);
        return dataSource;
    }
}
