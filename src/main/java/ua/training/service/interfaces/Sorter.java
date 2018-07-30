package ua.training.service.interfaces;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;

import java.util.List;

public interface Sorter {
    List<Gemstone> sortedGemstoneByCost(Necklace necklace);
}
