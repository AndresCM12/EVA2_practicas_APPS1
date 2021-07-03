package com.example.eva2_6_on_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int key_sec = 01;
    final int key_contactos = 02;
    final int key_photos = 03;

    Button btnMain;
    Intent intent, intentContactos, intentPhotos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMain = findViewById(R.id.btnMain);
        intent = new Intent(this, Secundaria.class);
        intentContactos = new Intent(Intent.ACTION_PICK,
                android.provider.ContactsContract.Contacts.CONTENT_URI);

        intentPhotos = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    }

    public void onClick(View v){
        intent.putExtra("Datos", "Informacion envidada desde principal");
        startActivityForResult(intent, key_sec);

    }

    public void onClickContactos(View view){
        startActivityForResult(intentContactos, key_contactos);
    }

    public  void onClickPhotos(View view){
        startActivityForResult(intentPhotos, key_photos);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //aqui procesamos la respuesta de la actividad
        //identificar la actividad que devolvio el resultado
        if(requestCode == key_sec){
            //identificar si se devolvio un valor o no
            if(resultCode == Activity.RESULT_OK){
                //leer los datos
                Toast.makeText(this, ""+data.getStringExtra("valor"), Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Se canceló el envío", Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode == key_contactos){
            if(resultCode == Activity.RESULT_OK){
                String returnedData = data.getDataString();
                Toast.makeText(this, returnedData, Toast.LENGTH_LONG).show();

            }else{

            }
        } else if(requestCode == key_photos){
            if (resultCode == Activity.RESULT_OK){
                String returnedData = data.getDataString();
                Toast.makeText(this, returnedData, Toast.LENGTH_LONG).show();            }
        }


    }
}