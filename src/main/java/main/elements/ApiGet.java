package main.elements;

import main.daopages.ApiDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApiGet {

    public String getApi(){
        ApplicationContext context = new FileSystemXmlApplicationContext("/src/spring-context.xml");
        ApiDAO api = context.getBean("api", ApiDAO.class);
        String url = api.getBaseURl();
        return url;
    }
}
