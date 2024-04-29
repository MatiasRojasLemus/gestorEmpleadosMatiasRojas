package org.example.gestorempleadosmatiasrojas.Controlador;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CInserccion {
    private static final TabPane TP = new TabPane();
    @FXML
    private VBox VBoxInsert;
    @FXML
    private Text txtTitApp;
    @FXML
    private Tab tabNE;
    @FXML
    private Tab tabCon;
    @FXML
    private Label lblNom;
    @FXML
    private TextField txtFldNom;
    @FXML
    private Label lblPuesto;
    @FXML
    private ComboBox CBPuesto;
    @FXML
    private Label lblSalario;
    @FXML
    private TextField txtFldSalario;
    @FXML
    private Button btnInsert;
}
