package com.king.kinghand.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "my.hobby")
public class Random {

    private String sport;

    private String number;

    public String getSport() {
        return sport;
    }

    public String getNumber() {
        return number;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
