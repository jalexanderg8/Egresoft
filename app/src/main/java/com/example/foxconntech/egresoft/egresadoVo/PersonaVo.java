package com.example.foxconntech.egresoft.egresadoVo;

/**
 * Created by Foxconn Tech on 06/09/2017.
 */

    public class PersonaVo {

        private String idEgresado;
        private String tipoDocumento;
        private String nombres;
        private String apellidos;
        private String telefono;
        private String telefono_alterno;
        private String email;
        private String email_alterno;
        private String lugarResidencia;
        private String contraseña;
        private String modalidad;
        private String tipoTitulacion;
        private String numeroFicha;
        private String fechaInicio;
        private String fechaFin;
        private String nombre_titulacion;


    public PersonaVo(String idEgresado, String tipoDocumento, String nombres, String apellidos, String telefono,
                     String telefono_alterno, String email, String email_alterno, String lugarResidencia,
                     String contraseña, String modalidad,String fechaInicio, String fechaFin) {

        this.idEgresado = idEgresado;
        this.tipoDocumento = tipoDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.telefono_alterno = telefono_alterno;
        this.email = email;
        this.email_alterno = email_alterno;
        this.lugarResidencia = lugarResidencia;
        this.contraseña = contraseña;
        this.modalidad = modalidad;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

    }

    public PersonaVo(String idEgresado, String tipoDocumento, String nombres, String apellidos, String email, String contraseña) {
        this.idEgresado = idEgresado;
        this.tipoDocumento = tipoDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.contraseña=contraseña;


    }

    public PersonaVo(String idEgresado, String tipoDocumento, String nombres, String apellidos, String telefono,
                     String telefono_alterno, String email, String email_alterno, String lugarResidencia,
                     String contraseña, String modalidad, String tipoTitulacion, String numeroFicha,
                     String fechaInicio, String fechaFin, String nombre_titulacion) {

        this.idEgresado = idEgresado;
        this.tipoDocumento = tipoDocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.telefono_alterno = telefono_alterno;
        this.email = email;
        this.email_alterno = email_alterno;
        this.lugarResidencia = lugarResidencia;
        this.contraseña = contraseña;
        this.modalidad = modalidad;
        this.tipoTitulacion = tipoTitulacion;
        this.numeroFicha = numeroFicha;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombre_titulacion = nombre_titulacion;
    }

    public String getIdEgresado() {
        return idEgresado;
    }

    public void setIdEgresado(String idEgresado) {
        this.idEgresado = idEgresado;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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

    public String getLugarResidencia() {
        return lugarResidencia;
    }

    public void setLugarResidencia(String lugarResidencia) {
        this.lugarResidencia = lugarResidencia;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getTipoTitulacion() {
        return tipoTitulacion;
    }

    public void setTipoTitulacion(String tipoTitulacion) {
        this.tipoTitulacion = tipoTitulacion;
    }

    public String getNumeroFicha() {
        return numeroFicha;
    }

    public void setNumeroFicha(String numeroFicha) {
        this.numeroFicha = numeroFicha;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombre_titulacion() {
        return nombre_titulacion;
    }

    public void setNombre_titulacion(String nombre_titulacion) {
        this.nombre_titulacion = nombre_titulacion;
    }


}
