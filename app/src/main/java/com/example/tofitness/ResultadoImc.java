package com.example.tofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class ResultadoImc extends AppCompatActivity {

    float resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_imc);

        Intent i = getIntent();
        Bundle parametros = i.getExtras();

        if(parametros != null){

            float peso = parametros.getFloat("chave-ladoA");
            float altura = parametros.getFloat("chave-ladoB");

            resultado = peso/(altura * 2);
            resultado = Float.valueOf(String.format(Locale.US, "%.2f", Math.floor(resultado)));

            if(resultado < 15){
                TextView textResult = (TextView) findViewById(R.id.textResult);
                textResult.setText(resultado + " - extremamente abaixo do peso!");

            } else if(resultado >= 15 && resultado < 16){
                TextView textResult = (TextView) findViewById(R.id.textResult);
                textResult.setText(resultado + " - gravimente abaixo do peso!");

            } else if(resultado >= 16 && resultado < 18.5){
                TextView textResult = (TextView) findViewById(R.id.textResult);
                textResult.setText(resultado + " - abaixo do peso ideal!");

            } else if(resultado >= 18.5 && resultado < 25){
                TextView textResult = (TextView) findViewById(R.id.textResult);
                textResult.setText(resultado + " - faixa de peso ideal!");

            } else if(resultado >= 25 && resultado < 30){
                TextView textResult = (TextView) findViewById(R.id.textResult);
                textResult.setText(resultado + " - sobrepeso!");

            } else if(resultado >= 30 && resultado < 35){
                TextView textResult = (TextView) findViewById(R.id.textResult);
                textResult.setText(resultado + " - obesidade grau 1!");

            } else if(resultado >= 35 && resultado < 40){
                TextView textResult = (TextView) findViewById(R.id.textResult);
                textResult.setText(resultado + " - obesidade grau 2 (Grave)!");

            } else {
                TextView textResult = (TextView) findViewById(R.id.textResult);
                textResult.setText(resultado + " - obesidade grau 3 (mórbida)!");

            }

            Toast.makeText(this, "Resultado", Toast.LENGTH_SHORT).show();

        }

    }

    public void Voltar(View v){
        Intent i = new Intent(this, CalcularImc.class);
        startActivity(i);
    }

}