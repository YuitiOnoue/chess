package models;

public enum ColumnEnum {
    
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
