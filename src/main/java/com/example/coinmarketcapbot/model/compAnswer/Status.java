package com.example.coinmarketcapbot.model.compAnswer;

import lombok.Data;

import java.util.Date;

@Data
public class Status {
    public Date timestamp;
    public int error_code;
    public String error_message;
    public int elapsed;
    public int credit_count;
}
