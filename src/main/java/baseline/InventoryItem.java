package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */

public class InventoryItem {
    private String name;
    private String serialNumber;
    private Double value;
    private Integer quantity;

    //  Constructor
    public InventoryItem(String name, String serialNumber, Double value, Integer quantity ) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.value = value;
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void addQuantity() {
        this.quantity ++;
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
}
