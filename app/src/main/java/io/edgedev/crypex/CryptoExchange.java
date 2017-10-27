package io.edgedev.crypex;

/**
 * Created by OPEYEMI OLORUNLEKE on 10/10/2017.
 */

public class CryptoExchange {
    private String currencyName;
    private long exchangerate;

    public CryptoExchange() {
    }

    public CryptoExchange(String currencyName, int exchangerate) {
        this.currencyName = currencyName;
        this.exchangerate = exchangerate;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getExchangerate() {
        return  ""+exchangerate;
    }
}
