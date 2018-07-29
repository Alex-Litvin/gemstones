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

    public NecklaceServiceImpl() {
        this.dbNecklace = DBNecklaceMock.getDbNecklace();
    }

    @Override
    public void addGemstoneToNecklace(Gemstone gemstone) {
        userGemstones.add(gemstone);
    }

    @Override
    public void createNecklace() {
        dbNecklace.addNecklace(new Necklace(new ArrayList<>(userGemstones)));
        userGemstones.clear();
    }
}
