package com.example.foxconntech.egresoft.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.foxconntech.egresoft.R;

public class Activity_Login extends AppCompatActivity {

    public static boolean invitado=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__login);
    }

    public void onClick(View view) {

        Intent miIntent;

        switch (view.getId()){
            case R.id.btnEgresado:
              miIntent =new Intent(Activity_Login.this,Principal.class);
                startActivity(miIntent);
                break;
            case R.id.btnInvitado:
                invitado=true;
                miIntent=new Intent(Activity_Login.this,Principal.class);
                startActivity(miIntent);
                break;
        }
    }
}
