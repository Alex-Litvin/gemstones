package ua.training.service.interfaces;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;

import java.math.BigDecimal;
import java.util.List;

public interface WeightCalculator {
    BigDecimal calculateWeight(Necklace necklace);
    List<Gemstone> getGemstoneList(Necklace necklace);
}
