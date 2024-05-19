package Controladores;

import Modelo.Trabajador;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.gestorempleadosmatiasrojas.Main;

import static Modulo.ConexionBBDD.conectar;

public class CInsercionConsulta {
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

    @FXML
    public ListView<Trabajador> listV;
    @FXML
    private Button btnEdit;
    @FXML
    private Button btnRefresc;
    @FXML
    private Button btnElim;
    @FXML
    private Text txtIdT;
    @FXML
    private Text txtNT;
    @FXML
    private Text txtPuesto;
    @FXML
    private Text txtSalar;
    @FXML
    private Text txtFA;
    @FXML
    private Label selection;

    public CInsercionConsulta() throws SQLException, IOException {
        btnEdit = new Button("Editar");
        btnRefresc = new Button("Refrescar");
        btnElim = new Button("Eliminar");
        txtIdT = new Text();
        txtNT = new Text();
        txtPuesto = new Text();
        txtSalar = new Text();
        txtFA = new Text();
        this.datosTrabajadoresEnBD(); //Insertar la informacion de los trabajadores en la BD
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ArrayList<Trabajador> trabajadores = recogerDatosFicheroTrabajadores();
            Trabajador[] items = new Trabajador[trabajadores.size()];
            for (int i = 0; i < trabajadores.size(); i++) {
                items[i] = trabajadores.get(i);
            }
            listV.getItems().setAll(items);

            listV.getSelectionModel().selectedItemProperty().addListener(this::cambioSeleccion);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void datosTrabajadoresEnBD() throws IOException, SQLException {
        Connection conexion = null;
        conexion = conectar(conexion);
        ArrayList<Trabajador> trabajadores = recogerDatosFicheroTrabajadores();

        for (int i = 0; i < trabajadores.size(); i++) {
            Trabajador trabajador = trabajadores.get(i);
            PreparedStatement st = conexion.prepareStatement("INSERT INTO EMPLEADOS(NOMBRE,PUESTO,SALARIO,FECHA) VALUES (?,?,?,?)");
            st.setString(1, trabajador.getNombre());
            st.setString(2, trabajador.getPuesto());
            st.setInt(3, trabajador.getSalario());
            st.setDate(4, trabajador.getFechaAlta());
            st.executeUpdate();
        }


    }

    private ArrayList<Trabajador> recogerDatosFicheroTrabajadores() throws IOException {
        ArrayList<Trabajador> trabajadoresEncontrados = new ArrayList<>();

        String archivo = "C:\\Users\\34654\\gestorEmpleadosMatiasRojas\\src\\main\\resources\\Ficheros\\trabajadores.txt";
        String cadena;
        FileReader lector = new FileReader(archivo);
        BufferedReader lectorAux = new BufferedReader(lector);

        while ((cadena = lectorAux.readLine()) != null) {
            String[] bloques = cadena.split("\n");
            for (String datosTrabajador : bloques) {
                String[] listaDatosTrabajador = datosTrabajador.split(";");
                Trabajador trabajador = new Trabajador(listaDatosTrabajador[0], listaDatosTrabajador[1], Integer.parseInt(listaDatosTrabajador[2]), Date.valueOf(LocalDate.now()));
                trabajadoresEncontrados.add(trabajador);
            }
        }
        return trabajadoresEncontrados;
    }


    private void cambioSeleccion(ObservableValue<? extends Trabajador> Observable, Trabajador oldValue, Trabajador newValue) {
        ObservableList<Trabajador> selectedItems = listV.getSelectionModel().getSelectedItems();

        Trabajador getSelectedItem = (selectedItems.isEmpty()) ? (Trabajador) selectedItems : selectedItems.get(0);


        ArrayList<Trabajador> trabajadores;

        try {
            trabajadores = this.recogerDatosFicheroTrabajadores();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int indiceTrabajadorSeleccionado = this.reconocerTrabajador(getSelectedItem, trabajadores);
        Trabajador trabajadorSeleccionado = trabajadores.get(indiceTrabajadorSeleccionado);

        txtIdT.setText(String.valueOf(indiceTrabajadorSeleccionado + 1));
        txtNT.setText(trabajadorSeleccionado.getNombre());
        txtPuesto.setText(trabajadorSeleccionado.getPuesto());
        txtSalar.setText(String.valueOf(trabajadorSeleccionado.getSalario()));
        txtFA.setText(String.valueOf(trabajadorSeleccionado.getFechaAlta()));

    }

    private int reconocerTrabajador(Trabajador trabajadorSeleccionado, ArrayList<Trabajador> trabajadores) {
        for (int i = 0; i < trabajadores.size(); i++) {
            if (trabajadorSeleccionado.equals(trabajadores.get(i))) {
                return i;
            }
        }
        return 2;
    }

    @FXML
    public void irAPantallaEdicion(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader;
        Scene scene;
        Node node = (Node) actionEvent.getSource();
        Stage currentStage = (Stage) node.getScene().getWindow();
        Stage stage = new Stage();

        fxmlLoader = new FXMLLoader(Main.class.getResource("PEdicion.fxml"));
        scene = new Scene(fxmlLoader.load(), 450, 270);
        stage.setTitle("Editar");
        stage.setScene(scene);

        currentStage.close();
        stage.show();
    }
}