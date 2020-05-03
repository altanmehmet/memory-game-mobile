package com.example.hafizaoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class oyunSon extends AppCompatActivity implements View.OnClickListener {
Button btn;
TextView tv;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyun_son);
        tv = findViewById(R.id.son);
        btn = findViewById(R.id.backv2);
        btn.setOnClickListener(this);
        Intent i = getIntent();
        int skor = i.getIntExtra("skor",0);
        int hata = i.getIntExtra("hata",0);
        String isim = i.getStringExtra("isim");
        tv.setText("Tebrikler " + isim + "\n Skorunuz : " + skor + "\n Hata sayınız : " + hata);

    }

    @Override
    public void onClick(View v) {
        Intent m = new Intent(oyunSon.this,MainActivity.class);
        startActivity(m);
    }
}
