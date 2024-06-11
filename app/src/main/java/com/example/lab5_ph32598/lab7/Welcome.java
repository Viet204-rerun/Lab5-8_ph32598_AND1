package com.example.lab5_ph32598.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab5_ph32598.R;
import com.example.lab5_ph32598.dangnhap.dangnhap;
import com.example.lab5_ph32598.lab5.bai2;

public class Welcome extends AppCompatActivity {
    ImageView img;
    TextView tv1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        img = findViewById(R.id.fpoly);
        tv1 = findViewById(R.id.welcome);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
        R.anim.animation);
        img.startAnimation(animation);
        tv1.startAnimation(animation);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Welcome.this, dangnhap.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}