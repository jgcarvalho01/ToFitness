package com.example.tofitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {
    private SQLiteDatabase db;
    private final CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public String criarTreino(String categoria, String tipo, String repeticao) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.CATEGORIA_TREINO, categoria);
        valores.put(CriaBanco.TIPO_TREINO, tipo);
        valores.put(CriaBanco.REPETICAO_TREINO, repeticao);

        resultado = db.insert(CriaBanco.TABELA_TREINO, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro.";
        else
            return "Registro inserido com sucesso.";
    }


    public void atualizarTreino(int id, String categoria, String tipo, String repeticao) {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.ID_TREINO + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.CATEGORIA_TREINO, categoria);
        valores.put(CriaBanco.TIPO_TREINO, tipo);
        valores.put(CriaBanco.REPETICAO_TREINO, repeticao);

        db.update(CriaBanco.TABELA_TREINO, valores, where, null);
        db.close();
    }

    public Cursor listarTreinos() {
        Cursor cursor;
        String[] campos = {CriaBanco.ID_TREINO, CriaBanco.CATEGORIA_TREINO, CriaBanco.TIPO_TREINO, CriaBanco.REPETICAO_TREINO};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA_TREINO, campos, null, null, null, null, "categoria", null);

        if (cursor != null)
            cursor.moveToFirst();
        db.close();
        return cursor;
    }

    public Cursor carregarDadosTreinoById(int id) {
        Cursor cursor;
        String[] campos = {CriaBanco.ID_TREINO, CriaBanco.CATEGORIA_TREINO, CriaBanco.TIPO_TREINO, CriaBanco.REPETICAO_TREINO};
        String where = CriaBanco.ID_TREINO + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA_TREINO, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public void deleteTreino(int id) {
        String where = CriaBanco.ID_TREINO + "=" + id;
        db = banco.getWritableDatabase();
        db.delete(CriaBanco.TABELA_TREINO, where, null);
        db.close();
    }

    public String criarRelatorio(String altura, String peso, String imc, String data) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.ALTURA_RELATORIO, altura);
        valores.put(CriaBanco.PESO_RELATORIO, peso);
        valores.put(CriaBanco.IMC_RELATORIO, imc);
        valores.put(CriaBanco.DATA_RELATORIO, data);

        resultado = db.insert(CriaBanco.TABELA_RELATORIO, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro.";
        else
            return "Registro inserido com sucesso.";
    }


    public void atualizarRelatorio(int id, String altura, String peso, String imc, String data) {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = CriaBanco.ID_RELATORIO + "=" + id;

        valores = new ContentValues();
        valores.put(CriaBanco.ALTURA_RELATORIO, altura);
        valores.put(CriaBanco.PESO_RELATORIO, peso);
        valores.put(CriaBanco.IMC_RELATORIO, imc);
        valores.put(CriaBanco.DATA_RELATORIO, data);

        db.update(CriaBanco.TABELA_RELATORIO, valores, where, null);
        db.close();
    }

    public Cursor listarRelatorio() {
        Cursor cursor;
        String[] campos = {CriaBanco.ID_RELATORIO, CriaBanco.ALTURA_RELATORIO, CriaBanco.PESO_RELATORIO, CriaBanco.IMC_RELATORIO, CriaBanco.DATA_RELATORIO};
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA_RELATORIO, campos, null, null, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();
        db.close();
        return cursor;
    }

    public Cursor carregarDadosRelatorioById(int id) {
        Cursor cursor;
        String[] campos = {CriaBanco.ID_RELATORIO, CriaBanco.ALTURA_RELATORIO, CriaBanco.PESO_RELATORIO, CriaBanco.IMC_RELATORIO, CriaBanco.DATA_RELATORIO};
        String where = CriaBanco.ID_RELATORIO + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(CriaBanco.TABELA_RELATORIO, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public void deleteRelatorio(int id) {
        String where = CriaBanco.ID_RELATORIO + "=" + id;
        db = banco.getWritableDatabase();
        db.delete(CriaBanco.TABELA_RELATORIO, where, null);
        db.close();
    }
}
