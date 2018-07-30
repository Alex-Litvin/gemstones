package ua.training.service.interfaces;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;

import java.math.BigDecimal;
import java.util.Map;

public interface CostCalculator {
    BigDecimal calcCostNecklace(Necklace necklace);
    BigDecimal calcCostOneGemstone(BigDecimal carat, BigDecimal price, BigDecimal costFactor);
    Map<Gemstone, BigDecimal> getGemstonePriceMap(Necklace necklace);
}
