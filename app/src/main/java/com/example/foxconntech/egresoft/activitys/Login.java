package com.example.foxconntech.egresoft.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.foxconntech.egresoft.R;

public class Login extends AppCompatActivity {

    Intent i;
    public static String tipo="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_login);

    }

    public void onClick(View view) {

        switch (view.getId()){

           case  R.id.btnEgresado:
               tipo="egresado";
           i=new Intent(this,Principal.class);
            startActivity(i);
               break;
            case  R.id.btnInvitado:
                tipo="invitado";
                i=new Intent(this,Principal.class);
                startActivity(i);
                break;
            case R.id.lblRegistrarse:
                i=new Intent(this,Registro.class);
                startActivity(i);
        }
    }
}