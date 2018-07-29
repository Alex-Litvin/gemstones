package ua.training.service;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;
import ua.training.service.interfaces.WeightCalculator;

import java.math.BigDecimal;

public class WeightCalculatorService implements WeightCalculator {

    @Override
    public BigDecimal calculateWeight(Necklace necklace) {
        return necklace.getGemstones().stream()
                .map(Gemstone::getCarat)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
