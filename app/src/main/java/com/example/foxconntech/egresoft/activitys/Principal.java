package com.example.foxconntech.egresoft.activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.fragments.ContactarFragment;
import com.example.foxconntech.egresoft.fragments.Desarrolladores;
import com.example.foxconntech.egresoft.fragments.DetalleAcademico;
import com.example.foxconntech.egresoft.fragments.DetalleConvenio;
import com.example.foxconntech.egresoft.fragments.EventosFragment;
import com.example.foxconntech.egresoft.fragments.FragmentConvenio;
import com.example.foxconntech.egresoft.fragments.P_AcademicoFragment;
import com.example.foxconntech.egresoft.fragments.PortalLaboralFragment;
import com.example.foxconntech.egresoft.interfaces.IComunicaFragments;
import com.example.foxconntech.egresoft.vo.Convenio_vo;
import com.example.foxconntech.egresoft.vo.Estudio_Vo;

public class Principal extends AppCompatActivity implements EventosFragment.OnFragmentInteractionListener,
        P_AcademicoFragment.OnFragmentInteractionListener,Desarrolladores.OnFragmentInteractionListener
,PortalLaboralFragment.OnFragmentInteractionListener,FragmentConvenio.OnFragmentInteractionListener
        ,ContactarFragment.OnFragmentInteractionListener,DetalleAcademico.OnFragmentInteractionListener
,DetalleConvenio.OnFragmentInteractionListener,IComunicaFragments{

    public static boolean info=false;
    BottomNavigationView menu;
    Fragment miFragment;
    Toolbar barra_superior;
    Intent miIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        barra_superior= (Toolbar) findViewById(R.id.barra_superior);
        setSupportActionBar(barra_superior);

        menu= (BottomNavigationView) findViewById(R.id.menu_inferior);


      if (Login.tipo.equals("egresado")){
      menu.inflateMenu(R.menu.menu_egresado);
     }else if (Login.tipo.equals("invitado")){
    menu.inflateMenu(R.menu.menu_invitado);
     }

        menu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.laboral:
                        miFragment=new PortalLaboralFragment();
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
                    case R.id.salida:
                        finish();
                        break;
                    case R.id.convenios:
                        miFragment=new FragmentConvenio();
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();
                        break;
                    case R.id.informacionI:

                        llamarSplash();

                        break;
                }

                return true;
            }
        });
    }

    private void llamarSplash() {
        info=true;
        miIntent=new Intent(getApplicationContext(),Splash.class);
        startActivity(miIntent);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.cerrar_sesion){
           finish();
        }else if (item.getItemId()==R.id.informacion){
            llamarSplash();
        }else if (item.getItemId()==R.id.acercaDe){
            miFragment=new Desarrolladores();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (Login.tipo.equals("egresado")){
            getMenuInflater().inflate(R.menu.menu_superior,menu);
            return true;

        }else{
            return false;
        }
    }

    public void onClick(View view) {
        if (R.id.btnRegistrarAlEvento==view.getId()){
            Intent  i=new Intent(this,RegistroYActualizacionDeDatos.class);
            startActivity(i);
        }
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
