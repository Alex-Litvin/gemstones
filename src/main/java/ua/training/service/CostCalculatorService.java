package ua.training.service;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;
import ua.training.service.interfaces.CostCalculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CostCalculatorService implements CostCalculator {

    @Override
    public BigDecimal calcCostNecklace(Necklace necklace) {
        return necklace.getGemstones().stream()
                .map(Gemstone::getTotalCost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal calcCostOneGemstone(BigDecimal carat, BigDecimal price, BigDecimal costFactor) {
        return carat.multiply(price).multiply(costFactor, new MathContext(2));
    }

    @Override
    public Map<Gemstone, BigDecimal> getGemstonePriceMap(Necklace necklace) {
        return necklace.getGemstones().stream()
                .collect(Collectors.toMap(Function.identity(), Gemstone::getTotalCost));

    }
}
