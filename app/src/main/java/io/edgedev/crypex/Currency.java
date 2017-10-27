package io.edgedev.crypex;

import java.text.DecimalFormat;

/**
 * Created by OPEYEMI OLORUNLEKE on 10/25/2017.
 */

public class Currency {
    private String name;
    private String sign;
    private Double value;
    private final DecimalFormat formatDouble = new DecimalFormat("#,###.##");
    private String exhange;


    public Currency() {
    }

    public Currency(String name, String sign) {
        this.name = name;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setValue(Double value) {
        this.value = value;
        exhange = getSign()+formatIt(value);
    }

    public Double getValue() {
        return value;
    }
    private String formatIt(Double d) {
        return formatDouble.format(d);
    }

    public String getExhange() {
        return exhange;
    }
}
