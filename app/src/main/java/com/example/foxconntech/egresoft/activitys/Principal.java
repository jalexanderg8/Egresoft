package com.example.foxconntech.egresoft.activitys;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.example.foxconntech.egresoft.Fragments.EventosFragment;
import com.example.foxconntech.egresoft.Fragments.FragmentLogin;
import com.example.foxconntech.egresoft.Fragments.P_AcademicoFragment;
import com.example.foxconntech.egresoft.Fragments.PortalLaboralFragment;
import com.example.foxconntech.egresoft.R;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

public class Principal extends AppCompatActivity implements EventosFragment.OnFragmentInteractionListener,P_AcademicoFragment.OnFragmentInteractionListener
,PortalLaboralFragment.OnFragmentInteractionListener,FragmentLogin.OnFragmentInteractionListener{

    BottomNavigationView menu;
    Fragment miFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        menu= (BottomNavigationView) findViewById(R.id.menu_inferior);

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
                }

                return true;
            }
        });
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view) {
        final FloatingActionsMenu fabPrincipal=(FloatingActionsMenu) findViewById(R.id.fabMenu);


        if (R.id.Cerrar_sesion==view.getId()){
            miFragment=new FragmentLogin();
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,miFragment).commit();
            fabPrincipal.collapse();
        }
    }
}
