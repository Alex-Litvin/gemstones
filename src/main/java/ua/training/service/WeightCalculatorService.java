package ua.training.service;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;
import ua.training.service.interfaces.WeightCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WeightCalculatorService implements WeightCalculator {

    @Override
    public BigDecimal calculateWeight(Necklace necklace) {
        return necklace.getGemstones().stream()
                .map(Gemstone::getCarat)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public List<Gemstone> getGemstoneList(Necklace necklace) {
        return new ArrayList<>(necklace.getGemstones());
    }
}
