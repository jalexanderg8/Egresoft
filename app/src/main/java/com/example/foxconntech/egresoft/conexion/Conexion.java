package com.example.foxconntech.egresoft.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.foxconntech.egresoft.constantes.Constantes;

/**
 * Created by Foxconn Tech on 19/08/2017.
 */

    public class Conexion extends SQLiteOpenHelper{


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "egresoft_bd";

    public Conexion(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(Constantes.DatosEgresados.CREAR_TABLA_EGRESADO);
        db.execSQL(Constantes.DatosEgresados.CREAR_TABLA_CONVENIO);
        db.execSQL(Constantes.DatosEgresados.CREAR_TABLA_EVENTO);
        db.execSQL(Constantes.DatosEgresados.CREAR_TABLA_NOTICIAS);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(Constantes.DatosEgresados.BORRAR_TABLA_EGRESADO);
        db.execSQL(Constantes.DatosEgresados.BORRAR_TABLA_CONVENIO);
        db.execSQL(Constantes.DatosEgresados.BORRAR_TABLA_EVENTO);
        db.execSQL(Constantes.DatosEgresados.BORRAR_TABLA_NOTICIAS);

        onCreate(db);

    }
}
