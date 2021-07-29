package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class welcome extends AppCompatActivity {
    ProgressBar p; int i=0;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        t=findViewById(R.id.textView2);
        t.animate().scaleX(1.5F).scaleY(1.5F).rotation(360).setDuration(1500);


        p=findViewById(R.id.progressBarWelcome);
        Handler h=new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (i=0;i<100;i++)
                {
                    h.post(new Runnable() {
                        @Override
                        public void run() {
                            p.setProgress(i);
                        }
                    });
                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                //OR  startActivity(new Intent(welcome.this,MainActivity.class));
            }
        }).start();
    }
}
