package baseline;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
