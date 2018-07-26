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
    public int compare(Gemstone o1, Gemstone o2) {
        return calculator.calcCostOneGemstone(o1.getCarat(), o1.getCaratPrice(), o1.getTransparency().getCostFactor())
                .compareTo(calculator.calcCostOneGemstone(o2.getCarat(), o2.getCaratPrice(), o2.getTransparency().getCostFactor()));
    }
}
