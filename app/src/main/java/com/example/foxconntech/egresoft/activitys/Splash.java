package com.example.foxconntech.egresoft.activitys;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.foxconntech.egresoft.R;

public class Splash extends AppCompatActivity {

    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView=(ImageView)findViewById(R.id.imagenSplash);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.rotacion);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);


      new Handler().postDelayed(new Runnable() {
          @Override
          public void run() {
              Splash.this.startActivity(new Intent(Splash.this,Slider.class));
              Splash.this.finish();
          }
      },3000);

    }
}
