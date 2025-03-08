package basics.currencyconverter;

public class Converter {
    private static final double EXCHANGE_RATE = 87.5;

    public static double convertAudToNrs(double aud) {
        return aud * EXCHANGE_RATE;
    }
}
