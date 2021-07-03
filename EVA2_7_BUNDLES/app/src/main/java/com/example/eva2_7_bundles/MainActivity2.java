package com.example.eva2_7_bundles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = new Bundle();
        MiClase miclase = (MiClase)bundle.getSerializable("prueba");
        intent = getIntent();
        Toast.makeText(this, ""+bundle.getString("mensaje") +
                bundle.getInt("edad") + bundle.getBoolean("empleado") +
                miclase.getParam1()+ miclase.getParam2(),Toast.LENGTH_SHORT).show();


    }


}