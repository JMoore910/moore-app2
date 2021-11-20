package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */

public class InventoryItem {
    private final String name;
    private final String serialNumber;
    private final Double value;
    private final String valueFormat;
    private Integer quantity;

    //  Constructor
    public InventoryItem(String name, String serialNumber, Double value, Integer quantity ) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.value = value;
        this.quantity = quantity;
        this.valueFormat = String.format("$%.2f",value);
    }

    public void addQuantity() {
        this.quantity ++;
    }

    public void subQuantity() {
        this.quantity --;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getValueFormat() {
        return valueFormat;
    }
}
