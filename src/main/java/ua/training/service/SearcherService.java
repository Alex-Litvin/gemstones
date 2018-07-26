package ua.training.service;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;
import ua.training.model.Transparency;
import ua.training.service.interfaces.Searcher;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearcherService implements Searcher {
    @Override
    public List<Gemstone> findGemstonesByTransparency(Necklace necklace, Transparency...transparencies) {
        int count = transparencies.length;
        Stream<Gemstone> gemstones = necklace.getNecklace().stream();
        List<Gemstone> gemstoneList = null;
        switch (count) {
            case 1:
                gemstoneList = gemstones
                        .filter(gemstone -> gemstone.getTransparency().equals(transparencies[0]))
                        .collect(Collectors.toList());
                break;
            case 2:
                gemstoneList = gemstones
                        .filter(gemstone -> gemstone.getTransparency().equals(transparencies[0])
                                || gemstone.getTransparency().equals(transparencies[1]))
                        .collect(Collectors.toList());
                break;
            case 3:
                gemstoneList = gemstones
                        .filter(gemstone -> gemstone.getTransparency().equals(transparencies[0])
                                || gemstone.getTransparency().equals(transparencies[1])
                                || gemstone.getTransparency().equals(transparencies[2]))
                        .collect(Collectors.toList());
                break;
        }
        return gemstoneList;
    }
}
