package com.example.midestino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;

import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Hashtable;
import java.util.Map;

public class login extends AppCompatActivity {

    private Button Iniciarsesion ;

    private EditText txtUser, txtContraseña;

    String URL_SERVIDOR = "http://10.0.2.2/canchas/login.php";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = findViewById(R.id.txtuser);
        txtContraseña = findViewById(R.id.txtcontraseña);
        Iniciarsesion = findViewById(R.id.iniciarsesion);







        Iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });




    }



    public void login() {
        StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.POST, URL_SERVIDOR,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        // En este apartado se programa lo que deseamos hacer en caso de no haber errores

                        if (response.equals("ERROR 1")) {
                            Toast.makeText(login.this, "Se deben de llenar todos los campos.", Toast.LENGTH_SHORT).show();
                        } else if (response.equals("ERROR 2")) {
                            Toast.makeText(login.this, "No existe este usuario.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(login.this, "Inicio de Sesion exitoso.", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(login.this, MainActivity.class);
                            startActivity(intent);

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // En caso de tener algun error en la obtencion de los datos
                Toast.makeText(login.this, "ERROR AL INICIAR SESION", Toast.LENGTH_LONG).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                // En este metodo se hace el envio de valores de la aplicacion al servidor
                Map<String, String> parametros = new Hashtable<String, String>();
                parametros.put("usuario", txtUser.getText().toString().trim());
                parametros.put("contraseña", txtContraseña.getText().toString().trim());

                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(login.this);
        requestQueue.add(stringRequest);
    }

    public void goo(View view) {
        Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://mail.google.com/"));
        startActivity(i);

    }

    public void irface(View view) {
        Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://es-la.facebook.com/"));
        startActivity(i);
    }

    public void twi(View view) {
        Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("https://twitter.com/"));
        startActivity(i);
    }
}

