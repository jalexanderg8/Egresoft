package com.example.foxconntech.egresoft.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foxconntech.egresoft.R;

public class Login extends AppCompatActivity {

    Intent i;
    int a=0;
    public static String tipo="";
    EditText contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("prueba","oncreate");


        Log.i("prueba","desps contraseña");
            setContentView(R.layout.activity_login);

        contraseña= (EditText) findViewById(R.id.contraseña);
        Log.i("prueba","desps setContentView");
        Log.i("prueba","valor: "+contraseña);
        String Contraseña=contraseña.getText().toString();
        Log.i("prueba",Contraseña);
    }

    public void onClick(View view) {

        switch (view.getId()){


           case  R.id.btnEgresado:
               if (!contraseña.getText().toString().equals("1234")){
                   Toast.makeText(this,"verifique la contraseña o el usuario para poder ingresar",Toast.LENGTH_LONG).show();
                   Log.i("prueba","pruebaaaa");
               }else{
                   tipo="egresado";
                   i=new Intent(Login.this,Principal.class);
                   startActivity(i);
               }

               break;
            case  R.id.btnInvitado:
                tipo="invitado";
                i=new Intent(Login.this,Principal.class);
                startActivity(i);
                break;
            case R.id.lblRegistrarse:
                i=new Intent(Login.this,RegistroYActualizacionDeDatos.class);
                startActivity(i);
        }
    }
}
