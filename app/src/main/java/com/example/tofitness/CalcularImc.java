package com.example.tofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularImc extends AppCompatActivity {

    private EditText editPeso;
    private EditText editAltura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcular_imc);

        editPeso = (EditText) findViewById(R.id.editPeso);
        editAltura = (EditText) findViewById(R.id.editAltura);

    }

    public void AbrirResultado(View v){

        String p = String.valueOf(editPeso.getText().toString());
        String a = String.valueOf(editAltura.getText().toString());

        if(p.isEmpty() || a.isEmpty()){
            alert("Preencha todos os campos");
            editPeso.setText("");
            editAltura.setText("");
        } else{
            float peso = Float.parseFloat(editPeso.getText().toString());
            float altura = Float.parseFloat(editAltura.getText().toString());

            Intent i = new Intent(this, ResultadoImc.class);
            Bundle parametros = new Bundle();
            parametros.putFloat("chave-ladoA",peso);
            parametros.putFloat("chave-ladoB",altura);
            i.putExtras(parametros);
            startActivity(i);

        }

    }

    public void Limpar(View v){
        TextView editPeso = (TextView) findViewById(R.id.editPeso);
        TextView editAltura = (TextView) findViewById(R.id.editAltura);
        editPeso.setText("");
        editAltura.setText("");
    }

    public void Voltar(View v) {
        Intent i = new Intent(CalcularImc.this, MainActivity.class);
        startActivity(i);
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


}