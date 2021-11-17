package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Inventory {
    private HashMap<String, InventoryItem> inventoryMap = new HashMap<>();
    private List<String> serials = new ArrayList<>();

    //  Constructors
    public Inventory(HashMap<String, InventoryItem> inventoryMap, List<String> serials) {
        this.inventoryMap = inventoryMap;
        this.serials = serials;
    }

    public Inventory() {
        //  Empty Constructor
    }

    //  Create a method: public List<String> getSerials()
    //      return serials;


    //  Create a method: public HashMap<String, InventoryItem> getMap()
    //      return inventoryMap;


    //  Create a method: public boolean searchList(String serial, String name)
    //
    //      return if the serials list contains the string input or not


    //  Create a method: public void addItem(InventoryItem item)
    //      inventoryMap put item at item.getSerial
    //      serials.add(item.getSerial)


    //  Create a method: public void removeItem(InventoryItem item)
    //      remove item from inventoryMap at item.getSerial
    //


    //  Create a method: public void clearList()
    //      enter a for each loop
    //      for (String item: serials)
    //          remove item from map at item
    //      serials.clear()
    //      removes all items from map and list


    //  Create a method: public void sortByName()
    //      sort the serials list by the name of each item in map


    //  Create a method: public void sortBySerial()
    //      sort the serials list by the serial values


    //  Create a method: public void sortByValue()
    //      sort the serials list by the value of each item in map


    //  Create a method: public boolean checkName(String nameCheck)
    //      If nameStr is less than 2 chars long or is greater than 256 chars, return false
    //          else return true


    //  Create a method: public boolean checkSerial(String serialCheck)
    //      if the serialStr does not follow the format ("A-XXX-XXX-XXX")
    //      Where A is a letter and X is either a letter or a number,
    //          return false
    //      else return true


    //  Create a method: public boolean checkValue(String valueCheck)
    //      remove $ from valueStr
    //      if the valueStr follows the format of XXX.XX
    //          and the valueStr parsed to Double > 0
    //              return true
    //      else return false
}