package ua.training.service;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;
import ua.training.model.Transparency;
import ua.training.service.interfaces.Searcher;

import java.util.List;

public class SearcherService implements Searcher {

    @Override
    public List<Gemstone> findGemstonesByTransparency(Necklace necklace, Transparency... transparencies) {
        return null;
    }
}
