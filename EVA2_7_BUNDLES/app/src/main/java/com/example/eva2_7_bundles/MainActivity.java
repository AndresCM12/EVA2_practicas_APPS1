package com.example.eva2_7_bundles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MainActivity2.class);

    }

    public void onClickIniciar(View v){
        MiClase miclase = new MiClase();
        miclase.setParam1(100);
        miclase.setParam2(200);
        //bundles
        Bundle bundle = new Bundle();
        bundle.putString("mensaje","Hola");
        bundle.putInt("edad", 20);
        bundle.putBoolean("empleado", true);
        bundle.putSerializable("prueba",miclase);
        intent.putExtras(bundle);
        startActivity(intent);
    }



}

class MiClase implements Serializable {
    private int param1;
    private int param2;

    public int getParam1() {
        return param1;
    }

    public void setParam1(int param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }
}