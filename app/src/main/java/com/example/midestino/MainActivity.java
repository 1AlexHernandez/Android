package com.example.midestino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}

    public void te(View view) {
        Intent intent= new Intent(MainActivity.this, perfil.class);
        startActivity(intent);
    }

    public void vr(View view) {
        Intent intent= new Intent(MainActivity.this, bombonera.class);
        startActivity(intent);
    }

    public void yi(View view) {
        Intent intent= new Intent(MainActivity.this, cubo.class);
        startActivity(intent);
    }

    public void kopana(View view) {
        Intent intent= new Intent(MainActivity.this, kopana.class);
        startActivity(intent);
    }

    public void ote(View view) {
        Intent intent= new Intent(MainActivity.this, otero.class);
        startActivity(intent);
    }

    public void tem(View view) {
        Intent intent= new Intent(MainActivity.this, templo.class);
        startActivity(intent);
    }



    public void buscar(View view) {
        Intent intent= new Intent(MainActivity.this, Buscador.class);
        startActivity(intent);
    }
}


