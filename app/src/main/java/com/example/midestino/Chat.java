package com.example.midestino;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Chat extends AppCompatActivity {
    EditText etMsj, etCel;
    Button btnEnviar, btnw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        etMsj= findViewById(R.id.editTextTextPersonName);
        etCel= findViewById(R.id.editTextTextPersonName2);
        btnEnviar= findViewById(R.id.buttonsms);
        btnw= findViewById(R.id.buttonW);

        if(ActivityCompat.checkSelfPermission(Chat.this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Chat.this,new String[]{Manifest.permission.SEND_SMS},1);
        }
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(etCel.getText().toString(),null,etMsj.getText().toString(),null,null);

                Toast.makeText(Chat.this,"MSJ Enviado", Toast.LENGTH_LONG).show();
            }
        });
        btnw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(etCel.getText().toString().isEmpty()) {

                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, etMsj.getText().toString());
                    sendIntent.setType("text/plain");
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                }else{
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_VIEW);
                    String uri="whatsapp://send?phone"+etCel.getText().toString()+"&text"+etMsj.getText().toString();
                    sendIntent.setData(Uri.parse(uri));
                    startActivity(sendIntent);
                }
            }
        });
    }

    public void vl(View view) {
        Intent intent= new Intent(Chat.this,MainActivity.class);
        startActivity(intent);
    }
}
