package Modelo;

import java.sql.Date;

public class Trabajador {
    private String nombre;
    private String puesto;
    private int salario;
    private Date fechaAlta;

    public Trabajador(String nombre, String puesto, int salario, Date fechaAlta) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaAlta = fechaAlta;
    }
    public String getNombre() {
        return nombre;
    }
    public String getPuesto() {
        return puesto;
    }
    public int getSalario() {
        return salario;
    }
    public Date getFechaAlta() {
        return fechaAlta;
    }
}