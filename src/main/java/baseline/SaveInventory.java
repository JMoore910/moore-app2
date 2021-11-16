package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */

public class SaveInventory {
    //  class saves an inventory to file
    //  file can be of the format:
    //      TSV: Tab-Separated (Formatted basic text file)
    //      JSON
    //      HTML


    //  create a method: public list<String> saveFormat(String fileName, Inventory inventory)
    //      create a list of strings


    //      if (fileName is type json)
    //          list.add("{ \"items\" : [\n");
    //          String json = "";
    //          for (String item: inventory.getSerials())
    //              json += "{\"name\": " + inventory.getMap() name at item;
    //              json += "\", \"serial\": " + inventory.getMap() serial at item;
    //              json += "\", \"value\": " + inventory.getMap() value at item;
    //              json += "\", \"quantity\": " + inventory.getMap() quantity at item + "}";
    //              if the item is the last item in the list,
    //                  json += "\n]\n}"
    //              else
    //                  json += ","
    //              list.add(json)
    //          result is a list that when printed to file will be in json format
    //      else if (fileName is type html)
    //          format list to html
    //
    //      else if (fileName is type text)
    //          format list as a tab separated text file
    //
    //      return list;


    //  Create a method: public void writeInventoryToFile(String fileName, Inventory inventory)
    //      create a list of Strings and set it to be result of saveFormat(fileName, inventory)
    //      then for(String item: list)
    //          print item to a file with specified fileName
}
