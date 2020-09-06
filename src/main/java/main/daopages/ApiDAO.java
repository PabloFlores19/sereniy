package main.daopages;

import org.springframework.beans.factory.annotation.Value;

public class ApiDAO {

    private String baseURl;

    public String getBaseURl() {
        return baseURl;
    }

    @Value("${base.url}")
    public void setBaseURl(String baseURl) {
        this.baseURl = baseURl;
    }
}


