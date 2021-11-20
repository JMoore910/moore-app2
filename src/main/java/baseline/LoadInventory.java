package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */


import com.google.gson.*;


public class LoadInventory {
    //  Class loads an inventory from file
    //  file can be of the format:
    //      TSV: Tab-Separated (Formatted basic text file)
    //      JSON
    //      HTML


    //  Create a method: public Inventory loadFormat(String fileName)
    //      Check if fileName ends with text, json, or html file extension
    //          return loadTSV(fileName) if text
    //          return loadJSON(fileName) if json
    //          return loadHTML(fileName) if html


    //public Inventory loadTSV(String fileName) {
       // Inventory inventory = new Inventory();
        //      try: create a buffered reader and read in the whole file line by line
        //try ()
        //          read the first line as input
        //          enter a loop while the input is not null
        //              split each line by tab and insert it as a list into a list of strings
        //              ("item name---tab---item serial---tab---item value---tab---quantity")
        //              inventory.addItem(new InventoryItem(list(0),list(1),parse Double list(2),parse Int list(3)))
        //              read the next line
        //      catch at IO exception
        //      return inventory
   // }


    //  Create a method: public Inventory loadJSON(String fileName)
    //      create a new Inventory inventory
    //      try: create a buffered reader and read in the whole file line by line
    //          read the first line as input
    //          enter a loop while the input is not null
    //              split each line by tab and insert it as a list into a list of strings
    //              ("item name---tab---item serial---tab---item value---tab---quantity")
    //              inventory.addItem(new InventoryItem(list(0),list(1),parse Double list(2),parse Int list(3)))
    //              read the next line
    //      catch at IO exception
    //      return inventory


    //  Create a method: public Inventory loadHTML(String fileName)
    //      create a new Inventory inventory
    //      try: create a buffered reader and read in the whole file line by line
    //          read the first line as input
    //          enter a loop while the input is not null
    //              split each line by tab and insert it as a list into a list of strings
    //              ("item name---tab---item serial---tab---item value---tab---quantity")
    //              inventory.addItem(new InventoryItem(list(0),list(1),parse Double list(2),parse Int list(3)))
    //              read the next line
    //      catch at IO exception
    //      return inventory

}
