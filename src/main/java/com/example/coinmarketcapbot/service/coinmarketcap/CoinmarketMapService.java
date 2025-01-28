package com.example.coinmarketcapbot.service.coinmarketcap;

import com.example.coinmarketcapbot.model.AnswerCoinmarketcap;
import com.example.coinmarketcapbot.model.compAnswer.Coin;
import com.example.coinmarketcapbot.service.RestTemplateService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CoinmarketMapService {

    private List<Coin> newCoins = new ArrayList<>();
    @Value(value = "${coinmarketcap.url.map}")
    private String url;

    private final SaveToFile saveToFile;
    private final RestTemplateService restTemplateService;

    public CoinmarketMapService(RestTemplateService restTemplateService, SaveToFile saveToFile) {
        this.restTemplateService = restTemplateService;
        this.saveToFile = saveToFile;
    }

//    @PostConstruct
    private List<Coin> getCoinsFromURLMap(Map<String, String> parameters) {
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("listing_status","active");
//        parameters.put("symbol", "USDT,USDC,ETH");
//        parameters.put("symbol", "USDC");
//        parameters.put("sort","cmc_rank");
//        parameters.put("limit","200");

        String response = restTemplateService.getResponseFromURL(url, parameters);
        AnswerCoinmarketcap coinmarketcap = (AnswerCoinmarketcap) restTemplateService.convertJsonToObject(response, AnswerCoinmarketcap.class);
//        findNewCoins();
        return coinmarketcap.getData();
    }

    private void findNewCoins() {
// получение с файла всех сохраненных монет
        ArrayList<Coin> coinsInFile = new ArrayList<>(saveToFile.readCoins());
        // запрос на получение с сайта
        String response = restTemplateService.getResponseFromURL(url, Collections.emptyMap());
        AnswerCoinmarketcap coinmarketcap = (AnswerCoinmarketcap) restTemplateService.convertJsonToObject(response, AnswerCoinmarketcap.class);

        ArrayList<Coin> coinArrayList = new ArrayList<>(coinmarketcap.getData());
//        TODO переделать проверку на наличие новых элементов
        for (int i = 0; i < coinArrayList.size(); i++) {
            for (int j = 0; j < coinsInFile.size(); j++) {

                if (coinArrayList.get(i).getId() == coinsInFile.get(j).getId()
                        && coinArrayList.get(i).getName().equals(coinsInFile.get(j).getName())) {
                    coinArrayList.remove(i);
                }
            }
        }
        coinsInFile.addAll(coinArrayList);
        saveToFile.writeCoins(coinsInFile);

        System.out.println(coinArrayList.get(0));

        System.out.println(coinArrayList.size() + " size ");
    }

}

