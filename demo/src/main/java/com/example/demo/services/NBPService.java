package com.example.demo.services;

import com.example.demo.models.Rate;
import com.example.demo.models.Root;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NBPService {
    private final RestTemplate restTemplate;

    public NBPService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Root getAvgList(String currency, String startData, String endData) {
        String url = String.format("https://api.nbp.pl/api/exchangerates/rates/a/%s/%s/%s/?format=json", currency, startData, endData);
        return restTemplate.getForObject(url, Root.class);
    }

    public double getAvgCurrency(String currency, String startData, String endData) {
        Root root = getAvgList(currency, startData, endData);
        List<Rate> rates = root.getRates();
        Double sum = 0;
//        for (Rate rate : rates) {
//            sum += rate.getValue();
//        }
        Double avg = sum / rates.size();
        return avg;
    }
}