package com.example.coinmarketcapbot;

import com.example.coinmarketcapbot.config.BotPropConfig;
import com.example.coinmarketcapbot.model.telegram.ParamsForUrlMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Component
public class CoinTelegramBot extends TelegramLongPollingBot {
    private final BotPropConfig botPropConfig;

    @Value("${telegram.bot.token}")
    private String token;
    @Value("${telegram.bot.username}")
    private String username;

    public CoinTelegramBot(BotPropConfig botPropConfig) {
        this.botPropConfig = botPropConfig;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/start")) {
                System.out.println(getBotUsername());
                sendTextMessage(chatId, "Добро пожаловать! Нажмите 'Все Монеты' для выбора.");
            } else if (messageText.equals("Все Монеты")) {
                System.out.println(" come to all coins");
            } else {
                sendTextMessage(chatId, "Команда не распознана.");
            }
        }
    }

    private void sendTextMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);

        try {
            execute(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public String getBotUsername() {
        return  username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

}
