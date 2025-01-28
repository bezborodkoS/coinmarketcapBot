package com.example.coinmarketcapbot;

import com.example.coinmarketcapbot.config.BotPropConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class CoinmarketcapBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoinmarketcapBotApplication.class, args);

    }

}
