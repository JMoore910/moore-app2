package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */


import com.google.gson.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;


public class LoadInventory {
    //  Class loads an inventory from file
    //  file can be of the format:
    //      TSV: Tab-Separated (Formatted basic text file)
    //      JSON
    //      HTML


    public Inventory loadFormat(String fileName) throws IOException {
        //      Check if fileName ends with text, json, or html file extension
        //          return loadTSV(fileName) if text
        //          return loadJSON(fileName) if json
        //          return loadHTML(fileName) if html
        if (fileName.endsWith(".txt")) {
            return loadTSV(fileName);
        } else if (fileName.endsWith(".json")) {
            return loadJSON(fileName);
        } else if (fileName.endsWith(".html")) {
            return loadHTML(fileName);
        } else {
            //  file is not TSV, HTML, or JSON
            //  return a new inventory
            return (new Inventory());
        }
    }


    public Inventory loadTSV(String fileName) throws IOException {
        Inventory inventory = new Inventory();
        //      try: create a buffered reader and read in the whole file line by line
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //  read the first line to pass it
            String input = br.readLine();
            if (input == null) {
                return (new Inventory());
            }

            List<String> list;
            input = br.readLine();
            while (input != null) {
                //  enter a loop while the input is not null
                //  split each line by tab and insert it as a list into a list of strings
                list = Arrays.asList(input.split("\t"));
                //  ("item name---tab---item serial---tab---item value---tab---quantity")
                inventory.addItem(new InventoryItem(
                        list.get(0),
                        list.get(1),
                        parseDouble(list.get(2)),
                        parseInt(list.get(3))));
                //  read the next line
                input = br.readLine();
            }
        } catch (FileNotFoundException e) {
            //      catch at File not found exception
            e.printStackTrace();
        }
        return inventory;
    }


    public Inventory loadJSON(String fileName) {
        Inventory inventory = new Inventory();
        //      Create a JSON array and set it to be equal to readJsonFile(fileName)
        JsonArray json = readJsonFile(fileName);
        for (JsonElement i: json) {
            inventory.addItem(new InventoryItem(
                    i.getAsJsonObject().get("name").getAsString(),
                    i.getAsJsonObject().get("serial").getAsString(),
                    parseDouble(i.getAsJsonObject().get("value").getAsString()),
                    parseInt(i.getAsJsonObject().get("quantity").getAsString())));
        }
        //  Result is an inventory that is now filled with items read from the JSON file
        return inventory;
    }


    public Inventory loadHTML(String fileName) {
        Inventory inventory = new Inventory();
        //      try: create a buffered reader and read in the whole file line by line
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String input = br.readLine();
            List<String> list;
            while (input != null) {
                //  Find the line of input that contains the list item indicator for html <li>
                if (input.contains("<li>")) {
                    //  If the input contains <li>, looking at a list item
                    //  remove <li> and </li>, the end list item indicator
                    input = input.replace("<li>", "");
                    input = input.replace("</li>", "");

                    //  set the list as the input split apart by percent signs
                    list = Arrays.asList(input.split("\t"));
                    inventory.addItem(new InventoryItem(
                            list.get(0),
                            list.get(1),
                            parseDouble(list.get(2)),
                            parseInt(list.get(3))));
                }
                input = br.readLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return inventory;
    }



    public JsonArray readJsonFile(String fileName) {
        //      THIS METHOD HAS BEEN IMPORTED FROM MY Exercise 44 solution
        //      method returns a Json Array that can be read and checked by user
        //      Read the file to a string the string can then be parsed to a Json object
        try {
            //          create object that is read from file at specified filepath
            Object parseObj = JsonParser.parseReader(new FileReader(fileName));
            JsonObject json = (JsonObject) parseObj;
            return (JsonArray) json.get("items");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new JsonArray();
    }



}



