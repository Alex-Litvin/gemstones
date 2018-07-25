package ua.training.model;

import java.util.List;

public class Necklace {
    private List<Gemstone> necklace;

    public Necklace(List<Gemstone> necklace) {
        this.necklace = necklace;
    }

    public List<Gemstone> getNecklace() {
        return necklace;
    }

    public void setNecklace(List<Gemstone> necklace) {
        this.necklace = necklace;
    }
}
