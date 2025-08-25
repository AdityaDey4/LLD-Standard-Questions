package DigitalWalletService;

import java.util.HashMap;
import java.util.Map;

import DigitalWalletService.Enum.Currency;

public class CurrencyConverter {
    private static  Map<String, Double> exchangeRates = new HashMap<>();

    public CurrencyConverter() {

        exchangeRates.put("INR-USD", 0.012);
        exchangeRates.put("USD-INR", 83.0);
        exchangeRates.put("USD-EUR", 0.91);
        exchangeRates.put("EUR-USD", 1.1);
        exchangeRates.put("EUR-INR", 0.008);
        exchangeRates.put("INR-EUR", 92.12);
    }

    public double convert(double amount, Currency from, Currency to) {
        if (from == to) return amount;
        String key = from.name() + "-" + to.name();
        if (!exchangeRates.containsKey(key)) throw new RuntimeException("Rate not available");
        return amount * exchangeRates.get(key);
    }
}
