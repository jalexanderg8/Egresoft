package com.example.foxconntech.egresoft.vo;

import java.io.Serializable;

/**
 * Created by JULIAN HENAO on 21/08/2017.
 */

public class Estudio_Vo implements Serializable{

    private String nombre;
    private String horarios;
    private String direccion;

    public Estudio_Vo(String nombre, String horarios, String direccion) {
        this.nombre = nombre;
        this.horarios = horarios;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
