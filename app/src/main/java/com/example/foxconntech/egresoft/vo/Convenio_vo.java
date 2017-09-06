package com.example.foxconntech.egresoft.vo;

/**
 * Created by Foxconn Tech on 06/09/2017.
 */

    public class Convenio_vo {

    private String nombreConvenio;
    private String infoConvenio;
    private  String contactoConvenio;
    private  int imagenConvenio;

    public Convenio_vo(String nombreConvenio, String infoConvenio, String contactoConvenio, int imagenConvenio) {
        this.nombreConvenio = nombreConvenio;
        this.infoConvenio = infoConvenio;
        this.contactoConvenio = contactoConvenio;
        this.imagenConvenio = imagenConvenio;
    }

    public String getNombreConvenio() {
        return nombreConvenio;
    }

    public void setNombreConvenio(String nombreConvenio) {
        this.nombreConvenio = nombreConvenio;
    }

    public String getInfoConvenio() {
        return infoConvenio;
    }

    public void setInfoConvenio(String infoConvenio) {
        this.infoConvenio = infoConvenio;
    }

    public String getContactoConvenio() {
        return contactoConvenio;
    }

    public void setContactoConvenio(String contactoConvenio) {
        this.contactoConvenio = contactoConvenio;
    }

    public int getImagenConvenio() {
        return imagenConvenio;
    }

    public void setImagenConvenio(int imagenConvenio) {
        this.imagenConvenio = imagenConvenio;
    }
}
