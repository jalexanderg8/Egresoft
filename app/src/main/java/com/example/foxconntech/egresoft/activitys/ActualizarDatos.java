package com.example.foxconntech.egresoft.activitys;

import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.conexion.Conexion;
import com.example.foxconntech.egresoft.constantes.Constantes;

import java.util.Calendar;

public class ActualizarDatos extends AppCompatActivity {


    Conexion miConexion;
    SQLiteDatabase db;
    EditText tipoDocumento, numeroDocumento, nombres, apellidos, email, emailAlterno, telefono, telefonoAlterno, lugarResidencia,
            contraseña, repitaContraseña, tipoTitulacion, nombreTitulacion, numeroFicha, modalidad, fechaInicio, fechaFin;

    private int dia,mes,año;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar_datos);


        tipoDocumento = findViewById(R.id.txtTipoDocumento);
        tipoDocumento.setEnabled(false);
        numeroDocumento = findViewById(R.id.txtNumeroDocumento);
        numeroDocumento.setEnabled(false);
        nombres = findViewById(R.id.txtNombres);
        nombres.setEnabled(false);
        apellidos = findViewById(R.id.txtApellidos);
        apellidos.setEnabled(false);
        email = findViewById(R.id.txtEmailPrincipal);
        email.setEnabled(false);
        emailAlterno = findViewById(R.id.txtEmailAlterno);
        telefono = findViewById(R.id.txtTelefonoPrincipal);
        telefonoAlterno = findViewById(R.id.txtTelefonoAlterno);
        lugarResidencia = findViewById(R.id.txtLugarResidencia);
        contraseña = findViewById(R.id.txtContraseña);
        repitaContraseña = findViewById(R.id.txtRepitaContraseña);
        tipoTitulacion = findViewById(R.id.txtTipoTitulacion);
        tipoTitulacion.setEnabled(false);
        nombreTitulacion = findViewById(R.id.txtNombreTitulacion);
        nombreTitulacion.setEnabled(false);
        numeroFicha = findViewById(R.id.txtNumeroFicha);
        numeroFicha.setEnabled(false);
        modalidad = findViewById(R.id.txtModalidad);
        fechaInicio = findViewById(R.id.txtFechaInicio);
        fechaFin = findViewById(R.id.txtFechaFin);

        miConexion = new Conexion(getApplicationContext());


        Bundle miBundle = this.getIntent().getExtras();

        if (miBundle != null) {

            db = miConexion.getReadableDatabase();

            String idEgresado = miBundle.getString("idEgresado");


            String parametro[] = {idEgresado};
            String campos[] = {Constantes.DatosEgresados.COLUMNA_TIPO_DOCUMENTO, Constantes.DatosEgresados.COLUMNA_ID_EGRESADO,
                    Constantes.DatosEgresados.COLUMNA_NOMBRES, Constantes.DatosEgresados.COLUMNA_APELLIDOS,
                    Constantes.DatosEgresados.COLUMNA_EMAIL, Constantes.DatosEgresados.COLUMNA_TELEFONO,
                    Constantes.DatosEgresados.COLUMNA_TELEFONO_ALTERNO, Constantes.DatosEgresados.COLUMNA_EMAIL_ALTERNO,
                    Constantes.DatosEgresados.COLUMNA_LUGAR_RESIDENCIA, Constantes.DatosEgresados.COLUMNA_CONTRASEÑA,
                    Constantes.DatosEgresados.COLUMNA_TIPO_TITULACION, Constantes.DatosEgresados.COLUMNA_NOMBRE_TITULACION,
                    Constantes.DatosEgresados.COLUMNA_NUMERO_FICHA, Constantes.DatosEgresados.COLUMNA_MODALIDAD,
                    Constantes.DatosEgresados.COLUMNA_FECHA_INICIO, Constantes.DatosEgresados.COLUMNA_FECHA_FIN};

            try {

                Cursor f = db.query(Constantes.DatosEgresados.TABLA_EGRESADO, campos, Constantes.DatosEgresados.COLUMNA_ID_EGRESADO + "=?"
                        , parametro, null, null, null);

                if (f.moveToFirst()) {

                    if (!f.isNull(0)) {
                        tipoDocumento.setText(f.getString(0));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(1)) {
                        numeroDocumento.setText(f.getString(1));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(2)) {
                        nombres.setText(f.getString(2));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(3)) {
                        apellidos.setText(f.getString(3));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(4)) {
                        email.setText(f.getString(4));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(5)) {
                        telefono.setText(f.getString(5));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(6)) {
                        telefonoAlterno.setText(f.getString(6));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(7)) {
                        emailAlterno.setText(f.getString(7));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(8)) {
                        lugarResidencia.setText(f.getString(8));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(9)) {
                        contraseña.setText(f.getString(9));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(10)) {
                        tipoTitulacion.setText(f.getString(10));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(11)) {
                        nombreTitulacion.setText(f.getString(11));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(12)) {
                        numeroFicha.setText(f.getString(12));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(13)) {
                        modalidad.setText(f.getString(13));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(14)) {
                        fechaInicio.setText(f.getString(14));
                    } else {
                        f.getPosition();
                    }
                    if (!f.isNull(15)) {
                        fechaFin.setText(f.getString(15));
                    } else {
                        f.close();
                    }

                }

            } catch (Exception e) {

                Toast.makeText(getApplicationContext(), "Error en bd ", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "No hay informacion Registrada", Toast.LENGTH_LONG).show();
        }


    }

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnActualizar:

                if (telefono.getText().toString().trim().equals("") && telefonoAlterno.getText().toString().trim().equals("") &&
                        emailAlterno.getText().toString().trim().equals("") && lugarResidencia.getText().toString().trim().equals("") &&
                        contraseña.getText().toString().trim().equals("") && modalidad.getText().toString().trim().equals("") &&
                        fechaInicio.getText().toString().trim().equals("") && fechaFin.getText().toString().trim().equals("")) {

                    Toast.makeText(getApplicationContext(), "No hay informacion para Actualizar", Toast.LENGTH_LONG).show();

                } else {

                    validarContraseña();
                }
                break;
            case R.id.btnCancelar:

                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                limpiar();
                break;

            case R.id.btnFechaInicio:

                final Calendar c=Calendar.getInstance();

                dia=c.get(Calendar.DAY_OF_MONTH);
                mes=c.get(Calendar.MONTH);
                año=c.get(Calendar.YEAR);

                DatePickerDialog datePicker=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        fechaInicio.setText(day+"/"+month+"/"+year);
                    }
                }
                ,dia,mes,año);
                datePicker.show();
                break;
            case R.id.btnFechaFin:

                final Calendar d=Calendar.getInstance();

                dia=d.get(Calendar.DAY_OF_MONTH);
                mes=d.get(Calendar.MONTH);
                año=d.get(Calendar.YEAR);

                DatePickerDialog datePicke=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        fechaFin.setText(day+"/"+month+"/"+year);
                    }
                }
                        ,dia,mes,año);
                datePicke.show();
                break;
        }

    }

    private void validarContraseña() {

        if (contraseña.getText().toString().trim().equals("") && repitaContraseña.getText().toString().trim().equals("")) {

            Toast.makeText(getApplicationContext(), "los campos de contraseña no pueden estar vacios ", Toast.LENGTH_LONG).show();
        } else {

            String contra1 = contraseña.getText().toString();
            String contra2 = repitaContraseña.getText().toString();

            if (contra1.equals(contra2)) {

                actualizarEgresado();
            } else {

                Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void actualizarEgresado() {


        Bundle miBundle = this.getIntent().getExtras();

        if (miBundle != null) {

            db = miConexion.getReadableDatabase();

            String idEgresado = miBundle.getString("idEgresado");

            String parametro[] = {idEgresado};
            ContentValues valores = new ContentValues();
            valores.put(Constantes.DatosEgresados.COLUMNA_TELEFONO, telefono.getText().toString());
            valores.put(Constantes.DatosEgresados.COLUMNA_TELEFONO_ALTERNO, telefonoAlterno.getText().toString());
            valores.put(Constantes.DatosEgresados.COLUMNA_EMAIL_ALTERNO, emailAlterno.getText().toString());
            valores.put(Constantes.DatosEgresados.COLUMNA_LUGAR_RESIDENCIA, lugarResidencia.getText().toString());
            valores.put(Constantes.DatosEgresados.COLUMNA_CONTRASEÑA, contraseña.getText().toString());
            valores.put(Constantes.DatosEgresados.COLUMNA_MODALIDAD, modalidad.getText().toString());
            valores.put(Constantes.DatosEgresados.COLUMNA_FECHA_INICIO, fechaInicio.getText().toString());
            valores.put(Constantes.DatosEgresados.COLUMNA_FECHA_FIN, fechaFin.getText().toString());

            db.update(Constantes.DatosEgresados.TABLA_EGRESADO, valores, Constantes.DatosEgresados.COLUMNA_ID_EGRESADO + "=?",
                    parametro);

            Toast.makeText(getApplicationContext(), "Egresado Actualizado Satisfactoriamente", Toast.LENGTH_LONG).show();
            db.close();

            limpiar();
            Intent i=new Intent(getApplicationContext(),Login.class);
            startActivity(i);



        }
    }

    private void limpiar() {

        tipoDocumento.setText("");
        numeroDocumento.setText("");
        nombres.setText("");
        apellidos.setText("");
        email.setText("");
        telefono.setText("");
        telefonoAlterno.setText("");
        emailAlterno.setText("");
        lugarResidencia.setText("");
        contraseña.setText("");
        repitaContraseña.setText("");
        tipoTitulacion.setText("");
        nombreTitulacion.setText("");
        numeroFicha.setText("");
        fechaInicio.setText("");
        fechaFin.setText("");
    }
}

