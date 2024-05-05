package Controladores;

import javafx.event.Event;
import javafx.fxml.FXML;

import java.io.*;


import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CInserccion  {
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

    public CInserccion() {

    }

    public void abrirPestanaConsultas(Event event) {
        //Creamos un nuevo escenario, y lo introducimos quitando el anterior
        Parent nuevaPantalla;
        try {
            nuevaPantalla = FXMLLoader.load(getClass().getResource("PConsultas.fxml"));
            Stage escenario = new Stage();
            escenario.setWidth(600);
            escenario.setHeight(400);
            escenario.setTitle("Consulta");
            escenario.setScene(new Scene(nuevaPantalla,600,400));
            escenario.show();
            //Eliminamos la ventana anterior
            ((Node) event.getSource()).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
