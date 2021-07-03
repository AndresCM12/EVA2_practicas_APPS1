package com.example.eva2_5_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText edTxtName, edTxtApe, edTxtEdad;
    Button btnSend;
    Intent intent;
    RadioGroup rgEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this, MainActivity2.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        edTxtName = findViewById(R.id.edTxtNombre);
        edTxtApe = findViewById(R.id.editTextTextPersonName2);
        edTxtEdad = findViewById(R.id.edTxtEdad);
        btnSend = findViewById(R.id.btnSend);
        rgEstado = findViewById(R.id.rgEstado);
    }

    public void onClick(View v){
    intent.putExtra("nombre",edTxtName.getText().toString());
    intent.putExtra("apellido",edTxtApe.getText().toString());
    intent.putExtra("edad",edTxtEdad.getText().toString());
    intent.putExtra("estado",rgEstado.getCheckedRadioButtonId());
    startActivity(intent);
    }
}