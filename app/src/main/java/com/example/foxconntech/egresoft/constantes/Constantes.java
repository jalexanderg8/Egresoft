package com.example.foxconntech.egresoft.constantes;

import android.database.CursorIndexOutOfBoundsException;
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
        public static final String COLUMNA_TIPO_DOCUMENTO="tipo_documento";
        public static final String COLUMNA_NOMBRES = "nombres";
        public static final String COLUMNA_APELLIDOS = "apellidos";
        public static final String COLUMNA_TELEFONO = "telefono";
        public static final String COLUMNA_TELEFONO_ALTERNO = "id_telefono";
        public static final String COLUMNA_EMAIL = "email";
        public static final String COLUMNA_EMAIL_ALTERNO = "id_email";
        public static final String COLUMNA_LUGAR_RESIDENCIA="lugar_residencia";
        public static final String COLUMNA_CONTRASEÑA="contrasena";
        public static final String COLUMNA_MODALIDAD="tipo_modalidad";
        public static final String COLUMNA_TIPO_TITULACION="tipo_titulacion";
        public static final String COLUMNA_NOMBRE_TITULACION="nombre_titulacion";
        public static final String COLUMNA_NUMERO_FICHA="numero_ficha";
        public static final String COLUMNA_FECHA_INICIO="fecha_inicio";
        public static final String COLUMNA_FECHA_FIN="fecha_fin";


        public static final String TABLA_EVENTO = "evento";
        public static final String COLUMNA_NOMBRE_EVENTO="nombre_evento";
        public static final String COLUMNA_LUGAR_EVENTO= "lugar_evento";
        public static final String COLUMNA_FECHA_EVENTO= "fecha_evento";
        public static final String COLUMNA_DESCRIPCION_EVENTO="descripcion_evento";
        public static final String COLUMNA_IMAGEN_EVENTO = "imagen_evento";

        public static final String TABLA_CONVENIO = "convenio";
        public static final String COLUMNA_NOMBRE_CONVENIO="nombre_convenio";
        public static final String COLUMNA_INFO_CONVENIO= "info_convenio";
        public static final String COLUMNA_CONTACTO= "contacto";
        public static final String COLUMNA_IMAGEN_CONVENIO = "imagen_convenio";

        public static final String TABLA_NOTICIA="noticia";
        public static final String COLUMNA_NOMBRE_NOTICIA="nombre_noticia";
        public static final String COLUMNA_DESCRIPCION_NOTICIA="descripcion_noticia";
        public static final String COLUMNA_IMAGEN_NOTICIA = "imagen_convenio";

        public static final String TEXT_TYPE = " TEXT ";
        public static final String COMMA_SEP = ",";
        public static final String NOT_NULL=" NOT NULL ";

        public static final String CREAR_TABLA_NOTICIAS=
                "CREATE TABLE "+TABLA_NOTICIA+" ("+
                        COLUMNA_NOMBRE_NOTICIA+TEXT_TYPE+NOT_NULL+COMMA_SEP+
                        COLUMNA_DESCRIPCION_NOTICIA+TEXT_TYPE+NOT_NULL+COMMA_SEP+
                        COLUMNA_IMAGEN_NOTICIA+TEXT_TYPE+NOT_NULL+" )";

        public static final String BORRAR_TABLA_NOTICIAS =
                "DROP TABLE IF EXISTS " + TABLA_NOTICIA;

        public static final String CREAR_TABLA_CONVENIO=
                "CREATE TABLE "+TABLA_CONVENIO+" ("+
                        COLUMNA_NOMBRE_CONVENIO+TEXT_TYPE+NOT_NULL+COMMA_SEP+
                        COLUMNA_INFO_CONVENIO+TEXT_TYPE+NOT_NULL+COMMA_SEP+
                        COLUMNA_CONTACTO+TEXT_TYPE+NOT_NULL+COMMA_SEP+
                        COLUMNA_IMAGEN_CONVENIO+TEXT_TYPE+NOT_NULL+" )";

        public static final String BORRAR_TABLA_CONVENIO =
                "DROP TABLE IF EXISTS " + TABLA_CONVENIO;

        public static final String CREAR_TABLA_EVENTO=
                "CREATE TABLE "+TABLA_EVENTO+" ("+
                        COLUMNA_NOMBRE_EVENTO+TEXT_TYPE+NOT_NULL+COMMA_SEP+
                        COLUMNA_LUGAR_EVENTO+TEXT_TYPE+NOT_NULL+COMMA_SEP+
                        COLUMNA_FECHA_EVENTO+" DATE "+NOT_NULL+COMMA_SEP+
                        COLUMNA_DESCRIPCION_EVENTO+TEXT_TYPE+NOT_NULL+COMMA_SEP+
                        COLUMNA_IMAGEN_EVENTO+TEXT_TYPE+NOT_NULL+" )";

        public static final String BORRAR_TABLA_EVENTO =
                "DROP TABLE IF EXISTS " + TABLA_EVENTO;

        public static final String CREAR_TABLA_EGRESADO =
                "CREATE TABLE " + TABLA_EGRESADO + " (" +
                        COLUMNA_ID_EGRESADO + " INTEGER PRIMARY KEY ,"+
                        COLUMNA_TIPO_DOCUMENTO+TEXT_TYPE+NOT_NULL+COMMA_SEP+
                        COLUMNA_NOMBRES + TEXT_TYPE +NOT_NULL+ COMMA_SEP +
                        COLUMNA_APELLIDOS+TEXT_TYPE+NOT_NULL+COMMA_SEP+
                        COLUMNA_TELEFONO+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_TELEFONO_ALTERNO+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_EMAIL+TEXT_TYPE+NOT_NULL+COMMA_SEP+
                        COLUMNA_EMAIL_ALTERNO+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_LUGAR_RESIDENCIA+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_CONTRASEÑA+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_MODALIDAD+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_TIPO_TITULACION+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_NOMBRE_TITULACION+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_NUMERO_FICHA+TEXT_TYPE+COMMA_SEP+
                        COLUMNA_FECHA_INICIO+" DATE "+COMMA_SEP+
                        COLUMNA_FECHA_FIN+" DATE "+" )";

        public static final String BORRAR_TABLA_EGRESADO =
                "DROP TABLE IF EXISTS " + TABLA_EGRESADO;
    }
}
