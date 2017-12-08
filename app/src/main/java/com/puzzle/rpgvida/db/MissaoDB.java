package com.puzzle.rpgvida.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.puzzle.rpgvida.Missao;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by acneidert on 04/12/17.
 */

public class MissaoDB extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "rpgvida.sqlite";
    private static final int VERSAO_BANCO = 1;

    public MissaoDB(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists missao (" +
                        "_id integer PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , " +
                        "nome text, " +
                        "desc text, " +
                        "dificuldade integer, " +
                        "feito integer NOT NULL  DEFAULT 0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean saveMissao(Missao missao){
        long id = missao.getId();
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("nome", missao.getNome());
            values.put("desc", missao.getDescricao());
            values.put("dificuldade", missao.getDificuldade());

            if (id != 0) {
                String _id = String.valueOf(missao.getId());
                String[] whereArgs = new String[]{_id};
                int count = db.update("missao", values, "_id=?", whereArgs);
                return true;
            } else {
                values.put("feito", 0);
                id = db.insert("missao", "", values);
                return true;
            }
        } catch (Exception e){
            return false;
        }
        finally {
            db.close();
        }
    }

    public boolean setMissaoFeito(Missao missao){
        long id = missao.getId();
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("feito", (missao.getFeito() ? 1 : 0));
            String _id = String.valueOf(missao.getId());
            String[] whereArgs = new String[]{_id};
            int count = db.update("missao", values, "_id=?", whereArgs);
            Log.i(TAG, "Finalizou [" + count + "] registro. _id = "+_id);
            return true;

        } catch (Exception e){
            return false;
        }
        finally {
            db.close();
        }
    }

    public int delete(Missao missao) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            int count = db.delete("missao", "_id=?", new String[]{String.valueOf(missao.getId())});
            Log.i(TAG, "Deletou [" + count + "] registro.");
            return count;
        } finally {
            db.close();
        }
    }

    public List<Missao> findAll() {
        SQLiteDatabase db = getWritableDatabase();
        try {
            Cursor c = db.query("missao", null, null, null, null, null, null, null);
            return toList(c);
        } finally {
            db.close();
        }
    }
    public List<Missao> findAllOpen() {
        SQLiteDatabase db = getWritableDatabase();
        try {
            Cursor c = db.query("missao", null, "feito=0", null, null, null, null, null);
            return toList(c);
        } finally {
            db.close();
        }
    }
    public List<Missao> findAllClose() {
        SQLiteDatabase db = getWritableDatabase();
        try {
            Cursor c = db.query("missao", null, "feito=1", null, null, null, null, null);
            return toList(c);
        } finally {
            db.close();
        }
    }
    // Lê o cursor e cria a lista de carros
    private List<Missao> toList(Cursor c) {
        List<Missao> missoes = new ArrayList<Missao>();
        if (c.moveToFirst()) {
            do {
                Missao missao = new Missao();
                missoes.add(missao);
                missao.setId(c.getLong(c.getColumnIndex("_id")));
                missao.setNome(c.getString(c.getColumnIndex("nome")));
                missao.setDescricao(c.getString(c.getColumnIndex("desc")));
                missao.setDificuldade(c.getInt(c.getColumnIndex("dificuldade")));
                missao.setFeito((c.getInt(c.getColumnIndex("feito")) == 1 ? true : false));
                missao.toString();
            } while (c.moveToNext());
        }
        return missoes;
    }

    public Missao findByID(int id) {
        SQLiteDatabase db = getWritableDatabase();
        Missao missao =  new Missao();
        try {
            Cursor c = db.query("missao", null,"_id=?", new String[]{id+""} , null, null, null, null);
            if (c.moveToFirst()) {
                missao.setId(c.getLong(c.getColumnIndex("_id")));
                missao.setNome(c.getString(c.getColumnIndex("nome")));
                missao.setDescricao(c.getString(c.getColumnIndex("desc")));
                missao.setDificuldade(c.getInt(c.getColumnIndex("dificuldade")));
                missao.setFeito((c.getInt(c.getColumnIndex("feito")) == 1 ? true : false));
            }
            return missao;
        }finally {
            db.close();
        }
    }
}

