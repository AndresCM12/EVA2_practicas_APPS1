package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView txtVwNombre, txtVwApellido, txtVwEdad, txtVwEstado;
    Button btnClose;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        intent = getIntent();
        txtVwApellido = findViewById(R.id.txtVwApellido);
        txtVwEdad = findViewById(R.id.txtVwEdad);
        txtVwEstado = findViewById(R.id.txtVwEstado);
        txtVwNombre = findViewById(R.id.txtVwNombre);
        btnClose = findViewById(R.id.btnClose);
    }

    @Override
    protected void onStart() {
        super.onStart();
        txtVwNombre.setText(intent.getStringExtra("nombre"));
        txtVwApellido.setText(intent.getStringExtra("apellido"));
        txtVwEdad.setText(intent.getStringExtra("edad"));
        txtVwEstado.setText(intent.getIntExtra("estado",0));
    }

    public void onClickclose(View v){
    finish();
    }
}