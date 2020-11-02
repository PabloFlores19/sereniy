package com.serenity.project.dataprovider;

import com.serenity.project.config.DataConfiguration;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ApiGet {

    public String getApi(){
        //ApplicationContext context = new FileSystemXmlApplicationContext("/src/spring-context.xml");

        //leer class de configuracion
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(DataConfiguration.class);
        BasicDataSource ds = (BasicDataSource) context.getBean("dataSource");
        return ds.getUrl();
    }
}
