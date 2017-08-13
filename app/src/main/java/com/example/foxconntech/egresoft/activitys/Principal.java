package com.example.foxconntech.egresoft.activitys;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.foxconntech.egresoft.R;
import com.example.foxconntech.egresoft.fragments.FragmentContenedor;
import com.example.foxconntech.egresoft.fragments.FragmentLogin;

    public class Principal extends AppCompatActivity implements FragmentContenedor.OnFragmentInteractionListener,
    FragmentLogin.OnFragmentInteractionListener{

    Fragment miFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);




    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
