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

public class AlterarRelatorio extends AppCompatActivity {

    private AlertDialog alerta;
    private EditText altura;
    private EditText peso;
    private EditText imc;
    private EditText data;
    private Button alterar;
    private Button deletar;
    private Cursor cursor;
    private BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_relatorio);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        altura = findViewById(R.id.edtAltura);
        peso = findViewById(R.id.edtPeso);
        imc = findViewById(R.id.edtIMC);
        data = findViewById(R.id.edtData);

        alterar = findViewById(R.id.btAlterar);

        cursor = crud.carregarDadosRelatorioById(Integer.parseInt(codigo));

        altura.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.ALTURA_RELATORIO)));
        peso.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.PESO_RELATORIO)));
        imc.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.IMC_RELATORIO)));
        data.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.DATA_RELATORIO)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.atualizarRelatorio(
                        Integer.parseInt(codigo),
                        altura.getText().toString(),
                        peso.getText().toString(),
                        imc.getText().toString(),
                        data.getText().toString()
                );

                Toast.makeText(getApplicationContext(), "Registro alterado com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AlterarRelatorio.this, Relatorio.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = findViewById(R.id.btDeletar);

        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlterarRelatorio.this);
                builder.setTitle("Excluindo registro...");
                builder.setMessage("Deseja realmente excluir o registro?");

                builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        crud.deleteRelatorio(Integer.parseInt(codigo));
                        Toast.makeText(getApplicationContext(), "Registro excluido com sucesso!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AlterarRelatorio.this, Relatorio.class);
                        startActivity(intent);
                        finish();
                    }
                });

                builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlterarRelatorio.this, "Registro não excluido", Toast.LENGTH_SHORT).show();
                    }
                });

                alerta = builder.create();
                alerta.show();
            }
        });
    }

    public void Voltar(View view) {
        Intent i = new Intent(AlterarRelatorio.this, Relatorio.class);
        startActivity(i);
    }
}