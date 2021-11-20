package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaveInventory {
    //  class saves an inventory to file
    //  file can be of the format:
    //      TSV: Tab-Separated (Formatted basic text file)
    //      JSON
    //      HTML


    public void saveFormat(String fileName, Inventory inventory) {

        //      create a list of strings
        List<StringBuilder> list;
        if (fileName.endsWith(".txt")) {
            list = getTSV(inventory);
        } else if (fileName.endsWith(".json")) {
            list = getJSON(inventory);
        } else if (fileName.endsWith(".html")) {
            list = getHTML(inventory);
        } else {
            //  If the filename is not among any specified, return
            //  before the rest of the method can function
            return;
        }
            //      then call save to file method that writes the list of stringbuilders to a file

        writeInventoryToFile(fileName, list);
    }

    public List<StringBuilder> getTSV(Inventory inventory) {
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder start = new StringBuilder();
        //  Format a header for the file
        start.append("Name\tSerial Number\tValue\tQuantity\n");
        list.add(start);
        StringBuilder tsv;

        //  Enter a for loop to format each item
        for (String item: inventory.getSerials()) {
            tsv = new StringBuilder();
            tsv.append(inventory.getMap().get(item).getName())
                    .append("\t")
                    .append(inventory.getMap().get(item).getSerialNumber())
                    .append("\t")
                    .append(inventory.getMap().get(item).getValue())
                    .append("\t")
                    .append(inventory.getMap().get(item).getQuantity())
                    .append("\n");
            list.add(tsv);
        }

        //  No ending of the list required, just return
        return list;
    }

    public List<StringBuilder> getHTML(Inventory inventory) {
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();
        StringBuilder html;

        //  Append html headers to start
        start.append("<html>\n<head>\n<title>\n\"Invenory\"")
                .append("\n</title>\n</head>\n<body>\n")
                .append("<h2>Inventory List</h2>\n<ul>\n");
        list.add(start);

        //  Enter a for loop to format each item
        for (String item: inventory.getSerials()) {
            html = new StringBuilder();
            html.append("<li>")
                    .append(inventory.getMap().get(item).getName())
                    .append(":")
                    .append(inventory.getMap().get(item).getSerialNumber())
                    .append(":")
                    .append(inventory.getMap().get(item).getValue())
                    .append(":")
                    .append(inventory.getMap().get(item).getQuantity())
                    .append("</li>");
        }
        end.append("\n</ul>\n</body>\n</html>");
        list.add(end);

        //  Return the list of Stringbuilders
        return list;

    }

    public List<StringBuilder> getJSON(Inventory inventory) {
        List<StringBuilder> list = new ArrayList<>();
        StringBuilder start = new StringBuilder();
        start.append("{ \"items\" : [\n");
        list.add(start);
        StringBuilder json;
        //  Format like so for JSON files
        for (String item: inventory.getSerials()) {
            json = new StringBuilder();
            json.append("{\"name\": ").append(inventory.getMap().get(item).getName())
                    .append("\", \"serial\": ")
                    .append(inventory.getMap().get(item).getSerialNumber())
                    .append("\", \"value\": ")
                    .append(inventory.getMap().get(item).getValue())
                    .append("\", \"quantity\": ")
                    .append(inventory.getMap().get(item).getQuantity())
                    .append("}");
            //  if the item is the last item in the list,
            if (inventory.getSerials().indexOf(item) == inventory.getSerials().size() - 1) {
                json.append("\n]\n}");
            } else {
                json.append(",");
            }
            list.add(json);
            //  result is a list that when printed to file will be in json format
        }

        //  Return the list of Stringbuilders
        return list;
    }


    public void writeInventoryToFile(String fileName, List<StringBuilder> list) {
        //  take in a list of StringBuilders
        //  Use a buffered Writer to write the list to a file as Strings
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (StringBuilder i: list) {
                bw.write(i.toString());
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
