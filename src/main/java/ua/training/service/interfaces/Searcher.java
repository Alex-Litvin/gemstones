package ua.training.service.interfaces;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;
import ua.training.model.Transparency;

import java.util.List;

public interface Searcher {
    List<Gemstone> findGemstonesByTransparency(Necklace necklace, List<Transparency> transparencies);
}
