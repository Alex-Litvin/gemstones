package ua.training.comparator;

import ua.training.model.Gemstone;
import ua.training.service.interfaces.CostCalculator;

import java.util.Comparator;

public class CostComparator implements Comparator<Gemstone> {
    private CostCalculator calculator;

    public CostComparator(CostCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int compare(Gemstone stone1, Gemstone stone2) {
        return calculator.calculateCostOneGemstone(stone1.getCarat(), stone1.getCaratPrice())
                .compareTo(calculator.calculateCostOneGemstone(stone2.getCarat(), stone2.getCaratPrice()));
    }
}
