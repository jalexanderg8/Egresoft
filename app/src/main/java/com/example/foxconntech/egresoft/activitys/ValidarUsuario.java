package com.example.foxconntech.egresoft.activitys;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.conexion.Conexion;
import com.example.foxconntech.egresoft.constantes.Constantes;

public class ValidarUsuario extends AppCompatActivity {

    EditText usuario;
    Conexion miConexion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_usuario);

        usuario=(EditText)findViewById(R.id.usuario);
        miConexion=new Conexion(getApplicationContext());



    }

    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnValidar:

                validarUsuario();
        }


    }

    private void validarUsuario() {


            SQLiteDatabase db=miConexion.getReadableDatabase();



            String parametros[]= {usuario.getText().toString()};
            String campos[]={Constantes.DatosEgresados.COLUMNA_ID_EGRESADO};

            try{

                Cursor f=db.query(Constantes.DatosEgresados.TABLA_EGRESADO,campos, Constantes.DatosEgresados.COLUMNA_ID_EGRESADO+"=?"
                        ,parametros,null,null,null);
                if( f.moveToFirst()){
                    String id=f.getString(0);
                    Intent i=new Intent(getApplicationContext(),ActualizarDatos.class);
                    Bundle miBundle=new Bundle();
                    miBundle.putString("idEgresado",id);
                    i.putExtras(miBundle);
                    startActivity(i);
                    limpiar();

                }else {
                    Toast.makeText(getApplicationContext(),"No esta registrado en el sistema ",Toast.LENGTH_LONG).show();
                    limpiar();
                    Intent i=new Intent(getApplicationContext(),Login.class);
                    startActivity(i);
                }

                f.close();

            }catch (Exception e){

                Toast.makeText(getApplicationContext(),"Error en bd ",Toast.LENGTH_LONG).show();
            }
        }

    private void limpiar() {
        usuario.setText("");
    }
}

