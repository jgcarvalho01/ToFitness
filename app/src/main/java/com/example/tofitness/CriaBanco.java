package com.example.tofitness;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "tofitness.db";
    protected static final int VERSAO = 1;

    protected static final String TABELA_TREINO = "Treino";
    protected static final String ID_TREINO = "_id";
    protected static final String CATEGORIA_TREINO = "categoria";
    protected static final String TIPO_TREINO = "tipo";
    protected static final String REPETICAO_TREINO = "repeticao";

    protected static final String TABELA_RELATORIO = "Relatorio";
    protected static final String ID_RELATORIO = "_id";
    protected static final String ALTURA_RELATORIO= "altura";
    protected static final String PESO_RELATORIO= "peso";
    protected static final String IMC_RELATORIO= "imc";
    protected static final String DATA_RELATORIO = "data";


    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql_treino = "CREATE TABLE " + TABELA_TREINO + "("
                + ID_TREINO + " integer primary key autoincrement,"
                + TIPO_TREINO + " text,"
                + CATEGORIA_TREINO + " text,"
                + REPETICAO_TREINO + " text"
                + ")";
        db.execSQL(sql_treino);


        String sql_relatorio = "CREATE TABLE " + TABELA_RELATORIO + "("
                + ID_RELATORIO + " integer primary key autoincrement,"
                + ALTURA_RELATORIO + " text,"
                + PESO_RELATORIO + " text,"
                + IMC_RELATORIO + " text,"
                + DATA_RELATORIO + " text"
                + ")";
        db.execSQL(sql_relatorio);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABELA_TREINO+ "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABELA_RELATORIO + "'");
        onCreate(db);
    }
}
