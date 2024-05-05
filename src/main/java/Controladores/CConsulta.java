package Controladores;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import Modelo.Trabajador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import static Modulo.ConexionBBDD.conectar;

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

    public CConsulta() throws SQLException, IOException {
        btnEdit = new Button("Editar");
        btnRefresc = new Button("Refrescar");
        btnElim = new Button("Eliminar");
        txtIdT = new Text();
        txtNT = new Text();
        txtPuesto = new Text();
        txtSalar = new Text();
        txtFA = new Text();
        this.rellenarTabla(); //Incluir los nombres de los trabajadores en la listView
        this.datosTrabajadoresEnBD(); //Insertar la informacion de los trabajadores en la BD
    }


    private void rellenarTabla() throws IOException {
        ArrayList<Trabajador> trabajadores = recogerDatosFicheroTrabajadores();
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

    private static ArrayList<Trabajador> recogerDatosFicheroTrabajadores() throws IOException {
        ArrayList<Trabajador> trabajadoresEncontrados = new ArrayList<Trabajador>();

        //C:\Users\34654\gestorEmpleadosMatiasRojas\src\main\java\Controladores\CConsulta.java
        // .\..\\..\\..\\resources\\Ficheros\\trabajadores.txt

        String archivo = "C:\\Users\\34654\\gestorEmpleadosMatiasRojas\\src\\main\\resources\\Ficheros\\trabajadores.txt";
        String cadena;
        FileReader lector = new FileReader(archivo);
        BufferedReader lectorAux = new BufferedReader(lector);

        while ((cadena = lectorAux.readLine()) != null) {
            String[] bloques = cadena.split("\n");
            for (String datosTrabajador : bloques){
                String[] listaDatosTrabajador = datosTrabajador.split(";");
                Trabajador trabajador = new Trabajador(listaDatosTrabajador[0],listaDatosTrabajador[1],Integer.parseInt(listaDatosTrabajador[2]), Date.valueOf(LocalDate.now()));
                trabajadoresEncontrados.add(trabajador);
            }
        }
        return trabajadoresEncontrados;
    }


}
