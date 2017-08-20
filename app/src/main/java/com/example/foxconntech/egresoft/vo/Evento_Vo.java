package com.example.foxconntech.egresoft.vo;

/**
 * Created by JULIAN HENAO on 20/08/2017.
 */

public class Evento_Vo {

    private String nombre;
    private String direccion;
    private String fecha;
    private int foto;

    public Evento_Vo(String nombre, String direccion, String fecha, int foto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fecha = fecha;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
