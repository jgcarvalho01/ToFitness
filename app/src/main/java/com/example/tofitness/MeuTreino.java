package com.example.tofitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MeuTreino extends AppCompatActivity {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_treino);

        BancoController crud = new BancoController(getBaseContext());
        final Cursor cursor = crud.listarTreinos();

        String[] nomeCampos = new String[]{CriaBanco.CATEGORIA_TREINO, CriaBanco.TIPO_TREINO, CriaBanco.REPETICAO_TREINO};
        int[] idViews = new int[]{R.id.categoria, R.id.tipo, R.id.repeticao};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(), R.layout.treino_layout, cursor, nomeCampos, idViews, 0);
        lista = findViewById(R.id.lvTreino);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String codigo;
                cursor.moveToPosition(i);
                codigo = cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.ID_TREINO));
                Intent intent = new Intent(MeuTreino.this, AlterarTreino.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });

    }

    public void IrParaAddTreino(View v) {
        Intent i = new Intent(MeuTreino.this, Treino_Form.class);
        startActivity(i);
    }

    public void Voltar(View v) {
        Intent i = new Intent(MeuTreino.this, MainActivity.class);
        startActivity(i);
    }
}