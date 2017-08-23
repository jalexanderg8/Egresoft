package com.example.foxconntech.egresoft.activitys;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.foxconntech.egresoft.Fragments.EventosFragment;
import com.example.foxconntech.egresoft.Fragments.P_AcademicoFragment;
import com.example.foxconntech.egresoft.Fragments.PortalLaboralFragment;
import com.example.foxconntech.egresoft.R;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class Principal extends AppCompatActivity implements EventosFragment.OnFragmentInteractionListener,P_AcademicoFragment.OnFragmentInteractionListener
,PortalLaboralFragment.OnFragmentInteractionListener{

    BottomNavigationView menuInferior;
    Fragment miFragment;
    View pLaboral;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        menuInferior= (BottomNavigationView) findViewById(R.id.menu_inferior);
        pLaboral=(View) findViewById(R.id.laboral);

        if (Activity_Login.invitado){
            menuInferior.inflateMenu(R.menu.menu_invitado);

            menuInferior.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                    switch (item.getItemId()) {

                        case R.id.Academica:
                            miFragment=new P_AcademicoFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();
                            break;
                        case R.id.Eventos:
                            miFragment=new EventosFragment();
                            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();
                            break;
                        case R.id.salida:
                            finish();
                            break;
                    }

                    return true;
                }
            });

        }else{
            menuInferior.inflateMenu(R.menu.menu_egresado);

            menuInferior.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {

                        case R.id.laboral:
                            miFragment=new PortalLaboralFragment();
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
                    }

                    return true;
                }
            });


        }



    }

 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (Activity_Login.invitado){
            invalidateOptionsMenu();
            menuInferior.inflateMenu(R.menu.menu_invitado);
        }

        return super.onCreateOptionsMenu(menu);
    }*/

    @Override

    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view) {
        final FloatingActionsMenu fabPrincipal=(FloatingActionsMenu) findViewById(R.id.fabMenu);


        if (R.id.Cerrar_sesion==view.getId()){
            Intent miIntento=new Intent(Principal.this,Activity_Login.class);
            startActivity(miIntento);
            fabPrincipal.collapse();
        }
    }
}
