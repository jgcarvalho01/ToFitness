package com.example.tofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Relatorio_Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio_form);

        Button cadastrar = findViewById(R.id.btnAdicionarRelatorio);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BancoController crud = new BancoController(getBaseContext());
                EditText altura = findViewById(R.id.editAltura);
                EditText peso = findViewById(R.id.editPeso);
                EditText imc = findViewById(R.id.editIMC);
                EditText data = findViewById(R.id.editData);
                String alturaString = altura.getText().toString();
                String pesoString = peso.getText().toString();
                String imcString = imc.getText().toString();
                String dataString = data.getText().toString();
                String resultado;

                resultado = crud.criarRelatorio(alturaString, pesoString, imcString, dataString);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                Intent i = new Intent(Relatorio_Form.this, Relatorio.class);
                startActivity(i);
            }
        });

    }

    public void Voltar(View view) {
        Intent i = new Intent(this, MeuTreino.class);
        startActivity(i);
    }
}