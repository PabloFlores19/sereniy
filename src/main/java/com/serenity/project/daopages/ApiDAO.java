package com.serenity.project.daopages;

import org.springframework.beans.factory.annotation.Value;

public class ApiDAO {

    @Value("${base.url}")
    private String baseURl;

    public String getBaseURl() {
        return baseURl;
    }

    public void setBaseURl(String baseURl) {
        this.baseURl = baseURl;
    }
}


