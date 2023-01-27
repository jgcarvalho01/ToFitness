package com.example.tofitness;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlterarTreino extends AppCompatActivity {

    private AlertDialog alerta;
    private EditText categoria;
    private EditText tipo;
    private EditText repeticao;
    private Button alterar;
    private Button deletar;
    private Cursor cursor;
    private BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_treino);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        categoria = findViewById(R.id.edtCategoria);
        tipo = findViewById(R.id.edtTipo);
        repeticao = findViewById(R.id.edtRepeticao);

        alterar = findViewById(R.id.btnAlterar);

        cursor = crud.carregarDadosTreinoById(Integer.parseInt(codigo));

        categoria.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.CATEGORIA_TREINO)));
        tipo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TIPO_TREINO)));
        repeticao.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.REPETICAO_TREINO)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.atualizarTreino(
                        Integer.parseInt(codigo),
                        categoria.getText().toString(),
                        tipo.getText().toString(),
                        repeticao.getText().toString()
                );

                Toast.makeText(getApplicationContext(), "Registro alterado com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AlterarTreino.this, MeuTreino.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = findViewById(R.id.btnDeletar);

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlterarTreino.this);
                builder.setTitle("Excluindo registro...");
                builder.setMessage("Deseja realmente excluir o registro?");

                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        crud.deleteTreino(Integer.parseInt(codigo));
                        Toast.makeText(getApplicationContext(), "Registro excluido com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AlterarTreino.this, MeuTreino.class);
                        startActivity(intent);
                        finish();
                    }
                });

                builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlterarTreino.this, "Registro não excluido", Toast.LENGTH_SHORT).show();
                    }
                });

                alerta = builder.create();
                alerta.show();
            }
        });
    }

    public void Voltar(View view) {
        Intent i = new Intent(AlterarTreino.this, MeuTreino.class);
        startActivity(i);
    }
}