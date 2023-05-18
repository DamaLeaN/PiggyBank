package com.example.piggybank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoFinal extends AppCompatActivity {

    TextView txtresultado, txtjurosRecebidos, txtaportes;

    private Button btnVoltar;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_final);

        txtresultado = findViewById(R.id.txtresultado);
        txtaportes = findViewById(R.id.txtaportes);
        txtjurosRecebidos = findViewById(R.id.txtjurosRecebidos);
        btnVoltar = findViewById(R.id.btnVoltar);
        Intent it = getIntent();

        txtjurosRecebidos.setText(it.getStringExtra("jurosRecebidos"));
        txtaportes.setText(it.getStringExtra("aportes"));
        txtresultado.setText(it.getStringExtra("resultado"));
    }

    public void voltarTelaPrincipal(View view){
        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);

    }
}