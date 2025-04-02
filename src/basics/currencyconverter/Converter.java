package basics.currencyconverter;

import java.util.HashMap;
import java.util.Map;

public class Converter {

    private static final Map<String, Double> exchangeRate = new HashMap<>();

    static {
        exchangeRate.put("AUD_NPR", 87.5);
        exchangeRate.put("AUD_INR", 54.6);
        exchangeRate.put("AUD_USD", 0.63);
        exchangeRate.put("AUD_AUD", 1.0);

        exchangeRate.put("NPR_AUD", 0.012);
        exchangeRate.put("NPR_INR", 0.624);
        exchangeRate.put("NPR_USD", 0.007);
        exchangeRate.put("NPR_NPR", 1.0);

        exchangeRate.put("INR_AUD", 0.019);
        exchangeRate.put("INR_NPR", 1.60);
        exchangeRate.put("INR_USD", 0.012);
        exchangeRate.put("INR_INR", 1.0);

        exchangeRate.put("USD_AUD", 1.6);
        exchangeRate.put("USD_NPR", 137.12);
        exchangeRate.put("USD_INR", 85.61);
        exchangeRate.put("USD_USD", 1.0);

    }

    public static double convert(String from, String to, double amount) {
        String key = from + "_" + to;
        if (exchangeRate.containsKey(key)) {
            return amount * exchangeRate.get(key);
        } else {
            return -1;
        }
    }


}


