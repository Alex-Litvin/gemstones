package ua.training.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.model.Gemstone;
import ua.training.model.GemstoneType;
import ua.training.model.Necklace;
import ua.training.model.StoneName;
import ua.training.service.interfaces.WeightCalculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static ua.training.model.GemstoneType.PRECIOUS;
import static ua.training.model.GemstoneType.SEMIPRECIOUS;
import static ua.training.model.StoneName.*;
import static ua.training.model.Transparency.*;

public class WeightCalculatorServiceTest {
    private WeightCalculator weightCalculator;
    private Necklace necklace;
    private Gemstone diamond;
    private Gemstone topaz;
    private Gemstone ruby;

    @Before
    public void setUp() {
        weightCalculator = new WeightCalculatorService();
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
    public void whenCalculatedWeightEqualsExpectedThenResultIsTrue() {
        BigDecimal calculatedWeight = weightCalculator.calculateWeight(necklace);
        BigDecimal expectedWeight = new BigDecimal("6.5");

        Assert.assertEquals(0, calculatedWeight.compareTo(expectedWeight));
    }
}