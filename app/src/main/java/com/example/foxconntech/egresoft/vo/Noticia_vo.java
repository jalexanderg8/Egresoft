package com.example.foxconntech.egresoft.vo;

/**
 * Created by Foxconn Tech on 06/09/2017.
 */

    public class Noticia_vo {

    private String nombreNoticia;
    private String descripcionNoticia;
    private int imagenNoticia;

    public Noticia_vo(String nombreNoticia, String descripcionNoticia, int imagenNoticia) {
        this.nombreNoticia = nombreNoticia;
        this.descripcionNoticia = descripcionNoticia;
        this.imagenNoticia = imagenNoticia;
    }

    public String getNombreNoticia() {
        return nombreNoticia;
    }

    public void setNombreNoticia(String nombreNoticia) {
        this.nombreNoticia = nombreNoticia;
    }

    public String getDescripcionNoticia() {
        return descripcionNoticia;
    }

    public void setDescripcionNoticia(String descripcionNoticia) {
        this.descripcionNoticia = descripcionNoticia;
    }

    public int getImagenNoticia() {
        return imagenNoticia;
    }

    public void setImagenNoticia(int imagenNoticia) {
        this.imagenNoticia = imagenNoticia;
    }
}
