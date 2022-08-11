package com.example.midestino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class perfil extends AppCompatActivity {
    ImageView btnir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        btnir = findViewById(R.id.imageView5);
    }

    public void ku(View view) {
        Intent intent= new Intent(perfil.this, actualizar.class);
        startActivity(intent);
    }

    public void perf(View view) {
        Intent intent = new Intent(perfil.this, MainActivity.class);
        startActivity(intent);
    }

    public void ir(View view) {
        Intent intent = new Intent(perfil.this,actualizar.class);
        startActivity(intent);
    }
}