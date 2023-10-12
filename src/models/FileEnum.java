package models;

public enum FileEnum {

    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }

    public int getValue() {
        return this.ordinal() + 1;
    }
}
