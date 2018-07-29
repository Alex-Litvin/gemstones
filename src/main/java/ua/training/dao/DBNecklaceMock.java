package ua.training.dao;

import ua.training.model.Gemstone;
import ua.training.model.Necklace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DBNecklaceMock {
    private static DBNecklaceMock dbNecklace = new DBNecklaceMock();
    private List<Necklace> necklaces;

    public List<Necklace> getNecklaces() {
        return necklaces;
    }

    private DBNecklaceMock() {
        necklaces = new ArrayList<>();
    }

    public static DBNecklaceMock getDbNecklace() {
        return dbNecklace;
    }

    public void addNecklace(Necklace necklace) {
        necklaces.add(necklace);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        necklace.getGemstones().stream()
                .map(Gemstone::toString)
                .forEach(System.out::println);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");

        necklaces.stream()
                .map(Necklace::getGemstones)
                .flatMap(Collection::stream)
                .map(Gemstone::toString)
                .forEach(System.out::println);

    }
}
