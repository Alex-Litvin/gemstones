package ua.training.service.interfaces;

import ua.training.model.Necklace;

import java.math.BigDecimal;

public interface CostCalculator {
    BigDecimal calcCostNecklace(Necklace necklace);
    BigDecimal calcCostOneGemstone(BigDecimal carat, BigDecimal price, BigDecimal costFactor);
}
