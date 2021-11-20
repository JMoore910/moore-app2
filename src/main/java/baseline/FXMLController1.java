package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Double.parseDouble;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;


public class FXMLController1 implements Initializable {
    //  Declare an inventory that will be used by all methods
    //  this inventory is what is updated and changed, and its
    //  items are added to the columns of the tableview in the
    //  inventory management application

    //  Encapsulates methods for adding inventory items to both a list of serials and a map of items
    Inventory inventory = new Inventory();

    //  A list of sort options that is put into the sortBox
    ObservableList<String> sorts = FXCollections.observableArrayList(
            "sort by name",
            "sort by serial",
            "sort by value");

    //  The list of items in the inventory: follows the order of the serials list encapsulated by inventory
    ObservableList<InventoryItem> initTable = FXCollections.observableArrayList();

    private File choice;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView<InventoryItem> inventoryTable;

    @FXML
    private TableColumn<InventoryItem, String> nameColumn;

    @FXML
    private TableColumn<InventoryItem, String> serialColumn;

    @FXML
    private TableColumn<InventoryItem, String> valueColumn;

    @FXML
    private TableColumn<InventoryItem, Integer> quantityColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button editButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button sortButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button fileChooserButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button saveButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField valueField;

    @FXML
    private TextField serialField;

    @FXML
    private ComboBox<String> sortBox;

    @FXML
    private Label noteLabel;

    @FXML
    private Label fileLabel;




    //  Button Methods

    @FXML void sort(ActionEvent event) {
        //      Sort based on sort option picked (default is sort by name)
        //      Get dropdown sort option
        String sortOption = sortBox.getSelectionModel().getSelectedItem();
        int option = 0;
        if (sortOption.equals("sort by serial")) {
            option = 1;
        } else if (sortOption.equals("sort by value")) {
            option = 2;
        }
        switch (option) {
            case 0 -> inventory.sortByName();

            //              call inventory.sortName(inventory)
            case 1 -> inventory.sortBySerial();

            //              call inventory.sortValue(inventory)
            case 2 -> inventory.sortByValue();

            //              call inventory.sortSerial(inventory)
            default -> inventory.sortByName();
        }
        resetTableList();
    }


    @FXML void add(ActionEvent event) {
        //      item is only added if all the items check out with the inventory check methods
        String name = nameField.getText();
        String serial = serialField.getText();
        String value = valueField.getText();
        nameField.clear();
        serialField.clear();
        valueField.clear();

        //  If an item is selected when add is clicked, increase its quantity
        if (inventoryTable.getSelectionModel().getSelectedIndex() >= 0) {
            inventory.addQuantity(inventoryTable.getSelectionModel().getSelectedItem());
            resetTableList();
            noteLabel.setText("Item has been added!");
            return;
        }

        if (inventory.searchList(serial, name)) {
            noteLabel.setText("INPUT ERROR: Serialnumber already exists");
            return;
        }

        //  Check that the name, serial, and value are filled and meet format specifications
        if ((!((name.isEmpty()) || serial.isEmpty() || value.isEmpty())) &&
                ((inventory.checkName(name) && inventory.checkSerial(serial)) && inventory.checkValue(value))) {
                //  Value will need to be resized if it has more than 2 digits after the decimal
                double temp = parseDouble(value);
                temp = (Math.round(temp * 100)) / 100.0;

                inventory.addItem(new InventoryItem(name, serial, temp, 1));
                resetTableList();
                noteLabel.setText("Item has been added!");
            } else {
            noteLabel.setText("INPUT ERROR: Please follow the format");
        }
    }


    @FXML void remove(ActionEvent event) {
        //  check if an item was selected
        if (inventoryTable.getSelectionModel().getSelectedIndex() >= 0) {
            inventory.removeItem(inventoryTable.getSelectionModel().getSelectedItem());
            resetTableList();
            noteLabel.setText("Item has been removed!");
        }
    }


    @FXML void edit(ActionEvent event) {
        String name = nameField.getText();
        String serial = serialField.getText();
        String value = valueField.getText();
        nameField.clear();
        serialField.clear();
        valueField.clear();

        //  Check that an item was selected, the fields are not empty, and the input is valid
        if ((inventoryTable.getSelectionModel().getSelectedIndex() >= 0) &&
                ((!((name.isEmpty()) || serial.isEmpty() || value.isEmpty())) &&
                ((inventory.checkName(name) && inventory.checkSerial(serial)) && inventory.checkValue(value)))) {
            //  Value will need to be resized if it has more than 2 digits after the decimal
            double tempVal = parseDouble(value);
            tempVal = (Math.round(tempVal * 100)) / 100.0;


            //  Edit basically does both a remove then add
            int tempQuan = inventoryTable.getSelectionModel().getSelectedItem().getQuantity();
            inventory.editItem(inventoryTable.getSelectionModel().getSelectedItem().getSerialNumber(),
                    new InventoryItem(name, serial, tempVal, tempQuan));

            //  Successfully edited item
            noteLabel.setText("Item has been edited!");
            resetTableList();

        } else {
            noteLabel.setText("INPUT ERROR: Please follow the format specified");
        }
    }


    @FXML void clear(ActionEvent event) {
        //  Clears all items from all lists and the map
        inventory.clearList();
        initTable.clear();
    }


    @FXML void search(ActionEvent event) {
        String name = nameField.getText();
        String serial = serialField.getText();

        for (InventoryItem item: initTable){
            if ((item.getName().equals(name)) || (item.getSerialNumber().equals(serial))) {
                inventoryTable.getSelectionModel().select(item);
                inventoryTable.scrollTo(inventoryTable.getSelectionModel().getFocusedIndex());
            }
        }
    }


    @FXML void fileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TSV Files","*.txt"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files","*.html"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files","*.json"));
        choice = fileChooser.showOpenDialog(null);

        if (choice != null) {
            fileLabel.setText("File: " + choice.getName());
        }
    }


    @FXML void load(ActionEvent event) throws IOException {
        if (choice != null) {
            //  Change label to notify user and load at the chosen file's absolute path
            fileLabel.setText("load " + choice.getName());
            LoadInventory loader = new LoadInventory();
            //  Inventory is assigned to the result of the load method
            inventory = loader.loadFormat(choice.getAbsolutePath());
            resetTableList();
        }
    }


    @FXML void save(ActionEvent event) {
        if (choice != null) {
            //  Change label to notify user and save to the chosen file's absolute path
            fileLabel.setText("save to " + choice.getName());
            SaveInventory save = new SaveInventory();
            //  Inventory is passed in to be saved
            save.saveFormat(choice.getAbsolutePath(), inventory);
        }
    }


    //  Method to reset TableView list of items based on serials
    @FXML void resetTableList(){
        //  Clear the init table out and then add everything back into it
        initTable.clear();
        for (String i: inventory.getSerials()) {
            initTable.add(inventory.getMap().get(i));
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //  Initialize combo box items
        sortBox.getItems().clear();
        sortBox.setItems(sorts);
        sortBox.getSelectionModel().select(0);


        //  Set the table's cell factories
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        serialColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("valueFormat"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //  Set the table to be an observable list
        inventoryTable.setItems(initTable);
    }
}
