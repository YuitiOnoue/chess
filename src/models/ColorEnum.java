package models;

public enum ColorEnum {

    WHITE("w"),
    BLACK("b");

    private String code;

    ColorEnum(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }

}
