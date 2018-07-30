package ua.training.model;

import java.math.BigDecimal;
import java.util.Map;

public class Gemstone {
    private Map<StoneName, GemstoneType> nameTypeMap;
    private BigDecimal carat;
    private BigDecimal caratPrice;
    private BigDecimal totalCost;
    private Transparency transparency;

    public Gemstone() {

    }

    public Gemstone(Map<StoneName, GemstoneType> nameTypeMap, BigDecimal carat, BigDecimal caratPrice, BigDecimal totalCost, Transparency transparency) {
        this.nameTypeMap = nameTypeMap;
        this.carat = carat;
        this.caratPrice = caratPrice;
        this.totalCost = totalCost;
        this.transparency = transparency;
    }

    public Map<StoneName, GemstoneType> getNameTypeMap() {
        return nameTypeMap;
    }

    public BigDecimal getCarat() {
        return carat;
    }

    public BigDecimal getCaratPrice() {
        return caratPrice;
    }

    public Transparency getTransparency() {
        return transparency;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public static class GemstoneBuilder {
        private Map<StoneName, GemstoneType> nameTypeMap;
        private BigDecimal carat;
        private BigDecimal caratPrice;
        private BigDecimal totalCost;
        private Transparency transparency;

        public GemstoneBuilder setNameTypeMap(Map<StoneName, GemstoneType> nameTypeMap) {
            this.nameTypeMap = nameTypeMap;
            return this;
        }

        public GemstoneBuilder setCarat(BigDecimal carat) {
            this.carat = carat;
            return this;
        }

        public GemstoneBuilder setCaratPrice(BigDecimal caratPrice) {
            this.caratPrice = caratPrice;
            return this;
        }

        public GemstoneBuilder setTransparency(Transparency transparency) {
            this.transparency = transparency;
            return this;
        }

        public GemstoneBuilder setTotalCost(BigDecimal totalCost) {
            this.totalCost = totalCost;
            return this;
        }

        public Gemstone build() {
            return new Gemstone(nameTypeMap, carat, caratPrice, totalCost, transparency);
        }
    }

    @Override
    public String toString() {
        return nameTypeMap + ", carat = " + carat + ", carat/price = " + caratPrice +
                ", totalCost = " + totalCost + ", " + transparency;
    }
}
