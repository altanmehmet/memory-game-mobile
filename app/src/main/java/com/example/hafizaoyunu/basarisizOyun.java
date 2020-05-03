package com.example.hafizaoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class basarisizOyun extends AppCompatActivity implements View.OnClickListener {
TextView tv;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basarisiz_oyun);
        tv = findViewById(R.id.basarisiz);
        btn = findViewById(R.id.back);
        btn.setOnClickListener(this);
        Intent i = getIntent();
        int skor = i.getIntExtra("skor",0);
        int hata = i.getIntExtra("hata",0);
        String isim = i.getStringExtra("isim");
        tv.setText("Bölümü verilen sürede bitiremedin " + isim + "\n Skorunuz : " + skor + "\n Hata sayınız : " + hata);
    }

    @Override
    public void onClick(View v) {
        Intent m = new Intent(basarisizOyun.this,MainActivity.class);
        startActivity(m);
    }
}
