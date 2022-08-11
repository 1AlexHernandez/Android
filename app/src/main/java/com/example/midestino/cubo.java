package com.example.midestino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class cubo extends AppCompatActivity {

    ViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cubo);


        int imgarray[]={R.drawable.elcubo1,R.drawable.elcubo2,R.drawable.elcubo3};
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

    public void contac(View view) {
        Intent intent= new Intent(cubo.this, Chat.class);
        startActivity(intent);
    }

    public void onClickLlamada(View view) {
        Intent i = new Intent(android.content.Intent.ACTION_DIAL,
                Uri.parse("tel:+573017811918")); //
        startActivity(i);
    }


    public void onClickMapa(View v) {
        float latitude = 2.4584347912331435f;
        float longitude = -76.59827143215874f;
        String url = String.format("geo:%f, %f", latitude, longitude);
        Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse(url));
        startActivity(i);
    }
}

