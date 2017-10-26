package com.example.foxconntech.egresoft.activitys;


import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.conexion.Conexion;
import com.example.foxconntech.egresoft.constantes.Constantes;
import com.example.foxconntech.egresoft.egresadoDao.EgresadoDao;

public class Login extends AppCompatActivity {


    Conexion miConexion;
    EditText egresado,contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

        egresado=(EditText)findViewById(R.id.usuario);
        contraseña=(EditText)findViewById(R.id.contraseña);
        miConexion=new Conexion(getApplicationContext());

        validarSession();





    }

    private void validarSession() {

        SharedPreferences preferencias=getSharedPreferences("egresado",MODE_PRIVATE);

        String user=preferencias.getString("usuario","vacio");
        String pass=preferencias.getString("pass","vacio");

        if(!user.equals("vacio")&&!pass.equals("vacio")){

            Intent i=new Intent(getApplicationContext(),Principal.class);
            startActivity(i);
        }
    }

    public void onClick(View view) {

        switch (view.getId()){


           case  R.id.btnEgresado:

               if(egresado.getText().toString().trim().equals("")||contraseña.getText().toString().trim().equals("")){

                   Toast.makeText(getApplicationContext(),"No deje campos vacios",Toast.LENGTH_LONG).show();

               }else{

                   validarEgresado();

               }
               break;
            case  R.id.btnInvitado:

                Intent i=new Intent(getApplicationContext(),Principal.class);
                startActivity(i);
                break;
            case R.id.lblRegistrarse:

                Intent in=new Intent(getApplicationContext(),ValidarUsuario.class);
                startActivity(in);
                break;



        }
    }

    private void validarEgresado() {

        //egresadoDao=new EgresadoDao();
        SQLiteDatabase db=miConexion.getReadableDatabase();



        String parametros[]= {egresado.getText().toString(),contraseña.getText().toString()};
        String campos[]={Constantes.DatosEgresados.COLUMNA_EMAIL,Constantes.DatosEgresados.COLUMNA_CONTRASEÑA};

        try{

            Cursor f=db.query(Constantes.DatosEgresados.TABLA_EGRESADO,campos, Constantes.DatosEgresados.COLUMNA_EMAIL+"=? and "+
                    Constantes.DatosEgresados.COLUMNA_CONTRASEÑA+"=?",parametros,null,null,null);
           if( f.moveToFirst()){

               guardarSession();
               Intent i=new Intent(getApplicationContext(),Principal.class);
               startActivity(i);

           }else {
                Toast.makeText(getApplicationContext(),"No esta registrado en el sistema ",Toast.LENGTH_LONG).show();
               limpiar();
           }

           f.close();

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"Error en bd ",Toast.LENGTH_LONG).show();
        }
    }

    private void limpiar() {

        egresado.setText("");
        contraseña.setText("");
    }

    private void guardarSession() {

        SharedPreferences preferencias=getSharedPreferences("egresado",MODE_PRIVATE);

        String user=egresado.getText().toString();
        String pass=contraseña.getText().toString();

        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("usuario",user);
        editor.putString("pass",pass);
        editor.commit();
    }
}
