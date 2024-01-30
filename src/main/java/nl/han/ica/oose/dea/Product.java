package nl.han.ica.oose.dea;

public class Product {
    private String code;
    private int color;
    private String colorString;
    private int size;
    private String sizeString;
    private double price;
    private String currency;

    public Product(String code, int color, int size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.colorString = getColorStringFor(color);
        this.size = size;
        this.sizeString = getSizeStringFor(size);
        this.price = price;
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public int getColor() {
        return color;
    }

    public String getColorString() {
        return colorString;
    }

    public int getSize() {
        return size;
    }

    public String getSizeString() {
        return sizeString;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSizeStringFor(int size) {
        return switch (size) {
            case 1 -> "XS";
            case 2 -> "S";
            case 3 -> "M";
            case 4 -> "L";
            case 5 -> "XL";
            case 6 -> "XXL";
            default -> "Invalid Size";
        };
    }

    private String getColorStringFor(int color) {
        return switch (color) {
            case 1 -> "blue";
            case 2 -> "red";
            case 3 -> "yellow";
            default -> "no color";
        };
    }

}
