package com.example.eva2_4_action_sendto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edTxtNumero, edTxtMensaje;
    Button btnEnviar;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTxtNumero = findViewById(R.id.edTxtNumero);
        edTxtMensaje = findViewById(R.id.edTxtMensaje);
        btnEnviar = findViewById(R.id.btnEnviar);
        intent = new Intent(Intent.ACTION_SENDTO,
                Uri.parse("smsto:"+edTxtNumero.getText().toString()));
        intent.putExtra("sms_body",
                edTxtMensaje.getText().toString());

    }

    public void onClick(View v){
        startActivity(intent);
    }
}