package com.example.lab5_ph32598.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lab5_ph32598.R;

public class bai7_2 extends AppCompatActivity {
    ImageView imgquat;
    Button btnstart , btnstop;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai72);
        imgquat = findViewById(R.id.imgquat);
        btnstart = findViewById(R.id.start);
        btnstop = findViewById(R.id.stop);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        imgquat.animate()
                                .rotationBy(360)
                                .withEndAction(this)
                                .setDuration(250)
                                .setInterpolator(new LinearInterpolator())
                                .start();
                    }
                };
                imgquat.animate()
                        .rotationBy(360)
                        .withEndAction(runnable)
                        .setDuration(250)
                        .setInterpolator(new LinearInterpolator())
                        .start();
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgquat.animate().cancel();
            }
        });
    }
}