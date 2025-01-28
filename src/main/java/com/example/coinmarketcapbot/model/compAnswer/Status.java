package com.example.coinmarketcapbot.model.compAnswer;



import java.util.Date;

public class Status {
    public Date timestamp;
    public int error_code;
    public String error_message;
    public int elapsed;
    public int credit_count;

    public Date getTimestamp() {
        return timestamp;
    }

    public int getError_code() {
        return error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public int getElapsed() {
        return elapsed;
    }

    public int getCredit_count() {
        return credit_count;
    }
}
