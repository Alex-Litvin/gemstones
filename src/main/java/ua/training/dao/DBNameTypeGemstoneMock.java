package ua.training.dao;

import ua.training.model.GemstoneType;
import ua.training.model.StoneName;

import java.util.HashMap;
import java.util.Map;

import static ua.training.model.GemstoneType.PRECIOUS;
import static ua.training.model.GemstoneType.SEMIPRECIOUS;
import static ua.training.model.StoneName.*;

public class DBNameTypeGemstoneMock {
    private static final Map<StoneName, GemstoneType> NAME_TYPE_GEMSTONE = new HashMap<>();
    static {
        NAME_TYPE_GEMSTONE.put(AQUAMARINE, SEMIPRECIOUS);
        NAME_TYPE_GEMSTONE.put(GARNET, SEMIPRECIOUS);
        NAME_TYPE_GEMSTONE.put(SARDONYX, SEMIPRECIOUS);
        NAME_TYPE_GEMSTONE.put(TOPAZ, SEMIPRECIOUS);
        NAME_TYPE_GEMSTONE.put(CHRYSOLITE, SEMIPRECIOUS);
        NAME_TYPE_GEMSTONE.put(DIAMOND, PRECIOUS);
        NAME_TYPE_GEMSTONE.put(EMERALD, PRECIOUS);
        NAME_TYPE_GEMSTONE.put(RUBY, PRECIOUS);
        NAME_TYPE_GEMSTONE.put(TOURMALINE, PRECIOUS);
        NAME_TYPE_GEMSTONE.put(SPINEL, PRECIOUS);
    }
}
