package ua.training.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.model.*;
import ua.training.service.interfaces.Searcher;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;

import static ua.training.model.GemstoneType.PRECIOUS;
import static ua.training.model.GemstoneType.SEMIPRECIOUS;
import static ua.training.model.StoneName.*;
import static ua.training.model.Transparency.*;


public class SearcherServiceTest {
    private Searcher searcher;
    private Necklace necklace;
    private Gemstone diamond;
    private Gemstone topaz;
    private Gemstone ruby;


    @Before
    public void setUp() {
        searcher = new SearcherService();
        necklace = new Necklace();
        Map<StoneName, GemstoneType> diamondMap = new HashMap<>();
        diamondMap.put(DIAMOND, PRECIOUS);
        diamond = new Gemstone.GemstoneBuilder()
                .setNameTypeMap(diamondMap)
                .setCarat(new BigDecimal("3"))
                .setCaratPrice(new BigDecimal("800"))
                .setTransparency(TRANSPARENT)
                .setTotalCost(new BigDecimal("2880"))
                .build();
        Map<StoneName, GemstoneType> topazMap = new HashMap<>();
        topazMap.put(TOPAZ, SEMIPRECIOUS);
        topaz = new Gemstone.GemstoneBuilder()
                .setNameTypeMap(topazMap)
                .setCarat(new BigDecimal("2"))
                .setCaratPrice(new BigDecimal("200"))
                .setTransparency(SEMITRANSPARENT)
                .setTotalCost(new BigDecimal("400"))
                .build();
        Map<StoneName, GemstoneType> rubyMap = new HashMap<>();
        rubyMap.put(RUBY, PRECIOUS);
        ruby = new Gemstone.GemstoneBuilder()
                .setNameTypeMap(rubyMap)
                .setCarat(new BigDecimal("1.5"))
                .setCaratPrice(new BigDecimal("780"))
                .setTransparency(NON_TRANSPARENT)
                .setTotalCost(new BigDecimal("936"))
                .build();
        necklace.setId(1);
        necklace.setGemstones(Arrays.asList(diamond, topaz, ruby));
    }

    @Test
    public void whenSearchParameterIsTransparentThenResultIsTrue() {
        List<Predicate<Transparency>> parameters = Collections.singletonList(g -> g.equals(TRANSPARENT));
        List<Gemstone> searchResult = searcher.findGemstonesByTransparency(necklace, parameters);

        Assert.assertEquals(searchResult, Collections.singletonList(diamond));
    }

    @Test
    public void whenSearchParametersAreTransparentAndSemitransparentThenResultIsTrue() {
        List<Predicate<Transparency>> parameters = Arrays.asList(
                g -> g.equals(TRANSPARENT),
                g -> g.equals(SEMITRANSPARENT));
        List<Gemstone> searchResult = searcher.findGemstonesByTransparency(necklace, parameters);

        Assert.assertEquals(searchResult, Arrays.asList(diamond, topaz));
    }

    @Test
    public void whenSearchParametersAreTransparentSemitransparentNontransparentThenResultIsTrue() {
        List<Predicate<Transparency>> parameters = Arrays.asList(
                g -> g.equals(TRANSPARENT),
                g -> g.equals(SEMITRANSPARENT),
                g -> g.equals(NON_TRANSPARENT));
        List<Gemstone> searchResult = searcher.findGemstonesByTransparency(necklace, parameters);

        Assert.assertEquals(searchResult, Arrays.asList(diamond, topaz, ruby));
    }
}