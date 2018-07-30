package ua.training.model;

import java.math.BigDecimal;

public enum StoneName {
    AQUAMARINE("Aquamarine", new BigDecimal("150")),
    GARNET("Garnet", new BigDecimal("170")),
    SARDONYX("Sardonyx", new BigDecimal("135")),
    TOPAZ("Topaz", new BigDecimal("200")),
    CHRYSOLITE("Chrysolite", new BigDecimal("120")),

    DIAMOND("Diamond", new BigDecimal("800")),
    EMERALD("Emerald", new BigDecimal("750")),
    RUBY("Ruby", new BigDecimal("780")),
    TOURMALINE("Tourmaline", new BigDecimal("670")),
    SPINEL("Spinel", new BigDecimal("600"));

    private String title;
    private BigDecimal caratPrice;

    StoneName(String title, BigDecimal caratPrice) {
        this.title = title;
        this.caratPrice = caratPrice;
    }

    public BigDecimal getCaratPrice() {
        return caratPrice;
    }
}
