package com.example.hafizaoyunu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class oyunEkrani extends AppCompatActivity  {
    int sonKart = 0;
    int skor = 0;
    int hataSayisi;
    String isim;
    MediaPlayer ply;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_ekrani);
        GridLayout gr = findViewById(R.id.grid);
        pb = findViewById(R.id.pb);
        Intent i = getIntent();
        final String isim = i.getStringExtra("mesaj");
        final kart kartlar[] = new kart[16];
        for(int j = 1 ; j <= 16 ;j++) {
            kartlar[j-1] = new kart(this,j);
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final kart k = (kart) v;
                    k.ac();
                    if (sonKart > 0) {
                        if (sonKart != k.getId()) {
                            final kart m = (kart) findViewById(sonKart);
                            if (m.onPlanID == k.onPlanID && m.getId() != k.getId()) {
                                m.cevrilebilir = false;
                                k.cevrilebilir = false;
                                skor++;
                                sonKart = 0;
                                TextView tv = findViewById(R.id.skor);
                                tv.setText("Skor : " + skor);
                                if (skor == 8) {
                                    Intent i = new Intent(oyunEkrani.this, oyunSon.class);
                                    i.putExtra("skor", skor);
                                    i.putExtra("hata", hataSayisi);
                                    i.putExtra("isim", isim);
                                    startActivity(i);

                                }
                            } else {
                                Handler h = new Handler();
                                h.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        m.kapa();
                                        k.kapa();
                                    }
                                }, 500);
                                hataSayisi++;
                                TextView tv = findViewById(R.id.hata);
                                tv.setText("Hata sayısı : " + hataSayisi);
                                sonKart = 0;
                            }
                        }
                        } else {
                            sonKart = k.getId();
                        }
                    }


            });
        }
        for(int j = 0 ; j < 16 ;j++) {
        int rg = (int)(Math.random()*16);
        kart k = kartlar[rg];
        kartlar [rg] = kartlar[j];
        kartlar[j] = k;
        }
        for(int j = 0 ; j < 16 ;j++)
        gr.addView(kartlar[j]);
        ObjectAnimator animation = ObjectAnimator.ofInt(pb,"progress",100,0);
        animation.setDuration(60000);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) { }

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onAnimationEnd(Animator animator) {
                    Intent i = new Intent(oyunEkrani.this, basarisizOyun.class);
                    i.putExtra("skor", skor);
                    i.putExtra("hata", hataSayisi);
                    i.putExtra("isim", isim);
                    startActivity(i);
                }


            @Override
            public void onAnimationCancel(Animator animator) { }

            @Override
            public void onAnimationRepeat(Animator animator) { }
        });
        animation.start();
    }

}

