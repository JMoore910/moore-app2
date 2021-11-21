package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */

import java.util.*;

import static java.lang.Double.parseDouble;

public class Inventory {
    private Map<String, InventoryItem> inventoryMap = new HashMap<>();
    private List<String> serials = new ArrayList<>();

    //  Constructors
    public Inventory(Map<String, InventoryItem> inventoryMap, List<String> serials) {
        this.inventoryMap = inventoryMap;
        this.serials = serials;
    }

    public Inventory() {
        //  Empty Constructor
    }

    public List<String> getSerials() {
        return serials;
    }


    public Map<String, InventoryItem> getMap() {
        return inventoryMap;
    }


    public boolean searchList(String serial, String name) {
        //  Check if the serials list contains the string input or not
        if (serials.contains(serial)) {
            return true;
        }

        //  Check if the name is found in the list in case no serial is given
        for (String i: serials) {
            if (inventoryMap.get(i).getName().equals(name)) {
                return true;
            }
        }

        //  Return false otherwise as the list contains neither the serial nor
        //  is there a name in the map that matches the argument
        return false;
    }


    public void addQuantity(InventoryItem item) {
        //  Adds 1 to the quantity of a selected item
        InventoryItem newItem = inventoryMap.get(item.getSerialNumber());
        newItem.addQuantity();
        //  inventoryMap.remove(item.getSerialNumber())
        inventoryMap.put(newItem.getSerialNumber(),newItem);
    }


    public void addItem(InventoryItem item) {
        //      inventoryMap put item at item.getSerial
        inventoryMap.put(item.getSerialNumber(),item);
        serials.add(item.getSerialNumber());
    }


    public void removeItem(InventoryItem item) {
        //  Reduce quantity of an item by one
        item.subQuantity();

        if (item.getQuantity() <= 0) {
            //  remove item from inventoryMap at item.getSerial
            inventoryMap.remove(item.getSerialNumber());
            //  remove its serial number from the list of serials
            serials.remove(item.getSerialNumber());
        } else {
            //  If the quantity is still greater than 0,
            //  keep it in the list, just reset it to the map
            inventoryMap.remove(item.getSerialNumber());
            inventoryMap.put(item.getSerialNumber(), item);
        }

    }


    public void editItem(String serial, InventoryItem item) {
        //  Edit is effectively just removing and adding in one method
        int i = inventoryMap.get(serial).getQuantity();

        for (int j = i; j > 0; j--) {
            removeItem(inventoryMap.get(serial));
        }

        addItem(item);
    }


    public void clearList() {
        //  Clear the map and list
        inventoryMap.clear();
        serials.clear();
    }


    public void sortByName() {
        //      sort the serials list by the name of each item in map
        String temp;

        //  Enter a nested for loop to selection sort the whole list
        for (int i = 0; i < serials.size(); i++) {
            for (int j = i; j < serials.size(); j++) {
                if (inventoryMap.get(serials.get(i)).getName().compareTo(inventoryMap.get(serials.get(j)).getName()) > 0) {
                    temp = serials.get(i);
                    serials.set(i,serials.get(j));
                    serials.set(j,temp);
                }
            }
        }
    }


    public void sortBySerial() {
        //      sort the serials list by the serial values
        String temp;

        //  Enter a nested for loop
        for (int i = 0; i < serials.size(); i++) {
            for (int j = i; j < serials.size(); j++) {
                if (serials.get(i).compareTo(serials.get(j)) > 0) {
                    temp = serials.get(i);
                    serials.set(i,serials.get(j));
                    serials.set(j,temp);
                }
            }
        }
    }


    public void sortByValue() {
        //      sort the serials list by the value of each item in map
        String temp;

        //  Enter a nested for loop
        for (int i = 0; i < serials.size(); i++) {
            for (int j = i; j < serials.size(); j++) {
                if (inventoryMap.get(serials.get(i)).getValue() > inventoryMap.get(serials.get(j)).getValue()) {
                    temp = serials.get(i);
                    serials.set(i,serials.get(j));
                    serials.set(j,temp);
                }
            }
        }
    }


    public boolean checkName(String nameCheck) {
        //      If nameStr is less than 2 chars long or is greater than 256 chars, return false
        //          else return true
        return (!((nameCheck.length() < 2) || (nameCheck.length() > 256)));
    }


    public boolean checkSerial(String serialCheck) {
        //      if the serialStr does not follow the format ("A-XXX-XXX-XXX")
        //      Where A is a letter and X is either a letter or a number,
        //          return false
        //      else return true


        serialCheck = serialCheck.replace("-","");
        //  Break all hyphens out and just see if length is the proper size, if not return false
        if (serialCheck.length() != 10) {
            return false;
        }

        //  Check that first char is upper case alphabetic
        if (!Character.isUpperCase(serialCheck.charAt(0))) {
            return false;
        }

        //  enter a for loop that iterates through
        //  index numbers 1-9 and checks if they are
        //  Not upper case alphabetic or numeric
        for (int i = 0; i < 10; i++) {
            if (!((Character.isUpperCase(serialCheck.charAt(i))) || (Character.isDigit(serialCheck.charAt(i))))) {
                return false;
            }

        }

        //  If all checks pass the serial meets the format, return true
        return true;
    }


    public boolean checkValue(String valueCheck) {
        //  Check that the value string is of the format XXX.XX, May have any length,
        //  Must contain exactly one decimal.
        //  Check if the value is a valid double using a try block
        try {
            parseDouble(valueCheck);
        } catch(Exception e) {
            return false;
        }

        //  Check that the value is larger than 0
        return parseDouble(valueCheck) > 0;


    }
}