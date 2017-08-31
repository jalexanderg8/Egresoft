package com.example.foxconntech.egresoft.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.foxconntech.egresoft.R;

public class Registro extends AppCompatActivity {

    Spinner comboTitulacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

      comboTitulacion=(Spinner)findViewById(R.id.idSinnerTitulacion);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.combo_titulacion,
                android.R.layout.simple_spinner_item);

        comboTitulacion.setAdapter(adapter);
    }
}
