package com.example.foxconntech.egresoft.constantes;

import android.provider.BaseColumns;

/**
 * Created by Foxconn Tech on 13/08/2017.
 */

    public class Constantes {

    public Constantes() {
    }

    public static class Datos implements BaseColumns{

        public static final String NOMBRE_TABLA = "entry";
        public static final String COLUMNA_NOMBRES = "title";
        public static final String COLUMNA_APELLIDOS = "subtitle";
    }
}
