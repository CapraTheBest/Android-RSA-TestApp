package com.example.quarta.testapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class EasterEgg extends ActionBarActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easter_egg);
        imageView = (ImageView) findViewById(R.id.animatedImage);
        final Animation animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        Button btnRotate = (Button) findViewById(R.id.rotate);

        btnRotate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                imageView.startAnimation(animRotate);
            }
        });
    }
}
