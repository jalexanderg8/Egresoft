package com.example.foxconntech.egresoft.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.foxconntech.egresoft.R;

public class Login extends AppCompatActivity {

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void onClick(View view) {

        switch (view.getId()){

           case  R.id.btnIngEgresado:
           i=new Intent(this,Principal.class);
            startActivity(i);
               break;
            case  R.id.btnIngUsuario:
                i=new Intent(this,Principal.class);
                startActivity(i);
            case R.id.lblRegistrarse:
                i=new Intent(this,Registro.class);
                startActivity(i);
        }
    }
}
