package com.example.tofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Relatorio extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relatorio);

        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.listarRelatorio();

        String[] nomeCampos = new String[]{CriaBanco.ALTURA_RELATORIO, CriaBanco.PESO_RELATORIO, CriaBanco.IMC_RELATORIO, CriaBanco.DATA_RELATORIO};
        int[] idViews = new int[]{R.id.altura, R.id.peso, R.id.imc, R.id.data};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.relatorio_layout, cursor, nomeCampos, idViews, 0);
        lista = findViewById(R.id.lvRelatorio);
        lista.setAdapter(adaptador);

    }

    public void IrParaAddRelatorio(View v) {
        Intent i = new Intent(Relatorio.this, Relatorio_Form.class);
        startActivity(i);
    }

    public void Voltar(View v) {
        Intent i = new Intent(Relatorio.this, MainActivity.class);
        startActivity(i);
    }
}