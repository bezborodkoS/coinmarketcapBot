package com.example.coinmarketcapbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@ConfigurationProperties(value = "available")
public class BotPropConfig {



    @Value("${available.statuses}")
    private String statuses;

    public List<String> getAvailableStatuses() {
        return List.of(statuses.split(",*"));
    }

}
