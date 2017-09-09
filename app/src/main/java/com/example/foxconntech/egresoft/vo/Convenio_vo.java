package com.example.foxconntech.egresoft.vo;

/**
 * Created by JULIAN HENAO on 08/09/2017.
 */

public class Convenio_vo {

    public String nombre;
    public String descripcion;
    public String contacto;
    public int foto;

    public Convenio_vo(String nombre, String descripcion, String contacto,int foto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contacto = contacto;
        this.foto=foto;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
