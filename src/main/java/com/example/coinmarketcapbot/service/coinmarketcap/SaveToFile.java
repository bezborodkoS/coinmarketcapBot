package com.example.coinmarketcapbot.service.coinmarketcap;

import com.example.coinmarketcapbot.model.compAnswer.Coin;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SaveToFile {
    @Value(value = "${coinmarketcap.file}")
    private  String FILE_PATH ;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Coin> readCoins() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(file, new TypeReference<List<Coin>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Failed to read coins from file ERROR", e);
        }
    }

    public void writeCoins(List<Coin> courses) {
        try {
            for (Coin coin : courses) {

            }
            readCoins();
            System.out.println("write");
            objectMapper.writeValue(new File(FILE_PATH), courses);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write coins to file ERROR", e);
        }
    }


}
