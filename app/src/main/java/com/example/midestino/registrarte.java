package com.example.midestino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



    public class registrarte extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.registrarte);}


        public void resi(View view) {
            Intent intent = new Intent(registrarte.this, MainActivity.class);
            startActivity(intent);
        }

        public void perf(View view) {
            Intent intent = new Intent(registrarte.this, MainActivity.class);
            startActivity(intent);
        }

        public void vol(View view) {
            Intent intent = new Intent(registrarte.this, inicio_sesion.class);
            startActivity(intent);
        }
    }
