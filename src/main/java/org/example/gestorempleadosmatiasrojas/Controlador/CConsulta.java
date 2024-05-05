package org.example.gestorempleadosmatiasrojas.Controlador;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.example.gestorempleadosmatiasrojas.Modelo.Trabajador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.example.gestorempleadosmatiasrojas.Modulo.ConexionBBDD.conectar;

public class CConsulta {

    @FXML
    public ListView<String>listV;
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

    public CConsulta(){
        btnEdit = new Button("Editar");
        btnRefresc = new Button("Refrescar");
        btnElim = new Button("Eliminar");
        txtIdT = new Text();
        txtNT = new Text();
        txtPuesto = new Text();
        txtSalar = new Text();
        txtFA = new Text();
    }


    private void rellenarTabla() throws IOException {
        ArrayList<Trabajador> trabajadores = this.recogerDatosTrabajadores();
        ArrayList<String> listaNombresTrabajadores = new ArrayList<>();

        for (int i = 0; i < trabajadores.size(); i++) {
            listaNombresTrabajadores.add(trabajadores.get(i).getNombre());
        }
        ObservableList<String> items = FXCollections.observableArrayList();
        items.addAll(listaNombresTrabajadores);
    }

    private void datosTrabajadoresEnBD() throws IOException, SQLException {
        Connection conexion = null;
        conexion = conectar(conexion);
        ArrayList<Trabajador> trabajadores = this.recogerDatosTrabajadores();

        for (int i = 0; i < trabajadores.size(); i++) {
            Trabajador trabajador = trabajadores.get(i);
            PreparedStatement st = conexion.prepareStatement("INSERT INTO trabajadores VALUES (?,?,?,?,?)");
            st.setString(1, trabajador.getNombre());
            st.setString(2, trabajador.getPuesto());
            st.setInt(3, trabajador.getSalario());
            st.setDate(4, trabajador.getFechaAlta());
            st.executeUpdate();
        }


    }

    private ArrayList<Trabajador> recogerDatosTrabajadores() throws IOException {
        ArrayList<Trabajador> trabajadoresEncontrados = new ArrayList<Trabajador>();
        BufferedReader lector = new BufferedReader(new FileReader("../Modelo/trabajadores.txt"));
        String linea = lector.readLine();
        while (linea!=null) {
            String[] bloques = linea.split("\n");
            for (String datosTrabajador : bloques){
                String[] listaDatosTrabajador = datosTrabajador.split(";");
                Trabajador trabajador = new Trabajador(listaDatosTrabajador[0],listaDatosTrabajador[1],Integer.parseInt(listaDatosTrabajador[2]), Date.valueOf(LocalDate.now()));
                trabajadoresEncontrados.add(trabajador);
            }
        }
        return trabajadoresEncontrados;
    }

}
