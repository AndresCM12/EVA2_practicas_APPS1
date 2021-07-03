package com.example.eva2_8_permisos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLlamar;
    EditText txtNumero;
    final int key_call = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLlamar = findViewById(R.id.btnMarcar);
        txtNumero = findViewById(R.id.TxtNumero);

        //aqui verifico si no tengo el permiso
        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                //solicitar permiso
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    key_call);
        }else{
            //aqui ejecuto alguna accion si la app tiene el permiso
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case key_call:
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                    Toast.makeText(this, "Permiso concedido", Toast.LENGTH_SHORT).show();
                    btnLlamar.setEnabled(true);
                }else{
                    Toast.makeText(this, "No tienes permisos", Toast.LENGTH_SHORT).show();
                    btnLlamar.setEnabled(false);
                }
            break;
        }
    }

    public void onClick(View view){
        String stel = "tel"+txtNumero.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(stel));
        startActivity(intent);
    }
}