package com.example.coinmarketcapbot.config;

import com.example.coinmarketcapbot.CoinTelegramBot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

@Configuration
public class AppConfig {



    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders httpHeaders(@Value("${coinmarketcap.api.key}") String apiKey) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("X-CMC_PRO_API_KEY", apiKey);
        return httpHeaders;
    }


    @Bean
    public TelegramBotsApi telegramBotsApi(@Value("${telegram.bot.token}") String token, CoinTelegramBot bot){
        DefaultBotSession defaultBotSession = new DefaultBotSession();
        defaultBotSession.setToken(token);
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(defaultBotSession.getClass());
            telegramBotsApi.registerBot(bot);
            System.out.println("start bot");
            return telegramBotsApi;
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

//    @Bean
//    public CoinTelegramBot coinTelegramBot(){
//        return  new CoinTelegramBot();
//    }

}
