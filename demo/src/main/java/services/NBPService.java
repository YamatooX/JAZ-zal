package services;

import models.Rate;
import models.Root;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class NBPService {
    private RestTemplate restTemplate;

    public NBPService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Root getAvgList(String currency, String startData, String endData) {
        String url = String.format("https://api.nbp.pl/api/exchangerates/rates/a/%s/%s/%s/?format=json", currency, startData, endData);
        return restTemplate.getForObject(url, Root.class);
    }
    // Coś tu popsułem i nie mogę dojść co tam jest nie tak. Nie wiem czemu jest provided int, skoro inicjując dałem Double
    public double getAvgCurrency(String currency, String startData, String endData) {
        Root root = getAvgList(currency, startData, endData);
        List<Rate> rates = root.getRates();
        Double sum = 0;
        for (Rate rate : rates) {
            sum += rate.getValue();
        }
        Double avg = sum / rates.size();
        return avg;
    }
}