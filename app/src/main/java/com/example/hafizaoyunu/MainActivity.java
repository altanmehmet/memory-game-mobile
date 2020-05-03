package com.example.hafizaoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer ply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et = findViewById(R.id.editText5);
        final Button song = findViewById(R.id.muzik);
        song.setOnClickListener(this);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,oyunEkrani.class);
                i.putExtra("mesaj",et.getText().toString());
                startActivity(i);
            }
        });
    }
        @Override
        public void onClick(View v) {
            ply = MediaPlayer.create(MainActivity.this,R.raw.song);
            ply.start();

        }
    }

