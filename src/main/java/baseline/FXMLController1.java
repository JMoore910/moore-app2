package baseline;

/*
 *  UCF COP3330 Fall 2021 Application Assignment 2 Solution
 *  Copyright 2021 Jeanne Moore
 */

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    private TableColumn<?, ?> nameColumn;

    @FXML
    private TableColumn<?, ?> serialColumn;

    @FXML
    private TableColumn<?, ?> valueColumn;

    @FXML
    private TableColumn<?, ?> quantityColumn;

    @FXML
    private TextField nameField;

    @FXML
    private Label noteLabel;

    @FXML
    private TextField serialField;

    @FXML
    private ComboBox<?> sortBox;

    @FXML
    private TextField valueField;

    /*
        How to use table columns:
        create an observable list of the item to make a column of containing all items in order
        So nameCol will be created in a list and the same for each other
     */

    //  Button Methods

    //  Create a method: @FXML void sort(ActionEvent event)
    //      Sort based on sort option picked (default is sort by name)
    //      Get dropdown sort option
    //      switch (option)
    //          case "sort by name"
    //              call inventory.sortName(inventory)
    //          case "sort by value"
    //              call inventory.sortValue(inventory)
    //          case "sort by serial"
    //              call inventory.sortSerial(inventory)


    //  Create a method: @FXML void add(ActionEvent event)
    //      item is only added if all the items check out with the inventory check methods
    //      String name = nameField.getText()
    //      String serial = serialField.getText()
    //      String value = valueField.getText()
    //      clear all three fields
    //      if checkName(name), checkSerial(serial), and checkValue(value) are true
    //          call inventory.addItem(new inventoryItem():
    //          call resetTableView
    //      else
    //          noteLabel.setText("INPUT ERROR: Please follow the format specified")


    //  Create a method: @FXML void remove(ActionEvent event)
    //      check if an item was selected
    //          if so, call inventory.remove(selecteditemSerial)
    //          call resetTableView


    //  Create a method: @FXML void edit(ActionEvent event)
    //      String name = nameField.getText()
    //      String serial = serialField.getText()
    //      String value = valueField.getText()
    //      clear all three fields
    //      if checkName(name), checkSerial(serial), and checkValue(value) are true
    //          get selected item
    //          call inventory.removeItem(new inventoryItem())
    //          call inventory.addItem(new inventoryItem())
    //          call resetTableView
    //      else
    //          noteLabel.setText("INPUT ERROR: Please follow the format specified")


    //  Create a method: @FXML void clear(ActionEvent event)
    //      inventory.clearList()
    //      resetListView


    //  Create a method: @FXML void search(ActionEvent event)
    //      String name = nameField.getText()
    //      String serial = serialField.getText()
    //      if (checkName(name) || checkSerial(serial))
    //          inventory.searchList(serial, name);


    //  Create a method: @FXML void fileChooser(ActionEvent event)
    //      FileChooser fileChooser = new FileChooser
    //      choice = chosen file


    //  Create a method: @FXML void load(ActionEvent event)
    //      if choice is not empty,
    //          LoadInventory loader = new LoadInventory
    //          loader.loadFile(choice)


    //  Create a method: @FXML void save(ActionEvent event)
    //      if choice is not empty,
    //          SaveInventory saver = new SaveInventory
    //          saver.writeInventoryToFile(choice, inventory)


    //  other methods

    //  Create a method: @FXML void selectItem(MouseEvent event)
    //      selectedItem = get SelectionMode for tableview





    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
