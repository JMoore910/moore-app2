package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;


public class FXMLController1 implements Initializable {
    //  Declare and initialize vars
    private final ObservableList<String> itemNames = FXCollections.observableArrayList();
    private final ObservableList<String> itemSerials = FXCollections.observableArrayList();
    private final ObservableList<String> itemValues = FXCollections.observableArrayList();
    private final ObservableList<String> itemQuantities = FXCollections.observableArrayList();

    //  Declare an inventory that will be used by all methods
    //  this inventory is what is updated and changed, and its
    //  items are added to the columns of the tableview in the
    //  inventory management application
    Inventory inventory = new Inventory();
    ObservableList<String> sorts = FXCollections.observableArrayList("sort by name","sort by serial","sort by value");
    ObservableList<InventoryItem> initTable = FXCollections.observableArrayList();


    private File choice;
    private int selectedIndex = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button addButton;

    @FXML
    private Button clearButton;

    @FXML
    private Button editButton;

    @FXML
    private Button loadButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button searchButton;

    @FXML
    private Button sortButton;

    @FXML
    private Button fileChooserButton;

    @FXML
    private TableView<InventoryItem> inventoryTable;

    @FXML
    private TableColumn<InventoryItem, String> nameColumn;

    @FXML
    private TableColumn<InventoryItem, String> serialColumn;

    @FXML
    private TableColumn<InventoryItem, Double> valueColumn;

    @FXML
    private TableColumn<InventoryItem, Integer> quantityColumn;

    @FXML
    private TextField nameField;

    @FXML
    private Label noteLabel;

    @FXML
    private Label fileLabel;

    @FXML
    private TextField serialField;

    @FXML
    private ComboBox<String> sortBox;

    @FXML
    private TextField valueField;

    /*
        How to use table columns:
        create an observable list of the item to make a column of containing all items in order
        So nameCol will be created in a list and the same for each other
     */

    //  Button Methods

    @FXML void sort(ActionEvent event) {
        //      Sort based on sort option picked (default is sort by name)
        //      Get dropdown sort option
        String sortOption = sortBox.getSelectionModel().getSelectedItem();
        int option = 0;
        if (sortOption.equals("sort by name")) {
            option = 0;
        } else if (sortOption.equals("sort by serial")) {
            option = 1;
        } else if (sortOption.equals("sort by value")) {
            option = 2;
        }
        switch (option) {
            case 0 -> System.out.println("name sort");

            //              call inventory.sortName(inventory)
            case 1 -> System.out.println("serial sort");

            //              call inventory.sortValue(inventory)
            case 2 -> System.out.println("value sort");

            //              call inventory.sortSerial(inventory)
        }
    }


    @FXML void add(ActionEvent event) {
        //      item is only added if all the items check out with the inventory check methods
        String name = nameField.getText();
        String serial = serialField.getText();
        String value = valueField.getText();
        nameField.clear();
        serialField.clear();
        valueField.clear();

        if (!((name.isEmpty()) || serial.isEmpty() || value.isEmpty())) {
            initTable.add(new InventoryItem(name, serial, parseDouble(value), 1));


            //      if checkName(name), checkSerial(serial), and checkValue(value) are true
            //          call inventory.addItem(new inventoryItem():
            //          call resetTableView
            //      else
            //          noteLabel.setText("INPUT ERROR: Please follow the format specified")
        }
    }


    @FXML void remove(ActionEvent event) {
        //      check if an item was selected
        //          if so, call inventory.remove(selecteditemSerial)
        //          call resetTableView
        if (inventoryTable.getSelectionModel().getSelectedIndex() >= 0) {
            initTable.remove(inventoryTable.getSelectionModel().getSelectedIndex());
        }
    }


    @FXML void edit(ActionEvent event) {
        String name = nameField.getText();
        String serial = serialField.getText();
        String value = valueField.getText();
        nameField.clear();
        serialField.clear();
        valueField.clear();

        if (inventoryTable.getSelectionModel().getSelectedIndex() >= 0) {
            //  Edit basically does both a remove then add
            int tempQuan = inventoryTable.getSelectionModel().getSelectedItem().getQuantity();
            initTable.remove(inventoryTable.getSelectionModel().getSelectedIndex());
            initTable.add(new InventoryItem(name, serial, parseDouble(value), tempQuan));

            //      if checkName(name), checkSerial(serial), and checkValue(value) are true
            //          get selected item
            //          call inventory.removeItem(new inventoryItem())
            //          call inventory.addItem(new inventoryItem())
            //          call resetTableView
            //      else
            //          noteLabel.setText("INPUT ERROR: Please follow the format specified")
        }
    }


    @FXML void clear(ActionEvent event) {
        initTable.clear();
        //      resetListView
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

        //      if (checkName(name) || checkSerial(serial))
        //          inventory.searchList(serial, name);
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


    @FXML void load(ActionEvent event) {
        if (choice.exists()) {
            fileLabel.setText("load " + choice.getName());
            //      if choice is not empty,
            //          LoadInventory loader = new LoadInventory
            //          loader.loadFile(choice)
        }
    }


    @FXML void save(ActionEvent event) {
        if (choice.exists()) {
            fileLabel.setText("save to " + choice.getName());
            //      if choice is not empty,
            //          SaveInventory saver = new SaveInventory
            //          saver.writeInventoryToFile(choice, inventory)
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //  Initialize combo box items
        sortBox.getItems().clear();
        sortBox.setItems(sorts);
        sortBox.getSelectionModel().select(0);


        //  TEMPORARY FUNCTIONALITY: Adds an initialized list of inventory items
        initTable.add(new InventoryItem("Jeanne", "A-112-B12-CCD", 120.12, 2));

        for (int i = 0; i < 1024; i++) {
            initTable.add(new InventoryItem("Item "+ i,(i%26 + 'A') + "-123-456-789",i*.5,i));

        }

        //  Set the table's cell factories
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        serialColumn.setCellValueFactory(new PropertyValueFactory<>("serialNumber"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //  Set the table to be an observable list
        inventoryTable.setItems(initTable);
    }
}
