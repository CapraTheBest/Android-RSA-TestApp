package com.example.quarta.testapp;

import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class EasterEgg extends ActionBarActivity {

    private MediaPlayer mPlayer;
    private ImageView imageView;
    private ImageView animationView;
    private Animation animRotate;
    private AnimationDrawable backgroundAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easter_egg);

        imageView = (ImageView) findViewById(R.id.animatedImage);

        animationView = (ImageView) findViewById(R.id.background);
        animationView.setBackgroundResource(R.anim.background_animation);
        backgroundAnimation = (AnimationDrawable) animationView.getBackground();

        mPlayer = MediaPlayer.create(EasterEgg.this, R.raw.song);
        animRotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        doRotate();
    }

    @Override
    public void onDestroy() {
        mPlayer.stop();
        backgroundAnimation.stop();
        super.onDestroy();

    }

    public void doRotate() {
        mPlayer.start();
        backgroundAnimation.start();
        imageView.startAnimation(animRotate);
    }
}
