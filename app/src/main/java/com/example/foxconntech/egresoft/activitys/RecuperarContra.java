package com.example.foxconntech.egresoft.activitys;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.conexion.Conexion;
import com.example.foxconntech.egresoft.constantes.Constantes;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RecuperarContra extends AppCompatActivity {

    EditText campoEmail;
    Conexion miConexion;
    Session session;
    String correo,contraseña,emailDestinatario,mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_contra);

        campoEmail=findViewById(R.id.txtCorreoRecuperar);

        miConexion=new Conexion(getApplicationContext());


    }

    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnEnviarContraseña:

                if(campoEmail.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(),"Ingrese un correo electronico ",Toast.LENGTH_LONG).show();
                }else{

                    validarCorreo();
                }


                break;

            case R.id.btnCancelarRecuperar:

                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);

                break;

        }
    }

    private void validarCorreo() {

        SQLiteDatabase db=miConexion.getReadableDatabase();

        String parametro[]= {campoEmail.getText().toString()};
        String campo[]={Constantes.DatosEgresados.COLUMNA_CONTRASEÑA};

        try{

            Cursor f=db.query(Constantes.DatosEgresados.TABLA_EGRESADO,campo, Constantes.DatosEgresados.COLUMNA_EMAIL+"=?"
                    ,parametro,null,null,null);
            if( f.moveToFirst()){
                String contra=f.getString(0);

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties properties = new Properties();
                properties.put("mail.smtp.host", "smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.port", "465");

                correo="pruebaegresado@gmail.com";
                contraseña="Egresoft2017";

                mensaje="Su contraseña es "+contra;

                try {

                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo, contraseña);
                        }
                    });

                    if (session != null) {



                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject("Recuperar Contraseña");
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(campoEmail.getText().toString()));
                        message.setContent(mensaje, "text/html; charset=utf-8");
                        Transport.send(message);
                        Toast.makeText(getApplicationContext(), "Correo enviado con exito ", Toast.LENGTH_LONG).show();
                        Intent i=new Intent(getApplicationContext(),Login.class);
                        startActivity(i);



                    }

                } catch (Exception e) {

                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Correo NO enviado ", Toast.LENGTH_LONG).show();

                }



            }else {
                Toast.makeText(getApplicationContext(),"Email No  registrado en el sistema ",Toast.LENGTH_LONG).show();

            }

            f.close();

        }catch (Exception e){

            Toast.makeText(getApplicationContext(),"Error en bd ",Toast.LENGTH_LONG).show();
        }
    }
    }

