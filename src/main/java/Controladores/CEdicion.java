package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.gestorempleadosmatiasrojas.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CEdicion {


    @FXML
    private Text txtIdTrab;
    @FXML
    private TextField txtfldNomEd;
    @FXML
    private TextField txtfldPuestoEd;
    @FXML
    private TextField txtfldSalarEd;
    @FXML
    private Button BtnModificar;
    @FXML
    private Button BtnCancelar;

    public CEdicion(){

    }

    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    public void cancelarModificacion(ActionEvent actionEvent) throws IOException {
        volverPantallaConsulta(actionEvent);
    }


    public void confirmarModificacion(ActionEvent actionEvent) throws IOException {
        volverPantallaConsulta(actionEvent);
    }

    public static void volverPantallaConsulta(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader;
        Scene scene;
        Node node = (Node) actionEvent.getSource();
        Stage currentStage = (Stage) node.getScene().getWindow();
        Stage stage = new Stage();

        fxmlLoader = new FXMLLoader(Main.class.getResource("PInsercionConsulta.fxml"));
        scene = new Scene(fxmlLoader.load(), 630,425);
        stage.setTitle("Gestor Empleados");
        stage.setScene(scene);

        currentStage.close();
        stage.show();
    }
}
