package com.example.coinmarketcapbot.model.telegram;

public class ParamsForUrlMap {
    private String status;
    private String sortBy;
    private int limit;
    private String symbols;

    public ParamsForUrlMap(String status, String sortBy, int limit, String symbols) {
        this.status = status;
        this.sortBy = sortBy;
        this.limit = limit;
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return "ParamsForUrlMap{" +
                "status='" + status + '\'' +
                ", sortBy='" + sortBy + '\'' +
                ", limit=" + limit +
                ", symbols='" + symbols + '\'' +
                '}';
    }
}
