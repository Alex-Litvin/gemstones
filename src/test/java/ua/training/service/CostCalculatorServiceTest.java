package ua.training.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.training.model.Gemstone;
import ua.training.model.GemstoneType;
import ua.training.model.Necklace;
import ua.training.model.StoneName;
import ua.training.service.interfaces.CostCalculator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static ua.training.model.GemstoneType.PRECIOUS;
import static ua.training.model.GemstoneType.SEMIPRECIOUS;
import static ua.training.model.StoneName.DIAMOND;
import static ua.training.model.StoneName.TOPAZ;
import static ua.training.model.Transparency.SEMITRANSPARENT;
import static ua.training.model.Transparency.TRANSPARENT;

public class CostCalculatorServiceTest {
    private CostCalculator costCalculator;

    @Before
    public void setUp() {
        costCalculator = new CostCalculatorService();
    }

    @Test
    public void whenSumTotalCostGemstonesThenResultIs3280() {
        Necklace necklace = new Necklace();
        Map<StoneName, GemstoneType> diamondMap = new HashMap<>();
        diamondMap.put(DIAMOND, PRECIOUS);
        Gemstone diamond = new Gemstone.GemstoneBuilder()
                .setNameTypeMap(diamondMap)
                .setCarat(new BigDecimal("3"))
                .setCaratPrice(new BigDecimal("800"))
                .setTransparency(TRANSPARENT)
                .setTotalCost(new BigDecimal("2880"))
                .build();
        Map<StoneName, GemstoneType> topazMap = new HashMap<>();
        topazMap.put(TOPAZ, SEMIPRECIOUS);
        Gemstone topaz = new Gemstone.GemstoneBuilder()
                .setNameTypeMap(topazMap)
                .setCarat(new BigDecimal("2"))
                .setCaratPrice(new BigDecimal("200"))
                .setTransparency(SEMITRANSPARENT)
                .setTotalCost(new BigDecimal("400"))
                .build();
        necklace.setId(1);
        necklace.setGemstones(Arrays.asList(diamond, topaz));

        Assert.assertThat(costCalculator.calcCostNecklace(necklace), is(new BigDecimal("3280")));
    }

    @Test
    public void whenGemstoneTotalCostIs2880ThenResultIsTrue() {
        Map<StoneName, GemstoneType> diamondMap = new HashMap<>();
        diamondMap.put(DIAMOND, PRECIOUS);
        Gemstone diamond = new Gemstone.GemstoneBuilder()
                .setNameTypeMap(diamondMap)
                .setCarat(new BigDecimal("3"))
                .setCaratPrice(new BigDecimal("800"))
                .setTransparency(TRANSPARENT)
                .setTotalCost(new BigDecimal("2880"))
                .build();
        BigDecimal cost = costCalculator.calcCostOneGemstone(diamond.getCarat(),
                diamond.getCaratPrice(),
                diamond.getTransparency().getCostFactor());

        Assert.assertEquals(0, cost.compareTo(new BigDecimal("2880")));
    }
}