package com.example.tofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Treino_Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treino_form);

        Button cadastrar = findViewById(R.id.btnAdicionarTreino);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BancoController crud = new BancoController(getBaseContext());
                EditText categoria = findViewById(R.id.editCategoria);
                EditText tipo = findViewById(R.id.editTipo);
                EditText repeticao = findViewById(R.id.editRepeticao);
                String categoriaString = categoria.getText().toString();
                String tipoString = tipo.getText().toString();
                String repeticaoString = repeticao.getText().toString();
                String resultado;

                resultado = crud.criarTreino(categoriaString, tipoString, repeticaoString);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();

                Intent i = new Intent(Treino_Form.this, MeuTreino.class);
                startActivity(i);
            }
        });

    }

    public void Voltar(View view) {
        Intent i = new Intent(Treino_Form.this, MeuTreino.class);
        startActivity(i);
    }
}