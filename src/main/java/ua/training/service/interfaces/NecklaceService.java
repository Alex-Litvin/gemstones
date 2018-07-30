package ua.training.service.interfaces;

import ua.training.model.Gemstone;

import java.util.List;

public interface NecklaceService {
    void addGemstoneToNecklace(Gemstone gemstone);
    List<Gemstone> createNecklace();
}
