package ua.training.model;

import java.math.BigDecimal;

public enum Transparency {
    TRANSPARENT(new BigDecimal("1.2")),
    SEMITRANSPARENT(new BigDecimal("1")),
    NON_TRANSPARENT(new BigDecimal("0.8"));

    private BigDecimal costFactor;

    Transparency(BigDecimal costFactor) {
        this.costFactor = costFactor;
    }

    public BigDecimal getCostFactor() {
        return costFactor;
    }
}
