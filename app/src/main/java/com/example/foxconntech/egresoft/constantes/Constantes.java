package com.example.foxconntech.egresoft.constantes;

import android.provider.BaseColumns;

/**
 * Created by Foxconn Tech on 13/08/2017.
 */

    public class Constantes {

    public Constantes() {
    }

    public static class DatosEgresados implements BaseColumns{

        public static final String TABLA_EGRESADO = "egresado";
        public static final String COLUMNA_NOMBRES = "id";
        public static final String COLUMNA_PRIMER_APELLIDO = "primer_apellido";
        public static final String COLUMNA_SEGUNDO_APELLIDO = "segundo_apellido";
        public static final String COLUMNA_EMAIL = "email";
        public static final String COLUMNA_TELEFONO = "telefono";
        public static final String COLUMNA_GENERO = "genero";
        public static final String COLUMNA_ESTADO_CIVIL = "estado_civil";
        public static final String COLUMNA_ESTA_LABORANDO = "esta_laborando";
        public static final String COLUMNA_DEACUERDO = "tiene_empleo_deacuerdo";
        public static final String COLUMNA_LE_GUSTARIA_RECIBIR = "recibir_correos";

        public static final String TABLA_TELEFONO_ALTERNO = "telefono_alterno";
        public static final String COLUMNA_ID_TELEFONO = "id_telefono";
        public static final String COLUMNA_NUMERO_TELEFONO = "numero_telefono";


        public static final String TABLA_EMAIL_ALTERNO = "email_alterno";
        public static final String COLUMNA_ID_EMAIL_ALTERNO = "id_email";
        public static final String COLUMNA_EMAIL_ALTERNO="direccion_de_email";

        public static final String TABLA_TITULACIION="titulacion";
        public static final String COLUMNA_ID_TITULACION="id_titulacion";
        public static final String COLUMNA_NOMBRE_TITULACION="nombre_titulacion";

        public static final String TABLA_MODALIDAD="modalidad";
        public static final String COLUMNA_ID_MODALIDAD="id_modalidad";
        public static final String COLUMNA_TIPO_MODALIDAD="tipo_modalidad";



    }
}
