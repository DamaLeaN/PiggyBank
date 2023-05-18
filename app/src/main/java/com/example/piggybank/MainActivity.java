package com.example.piggybank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtValorInicial, edtMes, edtTaxa, edtMensal;

    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btnCalcular);
        edtMensal = findViewById(R.id.edtMensal);
        edtTaxa = findViewById(R.id.edtTaxa);
        edtMes = findViewById(R.id.edtMes);
        edtValorInicial = findViewById(R.id.edtValorInicial);



    }
    @SuppressLint("DefaultLocale")
    public void calcular (View view){
        Intent it = new Intent(this, ResultadoFinal.class);

        double valor = Double.parseDouble(edtValorInicial.getText().toString());
        double aplicacaoMensal = Double.parseDouble(edtMensal.getText().toString());
        int tempo = Integer.parseInt(edtMes.getText().toString());
        double taxa = Double.parseDouble(edtTaxa.getText().toString());

        Calculo calculo = new Calculo(valor, aplicacaoMensal, tempo, taxa);

        double valorFinalAplicado =  calculo.calcularInvestimento();

        double aportes = valor + (aplicacaoMensal * tempo);

        double jurosRecebidos = valorFinalAplicado - aportes;

        it.putExtra("jurosRecebidos",String.format("R$ %.2f",jurosRecebidos));
        it.putExtra("aportes", String.format("R$ %.2f",aportes));
        it.putExtra("resultado", String.format("R$ %.2f",valorFinalAplicado));

        startActivity(it);

    }


}