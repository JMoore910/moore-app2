package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */

public class Formatter {

    //  Includes methods to:
    //      Parse a json array from file into an inventory
    //      Parse an html file into an inventory
    //
    //      Format an inventory into a json array
    //      Format an inventory into a list of strings formatted to html



    //  Create a method: public Inventory parseJSON(jsonarray array)
    //      create a new Inventory inventory
    //      enter a for each loop for (jsonobject obj: array)
    //          inventory: add obj.get(name,serial,value,quantity)
    //      return inventory


    //  Create a method: public Inventory parseHTML(List<String> list)
    //      create a new Inventory inventory
    //      the list contains all input lines.
    //      for (String item: list)
    //          if item contains("<li>")
    //              item.remove <li> and <\li> and \n
    //              item.split("\t") --> list of strings
    //              inventory.addItem(new InventoryItem(list.get(0),list.get(1),
    //                  parseDouble(list.get(2),parseInt(list.get(3)))))
    //      return inventory


    //  Create a method: public jsonarray formatJSON(Inventory inventory)
    //      create a json array
    //      enter a for loop
    //      for (String serial: inventory.getList())
    //          create a new json object() with inventory(serial) and add it to the jsonarray
    //      return json array


    //  Create a method: public List<String> formatHTML(Inventory inventory)
    //      create a list of strings
    //      list.add("<html>\n<head>\n<title>\n\"Inventory\"\n</title>")
    //      list.add("</head>\n<body>\n<h2>Inventory List</h2>\n<ul>\n")
    //      for (String item: inventory.getSerials())
    //          list.add("<li>" + item.getName() + "\t" + item.getSerial() + "\t" + item.getValue()
    //              + "\t" + item.getQuantity() + "</li>")
    //      list.add("</ul>\n</body>\n</html>")
    //      return list;
}
