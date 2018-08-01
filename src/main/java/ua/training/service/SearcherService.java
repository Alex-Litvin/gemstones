package ua.training.service;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;
import ua.training.model.Transparency;
import ua.training.service.interfaces.Searcher;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearcherService implements Searcher {
    @Override
    public List<Gemstone> findGemstonesByTransparency(Necklace necklace, List<Predicate<Transparency>> predicates) {
        return necklace.getGemstones().stream()
                .filter(gemstone -> predicates.stream().anyMatch(f -> f.test(gemstone.getTransparency())))
                .collect(Collectors.toList());
    }
}
