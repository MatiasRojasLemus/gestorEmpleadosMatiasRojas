package org.example.gestorempleadosmatiasrojas.Modelo;

import java.time.LocalDate;

public class Trabajador {
    private String nombre;
    private String puesto;
    private int salario;
    private LocalDate fechaAlta;

    public Trabajador(String nombre, String puesto, int salario, LocalDate fechaAlta) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaAlta = fechaAlta;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public int getSalario() {
        return salario;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
}