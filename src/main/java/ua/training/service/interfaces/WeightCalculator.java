package ua.training.service.interfaces;

import ua.training.model.Necklace;

import java.math.BigDecimal;

public interface WeightCalculator {
    BigDecimal calculateWeight(Necklace necklace);
}
