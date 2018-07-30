package ua.training.service;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;
import ua.training.service.interfaces.Sorter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SorterService implements Sorter {

    @Override
    public List<Gemstone> sortedGemstoneByCost(Necklace necklace) {
        return necklace.getGemstones().stream()
                .sorted(Comparator.comparing(Gemstone::getTotalCost))
                .collect(Collectors.toList());
    }
}



