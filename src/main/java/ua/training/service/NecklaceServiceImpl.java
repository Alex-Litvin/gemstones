package ua.training.service;

import ua.training.dao.DBNecklaceMock;
import ua.training.model.Gemstone;
import ua.training.model.Necklace;
import ua.training.service.interfaces.NecklaceService;

import java.util.ArrayList;
import java.util.List;

public class NecklaceServiceImpl implements NecklaceService {
    private DBNecklaceMock dbNecklace;
    private List<Gemstone> userGemstones = new ArrayList<>();
    private Integer necklaceId = 0;

    public NecklaceServiceImpl() {
        this.dbNecklace = DBNecklaceMock.getDbNecklace();
    }

    @Override
    public void addGemstoneToNecklace(Gemstone gemstone) {
        userGemstones.add(gemstone);
    }

    @Override
    public List<Gemstone> createNecklace() {
        Necklace necklace = new Necklace(new ArrayList<>(userGemstones));
        necklace.setId(++necklaceId);
        checkNecklace(necklace);
        dbNecklace.addNecklace(necklace);
        userGemstones.clear();

        return dbNecklace.getNecklaceById(necklaceId);
    }

    private void checkNecklace(Necklace necklace) {
        long necklaceCount = (long) dbNecklace.getNecklaces().size();
        if (necklaceCount == 1) {
            throw new IllegalArgumentException("You already create necklace!");
        }
        if (necklace.getGemstones().isEmpty()) {
            throw new IllegalArgumentException("Necklace must consist of at least one gemstone!");
        }
    }
}
