package com.example.foxconntech.egresoft.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
