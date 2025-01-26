package com.example.coinmarketcapbot.model.compAnswer;

import lombok.Data;

public class Platform {
    private int id;
    private String name;
    private String symbol;
    private String slug;
    private String token_address;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSlug() {
        return slug;
    }

    public String getToken_address() {
        return token_address;
    }
}
