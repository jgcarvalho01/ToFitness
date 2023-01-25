package com.example.tofitness;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MeuTreino(View view){
        Intent intent = new Intent(this, MeuTreino.class);
        startActivity(intent);
    }

    public void Relatorios(View view){
        Intent i = new Intent(this, Relatorio.class);
        startActivity(i);
    }

    public void CalcularImc(View view){
        Intent i = new Intent(this, CalcularImc.class);
        startActivity(i);
    }

    public void Sair(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Saindo do APP...");
        builder.setMessage("Deseja realmente sair do APP?");

        builder.setPositiveButton("SIM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Saindo do APP...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        builder.setNegativeButton("NÃO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Continuando", Toast.LENGTH_SHORT).show();
            }
        });

        alerta = builder.create();
        alerta.show();
    }
}