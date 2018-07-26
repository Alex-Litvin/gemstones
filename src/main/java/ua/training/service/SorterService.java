package ua.training.service;

import ua.training.comparator.CostComparator;
import ua.training.model.Necklace;
import ua.training.service.interfaces.CostCalculator;
import ua.training.service.interfaces.Sorter;

public class SorterService implements Sorter {
    private CostCalculator calculator;

    public SorterService(CostCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void sortGemstoneByCost(Necklace necklace) {
        necklace.getNecklace().stream()
                .sorted(new CostComparator(calculator))
                .forEach(System.out::println);
    }
}
