package ua.training.service.interfaces;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;

import java.math.BigDecimal;
import java.util.List;

public interface CostCalculator {
    BigDecimal calcCostNecklace(Necklace necklace);
    BigDecimal calcCostOneGemstone(BigDecimal carat, BigDecimal price, BigDecimal costFactor);
    List<Gemstone> getGemstoneList(Necklace necklace);
}
