package ua.training.service.interfaces;

import ua.training.model.Necklace;

import java.math.BigDecimal;

public interface CostCalculator {
    BigDecimal calculateCostNecklace(Necklace necklace);
    BigDecimal calculateCostOneGemstone(BigDecimal carat, BigDecimal price);
}
