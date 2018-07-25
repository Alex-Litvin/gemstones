package ua.training.model;

public enum StoneName {
    AQUAMARINE("Aquamarine"),
    GARNET("Garnet"),
    SARDONYX("Sardonyx"),
    TOPAZ("Topaz"),
    CHRYSOLITE("Chrysolite"),

    DIAMOND("Diamond"),
    EMERALD("Emerald"),
    RUBY("Ruby"),
    TOURMALINE("Tourmaline"),
    SPINEL("Spinel");

    private String name;

    StoneName(String name) {
        this.name = name;
    }
}
