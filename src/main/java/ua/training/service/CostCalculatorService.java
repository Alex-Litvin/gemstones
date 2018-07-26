package ua.training.service;

import ua.training.model.Necklace;
import ua.training.service.interfaces.CostCalculator;

import java.math.BigDecimal;

public class CostCalculatorService implements CostCalculator {

    @Override
    public BigDecimal calculateCostNecklace(Necklace necklace) {
        return necklace.getNecklace().stream()
                .map(g -> calculateCostOneGemstone(g.getCarat(), g.getCaratPrice()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal calculateCostOneGemstone(BigDecimal carat, BigDecimal price) {
        return carat.multiply(price);
    }
}
