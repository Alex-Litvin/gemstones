package ua.training.service;

import ua.training.model.Necklace;
import ua.training.service.interfaces.CostCalculator;

import java.math.BigDecimal;

public class CostCalculatorService implements CostCalculator {

    @Override
    public BigDecimal calcCostNecklace(Necklace necklace) {
        return necklace.getGemstones().stream()
                .map(g -> calcCostOneGemstone(g.getCarat(), g.getCaratPrice(), g.getTransparency().getCostFactor()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal calcCostOneGemstone(BigDecimal carat, BigDecimal price, BigDecimal costFactor) {
        return carat.multiply(price).multiply(costFactor);
    }
}
