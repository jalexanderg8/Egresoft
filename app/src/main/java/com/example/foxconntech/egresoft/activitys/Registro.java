package com.example.foxconntech.egresoft.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.foxconntech.egresoft.R;

public class Registro extends AppCompatActivity {

    Spinner comboTitulacion,comboGenero,comboEstadoCivil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        comboGenero=(Spinner)findViewById(R.id.idSpinnerGenero);
        comboEstadoCivil=(Spinner)findViewById(R.id.idSpinnerEstadoCivil);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.combo_titulacion,
                android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.combo_genero,
                android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.combo_estado_civil,
                android.R.layout.simple_spinner_item);

        comboTitulacion.setAdapter(adapter);
        comboGenero.setAdapter(adapter1);
        comboEstadoCivil.setAdapter(adapter2);
    }
}
