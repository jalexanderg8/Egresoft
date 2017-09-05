package com.example.foxconntech.egresoft.activitys;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.foxconntech.egresoft.R;

import java.util.List;

public class Registro extends AppCompatActivity {

    String titulaciones[]={"Titulacion","Tecnologo","Tecnico Profesional","Tecnico","Auxiliar","Operario"};
    String genero[]={"Genero","Hombre","Mujer"};
    String estadoCivil[]={"Estado Civil","Casado","Soltero","Union Libre","Viudo"};
    String modalidad[]={"Modalidad","Presencial","Virtual","Mixta"};
    String numeroFicha[]={"Numero de la Ficha","1196229"};
    String nombreTitulacion[]={"Nombre de la Titulacion","Adsi"};
    String estaLaborando[]={"Esta Laborando","Si","No"};
    String tieneEmpleoDeacuerdo[]={"Tiene empleo por su formacion Sena","Si","No"};
    Spinner comboTitulacion,comboGenero,comboEstadoCivil,comboModalidad,comboNumeroFicha,comboNombreTitulacion,
    comboEstaLaborando,comboTieneEmpleoDeacuerdo;
    private  int dia,mes,ano;

    EditText fechaInicio,fechaFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        comboTitulacion=(Spinner)findViewById(R.id.idSpinnerTipodeTitulacion);
        comboModalidad=(Spinner)findViewById(R.id.idSpinnerModalidad);
        comboNumeroFicha=(Spinner)findViewById(R.id.idSpinnerNumeroFicha);
        comboNombreTitulacion=(Spinner)findViewById(R.id.idSpinnerNombreTitulacion);
        comboEstaLaborando=(Spinner)findViewById(R.id.idSpinnerEstaLaborando);
        comboTieneEmpleoDeacuerdo=(Spinner)findViewById(R.id.idSpinnerTieneEmpleoDeacuerdo);
        comboGenero=(Spinner)findViewById(R.id.idSpinnerGenero);
        comboEstadoCivil=(Spinner)findViewById(R.id.idSpinnerEstadoCivil);

        fechaInicio=(EditText)findViewById(R.id.txtFechaInicio);
        fechaFin=(EditText)findViewById(R.id.txtFechaFin);




        ArrayAdapter<String> adapter1=new ArrayAdapter<>(this,R.layout.spinner_style,genero);

        ArrayAdapter<String> adapter2=new ArrayAdapter<>(this,R.layout.spinner_style,estadoCivil);

        ArrayAdapter<String> adapter3=new ArrayAdapter<>(this,R.layout.spinner_style,titulaciones);

        ArrayAdapter<String> adapter4=new ArrayAdapter<>(this,R.layout.spinner_style,modalidad);

        ArrayAdapter<String> adapter5=new ArrayAdapter<>(this,R.layout.spinner_style,numeroFicha);

        ArrayAdapter<String> adapter6=new ArrayAdapter<>(this,R.layout.spinner_style,nombreTitulacion);

        ArrayAdapter<String> adapter7=new ArrayAdapter<>(this,R.layout.spinner_style,estaLaborando);

        ArrayAdapter<String> adapter8=new ArrayAdapter<>(this,R.layout.spinner_style,tieneEmpleoDeacuerdo);


        comboTieneEmpleoDeacuerdo.setAdapter(adapter8);
        comboEstaLaborando.setAdapter(adapter7);
        comboNombreTitulacion.setAdapter(adapter6);
        comboNumeroFicha.setAdapter(adapter5);
        comboModalidad.setAdapter(adapter4);
        comboTitulacion.setAdapter(adapter3);
        comboGenero.setAdapter(adapter1);
        comboEstadoCivil.setAdapter(adapter2);
    }

    public void onClick(View view) {

        if(view.getId()==R.id.btnInicio){

            final Calendar c=Calendar.getInstance();

            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {

                    fechaInicio.setText(day+"/"+month+"/"+year);

                }
            }
            ,dia,mes,ano);
            datePickerDialog.show();
        }
        if(view.getId()==R.id.btnFin){

            final Calendar c=Calendar.getInstance();

            dia=c.get(Calendar.DAY_OF_MONTH);
            mes=c.get(Calendar.MONTH);
            ano=c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {

                    fechaFin.setText(day+"/"+month+"/"+year);

                }
            }
                    ,dia,mes,ano);
            datePickerDialog.show();
        }

    }
}
