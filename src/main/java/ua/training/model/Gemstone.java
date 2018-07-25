package ua.training.model;

import java.math.BigDecimal;
import java.util.Map;

public class Gemstone {
    private Map<StoneName, Gemstone> nameTypeMap;
    private BigDecimal carat;
    private BigDecimal caratPrice;
    private Transparency transparency;

    public Map<StoneName, Gemstone> getNameTypeMap() {
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

    private Gemstone(Map<StoneName, Gemstone> nameTypeMap, BigDecimal carat, BigDecimal caratPrice, Transparency transparency) {
        this.nameTypeMap = nameTypeMap;
        this.carat = carat;
        this.caratPrice = caratPrice;
        this.transparency = transparency;
    }

    public static class GemstoneBuilder {
        private Map<StoneName, Gemstone> nameTypeMap;
        private BigDecimal carat;
        private BigDecimal caratPrice;
        private Transparency transparency;

        public GemstoneBuilder setNameTypeMap(Map<StoneName, Gemstone> nameTypeMap) {
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

        public Gemstone build() {
            return new Gemstone(nameTypeMap, carat, caratPrice, transparency);
        }
    }
}