package com.example.foxconntech.egresoft.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.foxconntech.egresoft.R;

public class ConfirmacionAsistencia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_asistencia);
    }

    public void onClick(View view) {
        if (R.id.btnRegistrarAlEvento==view.getId()){
            finish();
            Intent i=new Intent(this,RegistroYActualizacionDeDatos.class);
            startActivity(i);
        }else if(R.id.btnNoRegistrar==view.getId()){
            finish();
        }
    }

}
