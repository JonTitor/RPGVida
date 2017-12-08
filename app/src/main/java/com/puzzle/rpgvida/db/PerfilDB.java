package com.puzzle.rpgvida.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.puzzle.rpgvida.Perfil;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by acneidert on 04/12/17.
 */

public class PerfilDB extends SQLiteOpenHelper {
    public static final String NOME_BANCO = "rpgvida.sqlite";
    private static final int VERSAO_BANCO = 1;

    public PerfilDB(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists perfil (" +
                "_id integer PRIMARY KEY  AUTOINCREMENT  NOT NULL  UNIQUE , " +
                "nome text,  " +
                "user text,  " +
                "senha text, " +
                "xp integer  " +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean savePerfil(Perfil perfil){
        long id = perfil.getId();
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("nome", perfil.getNome());
            values.put("user", perfil.getUser());
            values.put("senha", perfil.getSenha());
            values.put("xp", perfil.getXp());

            if (id != 0) {
                String _id = String.valueOf(perfil.getId());
                String[] whereArgs = new String[]{_id};
                int count = db.update("perfil", values, "_id=?", whereArgs);
                return true;
            } else {
                values.put("feito", 0);
                id = db.insert("perfil", "", values);
                return true;
            }
        } catch (Exception e){
            return false;
        }
        finally {
            db.close();
        }
    }
    /****
     * Validar função
     ****/
//    public Perfil login(Perfil perfil){
//        Perfil perfil2 =  new Perfil();
//        SQLiteDatabase db = getWritableDatabase();
//        String where = " user = ? and senha = ?";
//        String[] whereArgs = new String[] {
//                perfil.getUser(),
//                perfil.getSenha()
//        };
//        try {
//            Cursor c = db.query("perfil", null,where, whereArgs , null, null, null, null);
//            if (c.moveToFirst()) {
//                perfil2.setId(c.getLong(c.getColumnIndex("_id")));
//                perfil2.setNome(c.getString(c.getColumnIndex("nome")));
//                perfil2.setUser(c.getString(c.getColumnIndex("user")));
//                perfil2.setXp(c.getInt(c.getColumnIndex("xp")));
//                perfil2.setLogged(true);
//            }
//        }finally {
//            db.close();
//        }
//
//        return perfil2;
//    }

//    public int delete(Perfil perfil) {
//        SQLiteDatabase db = getWritableDatabase();
//        try {
//            int count = db.delete("perfil", "_id=?", new String[]{String.valueOf(perfil.getId())});
//            Log.i(TAG, "Deletou [" + count + "] registro.");
//            return count;
//        } finally {
//            db.close();
//        }
//    }

    public List<Perfil> findAll() {
        SQLiteDatabase db = getWritableDatabase();
        try {
            Cursor c = db.query("perfil", null, null, null, null, null, null, null);
            return toList(c);
        } finally {
            db.close();
        }
    }
    //
    private List<Perfil> toList(Cursor c) {
        List<Perfil> perfils = new ArrayList<Perfil>();
        if (c.moveToFirst()) {
            do {
                Perfil perfil = new Perfil();
                perfils.add(perfil);
                perfil.setId(c.getLong(c.getColumnIndex("_id")));
                perfil.setNome(c.getString(c.getColumnIndex("nome")));
                perfil.setUser(c.getString(c.getColumnIndex("user")));
                perfil.setXp(c.getInt(c.getColumnIndex("xp")));
                perfil.toString();
            } while (c.moveToNext());
        }
        return perfils;
    }

    public Perfil findByID(int id) {
        SQLiteDatabase db = getWritableDatabase();
        Perfil perfil =  new Perfil();
        try {
            Cursor c = db.query("perfil", null,"_id=?", new String[]{id+""} , null, null, null, null);
            if (c.moveToFirst()) {
                perfil.setId(c.getLong(c.getColumnIndex("_id")));
                perfil.setNome(c.getString(c.getColumnIndex("nome")));
                perfil.setUser(c.getString(c.getColumnIndex("user")));
                perfil.setXp(c.getInt(c.getColumnIndex("xp")));
            }
            return perfil;
        }finally {
            db.close();
        }
    }

    public boolean hasPerfil(){
        SQLiteDatabase db = getWritableDatabase();
        try {
            Cursor c = db.rawQuery("SELECT * FROM perfil",null);
            if (c.moveToFirst()) {
                return true;
            } else {
                return false;
            }
        }finally{
                db.close();
            }



    }


}
