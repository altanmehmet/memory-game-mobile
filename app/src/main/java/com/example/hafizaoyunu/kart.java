package com.example.hafizaoyunu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class kart extends androidx.appcompat.widget.AppCompatButton {
    boolean acikMi = false;
    boolean cevrilebilir = true;
    int onPlanID;
    int arkaPlanID;
    Drawable arka;
    Drawable on;

    public kart(Context context, int id) {
        super(context);
        onPlanID = 0;
        arkaPlanID = R.drawable.rsz_lor_summonerpct27s_rift_card_back;
        setId(id);
        if (id % 8 == 1)
            onPlanID = R.drawable.dari;
        if (id % 8 == 2)
            onPlanID = R.drawable.nami;
        if (id % 8 == 3)
            onPlanID = R.drawable.nautv2;
        if (id % 8 == 4)
            onPlanID = R.drawable.rivenv2;
        if (id % 8 == 5)
            onPlanID = R.drawable.teemo;
        if (id % 8 == 6)
            onPlanID = R.drawable.voli;
        if (id % 8 == 7)
            onPlanID = R.drawable.zed;
        if (id % 8 == 0)
            onPlanID = R.drawable.poppyv2;
        arka = getResources().getDrawable(arkaPlanID);
        on = getResources().getDrawable(onPlanID);
        setBackground(arka);
    }

    public void ac() {
        if (cevrilebilir) {
            setBackground(on);
            acikMi = true;
        }
    }
        public void kapa() {
            if (cevrilebilir) {
                setBackground(arka);
                acikMi = false;
            }
        }
    }


