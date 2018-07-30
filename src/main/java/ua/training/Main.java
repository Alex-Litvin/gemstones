package ua.training;

import ua.training.model.Gemstone;
import ua.training.model.GemstoneType;
import ua.training.model.Necklace;
import ua.training.model.StoneName;
import ua.training.service.CostCalculatorService;
import ua.training.service.SearcherService;
import ua.training.service.SorterService;
import ua.training.service.WeightCalculatorService;
import ua.training.service.interfaces.CostCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ua.training.dao.DBNameTypeGemstoneMock.getNameTypeGemstone;
import static ua.training.model.StoneName.*;
import static ua.training.model.Transparency.*;

public class Main {
    public static void main(String[] args) {
        testCostAndWeightCalculatorServices();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        testSearcherService();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        testSorterService();
    }

    public static void testSorterService() {
        CostCalculator calculator = new CostCalculatorService();
        SorterService sorter = new SorterService();
        List<Gemstone> gemstones = new ArrayList<>();

        Map<StoneName, GemstoneType> map1 = new HashMap<>();
        map1.put(DIAMOND, getNameTypeGemstone().get(DIAMOND));
        Map<StoneName, GemstoneType> map2 = new HashMap<>();
        map2.put(RUBY, getNameTypeGemstone().get(RUBY));
        Map<StoneName, GemstoneType> map3 = new HashMap<>();
        map3.put(TOPAZ, getNameTypeGemstone().get(TOPAZ));
        Map<StoneName, GemstoneType> map4 = new HashMap<>();
        map4.put(TOURMALINE, getNameTypeGemstone().get(TOURMALINE));

        gemstones.add(new Gemstone.GemstoneBuilder()
                .setNameTypeMap(map1)
                .setCarat(new BigDecimal("0.44"))
                .setCaratPrice(new BigDecimal("100"))
                .setTransparency(TRANSPARENT)
                .build());


        gemstones.add(new Gemstone.GemstoneBuilder()
                .setNameTypeMap(map2)
                .setCarat(new BigDecimal("0.66"))
                .setCaratPrice(new BigDecimal("200"))
                .setTransparency(SEMITRANSPARENT)
                .build());

        gemstones.add(new Gemstone.GemstoneBuilder()
                .setNameTypeMap(map3)
                .setCarat(new BigDecimal("0.50"))
                .setCaratPrice(new BigDecimal("50"))
                .setTransparency(NON_TRANSPARENT)
                .build());

        gemstones.add(new Gemstone.GemstoneBuilder()
                .setNameTypeMap(map4)
                .setCarat(new BigDecimal("0.44"))
                .setCaratPrice(new BigDecimal("100"))
                .setTransparency(TRANSPARENT)
                .build());

        Necklace necklace1 = new Necklace(gemstones);

       sorter.sortedGemstoneByCost(necklace1);
    }

    public static void testSearcherService() {
        SearcherService searcher = new SearcherService();
        List<Gemstone> gemstones = new ArrayList<>();

        Map<StoneName, GemstoneType> map1 = new HashMap<>();
        map1.put(DIAMOND, getNameTypeGemstone().get(DIAMOND));
        Map<StoneName, GemstoneType> map2 = new HashMap<>();
        map2.put(RUBY, getNameTypeGemstone().get(RUBY));
        Map<StoneName, GemstoneType> map3 = new HashMap<>();
        map3.put(TOPAZ, getNameTypeGemstone().get(TOPAZ));
        Map<StoneName, GemstoneType> map4 = new HashMap<>();
        map4.put(TOURMALINE, getNameTypeGemstone().get(TOURMALINE));

        gemstones.add(new Gemstone.GemstoneBuilder()
                .setNameTypeMap(map1)
                .setCarat(new BigDecimal("0.44"))
                .setCaratPrice(new BigDecimal("100"))
                .setTransparency(TRANSPARENT)
                .build());


        gemstones.add(new Gemstone.GemstoneBuilder()
                .setNameTypeMap(map2)
                .setCarat(new BigDecimal("0.66"))
                .setCaratPrice(new BigDecimal("200"))
                .setTransparency(SEMITRANSPARENT)
                .build());

        gemstones.add(new Gemstone.GemstoneBuilder()
                .setNameTypeMap(map3)
                .setCarat(new BigDecimal("0.50"))
                .setCaratPrice(new BigDecimal("50"))
                .setTransparency(NON_TRANSPARENT)
                .build());

        gemstones.add(new Gemstone.GemstoneBuilder()
                .setNameTypeMap(map4)
                .setCarat(new BigDecimal("0.44"))
                .setCaratPrice(new BigDecimal("100"))
                .setTransparency(TRANSPARENT)
                .build());

        Necklace necklace1 = new Necklace(gemstones);

        List<Gemstone> gemstones1 = searcher.findGemstonesByTransparency(necklace1, TRANSPARENT, NON_TRANSPARENT);
        gemstones1.stream().map(gemstone -> gemstone.toString()).forEach(System.out::println);
    }

    public static void testCostAndWeightCalculatorServices() {
        CostCalculatorService costCalculator = new CostCalculatorService();
        WeightCalculatorService weightCalculator = new WeightCalculatorService();
        List<Gemstone> gemstones = new ArrayList<>();

        Map<StoneName, GemstoneType> map1 = new HashMap<>();
        map1.put(DIAMOND, getNameTypeGemstone().get(DIAMOND));
        Map<StoneName, GemstoneType> map2 = new HashMap<>();
        map2.put(RUBY, getNameTypeGemstone().get(RUBY));
        Map<StoneName, GemstoneType> map3 = new HashMap<>();
        map3.put(TOPAZ, getNameTypeGemstone().get(TOPAZ));
        Map<StoneName, GemstoneType> map4 = new HashMap<>();
        map4.put(TOURMALINE, getNameTypeGemstone().get(TOURMALINE));

        gemstones.add(new Gemstone.GemstoneBuilder()
                .setNameTypeMap(map1)
                .setCarat(new BigDecimal("0.44"))
                .setCaratPrice(new BigDecimal("100"))
                .setTransparency(TRANSPARENT)
                .build());


        gemstones.add(new Gemstone.GemstoneBuilder()
                .setNameTypeMap(map2)
                .setCarat(new BigDecimal("0.66"))
                .setCaratPrice(new BigDecimal("200"))
                .setTransparency(SEMITRANSPARENT)
                .build());

        gemstones.add(new Gemstone.GemstoneBuilder()
                .setNameTypeMap(map3)
                .setCarat(new BigDecimal("0.50"))
                .setCaratPrice(new BigDecimal("50"))
                .setTransparency(NON_TRANSPARENT)
                .build());

        gemstones.add(new Gemstone.GemstoneBuilder()
                .setNameTypeMap(map4)
                .setCarat(new BigDecimal("0.44"))
                .setCaratPrice(new BigDecimal("100"))
                .setTransparency(TRANSPARENT)
                .build());
        Necklace necklace = new Necklace(gemstones);

        BigDecimal cost = costCalculator.calcCostNecklace(necklace);
        BigDecimal weight = weightCalculator.calculateWeight(necklace);
        System.out.println(cost);
        System.out.println(weight);
    }
}
