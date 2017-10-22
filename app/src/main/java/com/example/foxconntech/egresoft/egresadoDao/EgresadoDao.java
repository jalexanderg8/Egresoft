package com.example.foxconntech.egresoft.egresadoDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;

import com.example.foxconntech.egresoft.conexion.Conexion;
import com.example.foxconntech.egresoft.constantes.Constantes.DatosEgresados;

/**
 * Created by Foxconn Tech on 06/09/2017.
 */

public class EgresadoDao extends AppCompatActivity{


    Conexion miConexion=new Conexion(getApplicationContext());
    SQLiteDatabase db;
    private String usuario;
    private String pass;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }




    public String verificarEgresado(String usuario, String pass) {


        this.usuario=usuario;
        this.pass=pass;
        String res;
        db=miConexion.getReadableDatabase();

       String parametros[]= {usuario, pass};
        String campos[]={DatosEgresados.COLUMNA_NOMBRES};

        try{

            Cursor f=db.query(DatosEgresados.TABLA_EGRESADO,campos, DatosEgresados.COLUMNA_EMAIL+"=? and"+
                    DatosEgresados.COLUMNA_CONTRASEÑA+"=?",parametros,null,null,null);
           if( f.moveToFirst()){

               res="egresado";

           }else{

               res="error";
           }
           f.close();
        }catch (Exception e){

            res="error en bd";
        }


        return res;
    }
}
