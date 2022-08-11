package com.example.midestino;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class actualizar extends AppCompatActivity {
    Button hl;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actualizar);
        hl = (Button) findViewById(R.id.cperf);
        imagen = (ImageView) findViewById(R.id.imageView4);
    }

    public void sae(View view) {
        cargarImagen();
    }

    private void cargarImagen() {
        Intent intent = new Intent((Intent.ACTION_PICK), MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "seleccione la aplicacion"), 10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri pach = data.getData();
            imagen.setImageURI(pach);
        }
    }

    public void hola(View view) {
        cargaImagen();
    }

    private void cargaImagen() {
        Intent intent = new Intent((Intent.ACTION_PICK), MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/");
        startActivityForResult(intent.createChooser(intent, "seleccione la aplicacion"), 10);
    }


    public void lol(View view) {
        Intent intent = new Intent(actualizar.this, perfil.class);
        startActivity(intent);
    }
}
