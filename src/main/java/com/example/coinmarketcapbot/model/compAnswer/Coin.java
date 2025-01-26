package com.example.coinmarketcapbot.model.compAnswer;

import lombok.Data;

import java.util.Date;
import java.util.Objects;


public class Coin {
    private int id;
    private int rank;
    private String name;
    private String symbol;
    private String slug;
    private int is_active;
    private Date first_historical_data;
    private Date last_historical_data;
    private Platform platform;

    public int getId() {
        return id;
    }

    public int getRank() {
        return rank;
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

    public int getIs_active() {
        return is_active;
    }

    public Date getFirst_historical_data() {
        return first_historical_data;
    }

    public Date getLast_historical_data() {
        return last_historical_data;
    }

    public Platform getPlatform() {
        return platform;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "id=" + id +
                ", rank=" + rank +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", slug='" + slug + '\'' +
                ", is_active=" + is_active +
                ", first_historical_data=" + first_historical_data +
                ", last_historical_data=" + last_historical_data +
                ", platform=" + platform +
                '}';
    }

//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Coin coin)) return false;
//        return getId() == coin.getId() && getName().equals(coin.getName()) && getSymbol().equals(coin.getSymbol()) && Objects.equals(getFirst_historical_data(), coin.getFirst_historical_data()) && Objects.equals(getLast_historical_data(), coin.getLast_historical_data()) && Objects.equals(getPlatform(), coin.getPlatform());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getId(), getName(), getSymbol(), getFirst_historical_data(), getLast_historical_data(), getPlatform());
//    }
}
