package Controladores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
        mensajeModificacionCancelada();
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


    /** Metodos para mostrar diversos mensajes dependiendo de como suceda la modificación **/

    public static void mensajeModificacionErronea(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setContentText("Los datos no se han modificado correctamente. Comprueba que los datos estén metidos correctamente.");
        alerta.showAndWait();
    }

    public static void mensajeModificacionCancelada(){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText("El proceso de modificación ha sido cancelada. Volviendo a la pantalla principal.");
        alerta.showAndWait();
    }

    public static void mensajeModificacionCorrecta(){
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setContentText("El proceso de modificación se ha ejecutado correctamente. Volviendo a la pantalla principal.");
        alerta.showAndWait();
    }
}
