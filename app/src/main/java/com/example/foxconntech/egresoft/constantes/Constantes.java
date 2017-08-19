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
        public static final String COLUMNA_ID_EGRESADO="documento";
        public static final String COLUMNA_NOMBRES = "nombres";
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
        public static final String COLUMNA_ID_TELEFONO_ALTERNO = "id_telefono";
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

        public static final String TEXT_TYPE = " TEXT (45)";
        public static final String COMMA_SEP = ",";

        public static final String CREAR_TABLA_EGRESADO =
                "CREATE TABLE " + TABLA_EGRESADO + " (" +
                        COLUMNA_ID_EGRESADO + " INTEGER PRIMARY KEY," +
                        COLUMNA_NOMBRES + TEXT_TYPE + COMMA_SEP +
                        COLUMNA_PRIMER_APELLIDO+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_SEGUNDO_APELLIDO+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_EMAIL+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_TELEFONO+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_GENERO+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_ESTADO_CIVIL+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_ESTA_LABORANDO+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_DEACUERDO+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_LE_GUSTARIA_RECIBIR+ TEXT_TYPE + " )";

        public static final String BORRAR_TABLA_EGRESADO =
                "DROP TABLE IF EXISTS " + TABLA_EGRESADO;

        public static final String CREAR_TABLA_TELEFONO_ALTERNO =
                "CREATE TABLE " + TABLA_TELEFONO_ALTERNO+ "("+
                        COLUMNA_ID_TELEFONO_ALTERNO+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_NUMERO_TELEFONO+TEXT_TYPE+ " )";

        public static final String BORRAR_TABLA_TELEFONO_ALTERNO =
                "DROP TABLE IF EXISTS " + TABLA_TELEFONO_ALTERNO;

        public static final String CREAR_TABLA_EMAIL_ALTERNO =
                "CREATE TABLE " + TABLA_EMAIL_ALTERNO+ "("+
                        COLUMNA_ID_EMAIL_ALTERNO+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_EMAIL_ALTERNO+TEXT_TYPE+ " )";

        public static final String BORRAR_TABLA_EMAIL_ALTERNO =
                "DROP TABLE IF EXISTS " + TABLA_EMAIL_ALTERNO;

        public static final String CREAR_TABLA_TITULACION =
                "CREATE TABLE " + TABLA_TITULACIION+ "("+
                        COLUMNA_ID_TITULACION+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_NOMBRE_TITULACION+TEXT_TYPE+ " )";

        public static final String BORRAR_TABLA_TITULACION =
                "DROP TABLE IF EXISTS " + TABLA_TITULACIION;

        public static final String CREAR_TABLA_MODALIDAD =
                "CREATE TABLE " + TABLA_MODALIDAD+ "("+
                        COLUMNA_ID_MODALIDAD+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_TIPO_MODALIDAD+TEXT_TYPE+ " )";

        public static final String BORRAR_TABLA_MODALIDAD =
                "DROP TABLE IF EXISTS " + TABLA_MODALIDAD;

    }
}
