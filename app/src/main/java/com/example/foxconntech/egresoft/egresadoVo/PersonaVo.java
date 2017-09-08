package com.example.foxconntech.egresoft.egresadoVo;

/**
 * Created by Foxconn Tech on 06/09/2017.
 */

    public class PersonaVo {

        private String nombres;
        private String apellidos;
        private String nombre_titulacion;
        private String telefono;
        private String telefono_alterno;
        private String email;
        private String email_alterno;

    public PersonaVo(String nombres, String apellidos, String nombre_titulacion, String telefono, String telefono_alterno, String email, String email_alterno) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nombre_titulacion = nombre_titulacion;
        this.telefono = telefono;
        this.telefono_alterno = telefono_alterno;
        this.email = email;
        this.email_alterno = email_alterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre_titulacion() {
        return nombre_titulacion;
    }

    public void setNombre_titulacion(String nombre_titulacion) {
        this.nombre_titulacion = nombre_titulacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono_alterno() {
        return telefono_alterno;
    }

    public void setTelefono_alterno(String telefono_alterno) {
        this.telefono_alterno = telefono_alterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_alterno() {
        return email_alterno;
    }

    public void setEmail_alterno(String email_alterno) {
        this.email_alterno = email_alterno;
    }
}
