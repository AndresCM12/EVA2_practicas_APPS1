package com.example.eva2_1_intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String telefono = "tel:6142759400";
    int CODIGO_PERMISO = 0;
    Intent inTel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onClickDial(View v){
        //aqui marcamos pero no llamamos
        inTel = new Intent(Intent.ACTION_DIAL, Uri.parse(telefono));
        startActivity(inTel);
    }

    public void onClickCall(View v){
        //aqui llamamos directamente

        int estadoDePermiso = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE);
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.CALL_PHONE},
                CODIGO_PERMISO);

        if (estadoDePermiso == PackageManager.PERMISSION_GRANTED) {
            inTel = new Intent(Intent.ACTION_CALL, Uri.parse(telefono));
            startActivity(inTel);
        } else {
            Toast.makeText(this, "Danos permiso", Toast.LENGTH_SHORT).show();        }



    }

    public void onClickCont(View v){
        String sData = "content://contacts/people/";
        inTel = new Intent(Intent.ACTION_VIEW, Uri.parse(sData));
        startActivity(inTel);
    }

    public void onClickNav(View v){
        String sData = "http://www.youtube.com";
        inTel = new Intent(Intent.ACTION_VIEW, Uri.parse(sData));
        startActivity(inTel);
    }
}