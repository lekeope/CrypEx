package io.edgedev.crypex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OPEYEMI OLORUNLEKE on 10/27/2017.
 */

public class EtherResponse {
    @SerializedName("BTC")
    @Expose
    private Double bTC;
    @SerializedName("NGN")
    @Expose
    private Double nGN;
    @SerializedName("USD")
    @Expose
    private Double uSD;
    @SerializedName("EUR")
    @Expose
    private Double eUR;
    @SerializedName("GBP")
    @Expose
    private Double gBP;
    @SerializedName("CNY")
    @Expose
    private Double cNY;
    @SerializedName("JPY")
    @Expose
    private Double jPY;
    @SerializedName("INR")
    @Expose
    private Double iNR;
    @SerializedName("SGD")
    @Expose
    private Double sGD;
    @SerializedName("TWD")
    @Expose
    private Double tWD;
    @SerializedName("BHD")
    @Expose
    private Double bHD;
    @SerializedName("MXN")
    @Expose
    private Double mXN;
    @SerializedName("OMR")
    @Expose
    private Double oMR;
    @SerializedName("MYR")
    @Expose
    private Double mYR;
    @SerializedName("NZD")
    @Expose
    private Double nZD;
    @SerializedName("SEK")
    @Expose
    private Double sEK;
    @SerializedName("CHF")
    @Expose
    private Double cHF;
    @SerializedName("NOK")
    @Expose
    private Double nOK;
    @SerializedName("BRL")
    @Expose
    private Double bRL;
    @SerializedName("TRY")
    @Expose
    private Double tRY;
    @SerializedName("AUD")
    @Expose
    private Double aUD;
    @SerializedName("HKD")
    @Expose
    private Double hKD;
    @SerializedName("ZAR")
    @Expose
    private Double zAR;

    public Double getBTC() {
        return bTC;
    }

    public void setbTC(Double bTC) {
        this.bTC = bTC;
    }

    public Double getNGN() {
        return nGN;
    }

    public void setNGN(Double nGN) {
        this.nGN = nGN;
    }

    public Double getUSD() {
        return uSD;
    }

    public void setUSD(Double uSD) {
        this.uSD = uSD;
    }

    public Double getEUR() {
        return eUR;
    }

    public void setEUR(Double eUR) {
        this.eUR = eUR;
    }

    public Double getGBP() {
        return gBP;
    }

    public void setGBP(Double gBP) {
        this.gBP = gBP;
    }

    public Double getCNY() {
        return cNY;
    }

    public void setCNY(Double cNY) {
        this.cNY = cNY;
    }

    public Double getJPY() {
        return jPY;
    }

    public void setJPY(Double jPY) {
        this.jPY = jPY;
    }

    public Double getINR() {
        return iNR;
    }

    public void setINR(Double iNR) {
        this.iNR = iNR;
    }

    public Double getSGD() {
        return sGD;
    }

    public void setSGD(Double sGD) {
        this.sGD = sGD;
    }

    public Double getTWD() {
        return tWD;
    }

    public void setTWD(Double tWD) {
        this.tWD = tWD;
    }

    public Double getBHD() {
        return bHD;
    }

    public void setBHD(Double bHD) {
        this.bHD = bHD;
    }

    public Double getMXN() {
        return mXN;
    }

    public void setMXN(Double mXN) {
        this.mXN = mXN;
    }

    public Double getOMR() {
        return oMR;
    }

    public void setOMR(Double oMR) {
        this.oMR = oMR;
    }

    public Double getMYR() {
        return mYR;
    }

    public void setMYR(Double mYR) {
        this.mYR = mYR;
    }

    public Double getNZD() {
        return nZD;
    }

    public void setNZD(Double nZD) {
        this.nZD = nZD;
    }

    public Double getSEK() {
        return sEK;
    }

    public void setSEK(Double sEK) {
        this.sEK = sEK;
    }

    public Double getCHF() {
        return cHF;
    }

    public void setCHF(Double cHF) {
        this.cHF = cHF;
    }

    public Double getNOK() {
        return nOK;
    }

    public void setNOK(Double nOK) {
        this.nOK = nOK;
    }

    public Double getBRL() {
        return bRL;
    }

    public void setBRL(Double bRL) {
        this.bRL = bRL;
    }

    public Double getTRY() {
        return tRY;
    }

    public void setTRY(Double tRY) {
        this.tRY = tRY;
    }

    public Double getAUD() {
        return aUD;
    }

    public void setAUD(Double aUD) {
        this.aUD = aUD;
    }

    public Double getHKD() {
        return hKD;
    }

    public void setHKD(Double hKD) {
        this.hKD = hKD;
    }

    public Double getZAR() {
        return zAR;
    }

    public void setZAR(Double zAR) {
        this.zAR = zAR;
    }

    public List<Currency> getItems() {
        List<Currency> list = new ArrayList<>();
        list.add(addCurrency("BTC", getBTC()));
        list.add(addCurrency("NGN", getNGN()));
        list.add(addCurrency("USD", getUSD()));
        list.add(addCurrency("AUD", getAUD()));
        list.add(addCurrency("BHD", getBHD()));
        list.add(addCurrency("BRL", getBRL()));
        list.add(addCurrency("CHF", getCHF()));
        list.add(addCurrency("CNY", getCNY()));
        list.add(addCurrency("EUR", getEUR()));
        list.add(addCurrency("GBP", getGBP()));
        list.add(addCurrency("HKD", getHKD()));
        list.add(addCurrency("INR", getINR()));
        list.add(addCurrency("JPY", getJPY()));
        list.add(addCurrency("MXN", getMXN()));
        list.add(addCurrency("MYR", getMYR()));
        list.add(addCurrency("NOK", getNOK()));
        list.add(addCurrency("NZD", getNZD()));
        list.add(addCurrency("OMR", getOMR()));
        list.add(addCurrency("SEK", getSEK()));
        list.add(addCurrency("SGD", getSGD()));
        list.add(addCurrency("TRY", getTRY()));
        list.add(addCurrency("TWD", getTWD()));
        list.add(addCurrency("ZAR", getZAR()));
        return list;
    }
    /*private Currency addCurrency(String name, double value){
        return new Currency(name, value);
    }*/
    private Currency addCurrency(String key, double val) {
        Currency currency = Singleton.getInstance().getCurrency(key);
        currency.setValue(val);
        return currency;
    }
}
