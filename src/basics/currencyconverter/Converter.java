package basics.currencyconverter;

public class Converter {
    private static final double NRS = 87.5;

    private static final double IRS = 54.64;

    private static final double USD = 0.63;

    public static double convertAudToNrs(double aud) {
        return aud * NRS;
    }
    public static double convertAudToIrs(double aud){
        return aud * IRS;
    }

    public static double convertAudToUsd(double aud) {
        return aud * USD;
    }


}


