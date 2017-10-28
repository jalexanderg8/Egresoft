package com.example.foxconntech.egresoft.activitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.fragments.ContactarFragment;
import com.example.foxconntech.egresoft.fragments.Desarrolladores;
import com.example.foxconntech.egresoft.fragments.DetalleAcademico;
import com.example.foxconntech.egresoft.fragments.DetalleConvenio;
import com.example.foxconntech.egresoft.fragments.EventosFragment;
import com.example.foxconntech.egresoft.fragments.FragmentConvenio;
import com.example.foxconntech.egresoft.fragments.P_AcademicoFragment;
import com.example.foxconntech.egresoft.fragments.PortalLaboral;
import com.example.foxconntech.egresoft.interfaces.IComunicaFragments;
import com.example.foxconntech.egresoft.vo.Convenio_vo;
import com.example.foxconntech.egresoft.vo.Estudio_Vo;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Principal extends AppCompatActivity implements EventosFragment.OnFragmentInteractionListener,
        P_AcademicoFragment.OnFragmentInteractionListener,Desarrolladores.OnFragmentInteractionListener
,PortalLaboral.OnFragmentInteractionListener,FragmentConvenio.OnFragmentInteractionListener
        ,ContactarFragment.OnFragmentInteractionListener,DetalleAcademico.OnFragmentInteractionListener
,DetalleConvenio.OnFragmentInteractionListener,IComunicaFragments{

    public static boolean info=false;
    BottomNavigationView menu;
    Fragment miFragment;
    Toolbar barra_superior;
    Intent miIntent;
    EditText txtAsunto,txtMensaje;
    String correo,contra;
    Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        barra_superior= (Toolbar) findViewById(R.id.barra_superior);
        setSupportActionBar(barra_superior);

        menu= (BottomNavigationView) findViewById(R.id.menu_inferior);

        validarSession();
        txtAsunto=findViewById(R.id.txtAsuntoCorreo);
        txtMensaje=findViewById(R.id.txtMensajeCorreo);

        correo="pruebaegresado@gmail.com";
        contra="Egresoft2017";

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.laboral:
                        miFragment=new PortalLaboral();
                        //pLaboral.set
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();
                        break;
                    case R.id.Academica:
                        miFragment=new P_AcademicoFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();
                        break;
                    case R.id.Eventos:
                        miFragment=new EventosFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();
                        break;
                    case R.id.Contactenos:
                        miFragment=new ContactarFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();
                        break;
                    case R.id.convenios:
                        miFragment=new FragmentConvenio();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();
                        break;
                }

                return true;
            }
        });
    }

    private void validarSession() {

        SharedPreferences preferencias=getSharedPreferences("egresado",MODE_PRIVATE);

        String user=preferencias.getString("usuario","vacio");
        String pass=preferencias.getString("pass","vacio");

        if(!user.equals("vacio")&&!pass.equals("vacio")){

            menu.inflateMenu(R.menu.menu_egresado);
        }else{

            menu.inflateMenu(R.menu.menu_invitado);
        }
    }



    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.cerrar_sesion){
            cerrarSession();

        }else if (item.getItemId()==R.id.informacion){
            Intent i=new Intent(getApplicationContext(),Ubicacion.class);
            startActivity(i);

        }else if (item.getItemId()==R.id.acercaDe){
            miFragment=new Desarrolladores();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();        }

        return super.onOptionsItemSelected(item);
    }

    private void cerrarSession() {

        SharedPreferences preferencias=getSharedPreferences("egresado",MODE_PRIVATE);
        preferencias.edit().clear().commit();

        Intent i=new Intent(getApplicationContext(),Login.class);
        startActivity(i);
    }


    public boolean onCreateOptionsMenu(Menu menu) {


            getMenuInflater().inflate(R.menu.menu_superior,menu);
            return true;


    }

    public void onClick(View view) {

        switch (view.getId()){

            case R.id.btnRegistrarAlEvento:
                Intent  i=new Intent(this,RegistroYActualizacionDeDatos.class);
                startActivity(i);
                break;

          /*  case R.id.btnEnviarCorreo:

                StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties properties=new Properties();
                properties.put("mail.smtp.host","smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port","465");
                properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.port","465");


                try{

                    session= Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo,contra);
                        }
                    });

                    if(session!=null){



                        Message message=new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setSubject(txtAsunto.getText().toString());
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("jagomez6605@misena.edu.co"));
                        message.setContent(txtMensaje.getText().toString(),"text/html; charset=utf-8");
                        Transport.send(message);

                        Toast.makeText(getApplicationContext(),"Correo enviado con exito ",Toast.LENGTH_LONG).show();
                        limpiar();

                    }

                }catch (Exception e){

                    Toast.makeText(getApplicationContext(),"Error en el envio ",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                    limpiar();
                }






                break;

            case R.id.btnCancelarCorreo:

                Intent h=new Intent(getApplicationContext(), Principal.class);
                startActivity(h);

                break;*/
        }

    }


    private void limpiar() {

        txtAsunto.setText("");
        txtMensaje.setText("");
    }

    @Override
    public void enviarEstudio(Estudio_Vo estudio_vo) {

        DetalleAcademico detalleAcademico=new DetalleAcademico();
        Bundle bundle=new Bundle();
        bundle.putSerializable("objeto",estudio_vo);
        detalleAcademico.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,detalleAcademico).addToBackStack(null).commit();
    }

    @Override
    public void enviarConvenio(Convenio_vo convenio_vo) {
        DetalleConvenio detalleConvenio=new DetalleConvenio();
        Bundle miBundle=new Bundle();
        miBundle.putSerializable("objeto",convenio_vo);
        detalleConvenio.setArguments(miBundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,detalleConvenio).addToBackStack(null).commit();
    }
}
