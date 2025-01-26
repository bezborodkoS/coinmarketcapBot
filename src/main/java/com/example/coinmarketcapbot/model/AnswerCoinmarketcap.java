package com.example.coinmarketcapbot.model;

import com.example.coinmarketcapbot.model.compAnswer.Coin;
import com.example.coinmarketcapbot.model.compAnswer.Status;
import lombok.Getter;


import java.util.List;


public class AnswerCoinmarketcap {
    private List<Coin> data;
    private Status status;

    public List<Coin> getData() {
        return data;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "AnswerCoinmarketcap{" +
                "data=" + data +
                ", status=" + status +
                '}';
    }
}
