package io.edgedev.crypex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by OPEYEMI OLORUNLEKE on 10/25/2017.
 */

public class Singleton {
    private static Singleton mSingleton;
    private Map<String, Currency> supported_currencies = new HashMap<>();
    private List<Currency> mListBTC = new ArrayList<>();
    private List<Currency> mListEther = new ArrayList<>();

    private Singleton() {
        setSupported_currencies();
    }

    public static Singleton getInstance() {
        if (mSingleton == null) mSingleton = new Singleton();
        return mSingleton;
    }

    public void setSupported_currencies() {
        supported_currencies.put("JPY", putCurrency("Japanese Yen", "¥"));
        supported_currencies.put("CNY", putCurrency("Chinese Yuan","¥"));
        supported_currencies.put("INR", putCurrency("Indian Rupees","R"));
        supported_currencies.put("SGD", putCurrency("Singapore Dollar","$"));
        supported_currencies.put("TWD", putCurrency("Taiwan Dollar","NT$"));
        supported_currencies.put("USD", putCurrency("US Dollar","$"));
        supported_currencies.put("BHD", putCurrency("Bahrain Dinar","D"));
        supported_currencies.put("EUR", putCurrency("Euro","€"));
        supported_currencies.put("GBP", putCurrency("British Pounds","£"));
        supported_currencies.put("RUB", putCurrency("Russian Rubles","\u20BD"));
        supported_currencies.put("ZAR", putCurrency("South African Rand","R"));
        supported_currencies.put("MXN", putCurrency("Mexican Peso","$"));
        supported_currencies.put("OMR", putCurrency("Omani Rial","﷼"));
        supported_currencies.put("MYR", putCurrency("Malaysian Ringgit","RM"));
        supported_currencies.put("NZD", putCurrency("New Zealand Dollar","$"));
        supported_currencies.put("SEK", putCurrency("Swedish Krona","kr"));
        supported_currencies.put("CHF", putCurrency("Swiss Franc","CHF"));
        supported_currencies.put("NOK", putCurrency("Norwegian Krone","kr"));
        supported_currencies.put("BRL", putCurrency("Brazillian Real","R$"));
        supported_currencies.put("TRY", putCurrency("Turkish Lira","₺"));
        supported_currencies.put("ETH", putCurrency("Ethereum","Ξ"));
        supported_currencies.put("BTC", putCurrency("BitCoin","Ƀ"));
        supported_currencies.put("NGN", putCurrency("Nigerian Naira","₦"));
        supported_currencies.put("AUD", putCurrency("Australian Dollar","$"));
        supported_currencies.put("HKD", putCurrency("Hong Kong Dollar","$"));
    }

    public Currency getCurrency(String key) {
        return supported_currencies.get(key);
    }

    private Currency putCurrency(String name, String sign) {
        return new Currency(name, sign);
    }

    public void setListBTC(List<Currency> listBTC) {
        mListBTC = listBTC;
    }

    public List<Currency> getListBTC() {
        return mListBTC;
    }

    public void setListEther(List<Currency> listEther) {
        mListEther = listEther;
    }

    public List<Currency> getListEther() {
        return mListEther;
    }
}
