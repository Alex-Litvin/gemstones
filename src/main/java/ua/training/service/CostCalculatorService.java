package ua.training.service;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;
import ua.training.service.interfaces.CostCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CostCalculatorService implements CostCalculator {

    @Override
    public BigDecimal calcCostNecklace(Necklace necklace) {
        return necklace.getGemstones().stream()
                .map(Gemstone::getTotalCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal calcCostOneGemstone(BigDecimal carat, BigDecimal price, BigDecimal costFactor) {
        return carat.multiply(price).multiply(costFactor);
    }

    @Override
    public List<Gemstone> getGemstoneList(Necklace necklace) {
        return new ArrayList<>(necklace.getGemstones());

    }
}
