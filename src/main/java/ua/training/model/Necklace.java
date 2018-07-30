package ua.training.model;

import java.util.List;

public class Necklace {
    private Integer id;
    private List<Gemstone> gemstones;

    public Necklace() {}

    public Necklace(List<Gemstone> gemstones) {
        this.gemstones = gemstones;
    }

    public List<Gemstone> getGemstones() {
        return gemstones;
    }

    public void setGemstones(List<Gemstone> gemstones) {
        this.gemstones = gemstones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
