package com.example.midestino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class otero extends AppCompatActivity {

    ViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otero);

        int imgarray[]={R.drawable.otero1,R.drawable.otero2,R.drawable.otero3};
        flipper=(ViewFlipper)findViewById(R.id.flipper);

        for (int i=0;i<imgarray.length;i++)
            showimage(imgarray[i]);
    }

    public void showimage(int img){
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(img);

        flipper.addView(imageView);
        flipper.setFlipInterval(3000);
        flipper.setAutoStart(true);
        flipper.setInAnimation(this,android.R.anim.slide_in_left);
        flipper.setInAnimation(this, android.R.anim.slide_out_right);
    }

    public void con(View view) {
        Intent intent= new Intent(otero.this,Chat.class);
        startActivity(intent);
    }

    public void onClickLlamada(View view) {
        Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                Uri.parse("tel:+573017811918")); //
        startActivity(i);
    }

    public void onClickMapa(View v) {
        float latitude = (float) 2.4525125164301333;
        float longitude = (float) -76.59392807448795;
        String url = String.format("geo:%f, %f", latitude, longitude);
        Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(url));
        startActivity(i);
    }
}