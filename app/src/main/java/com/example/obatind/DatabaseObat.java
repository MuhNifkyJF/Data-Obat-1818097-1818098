package com.example.obatind;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseObat extends SQLiteOpenHelper{
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_obatin";
    private static final String tb_obat = "tb_obat";
    private static final String tb_obat_id = "id";
    private static final String tb_obat_nama = "nama";
    private static final String tb_obat_jenis = "jenis";
    private static final String tb_obat_guna = "guna";
    private static final String CREATE_TABLE_KUE = "CREATE TABLE " +
            tb_obat + "("
            + tb_obat_id + " INTEGER PRIMARY KEY ,"
            + tb_obat_nama + " TEXT,"
            + tb_obat_jenis + " TEXT,"
            + tb_obat_guna + " TEXT " + ")";

    public DatabaseObat (Context context){
        super(context, DATABASE_NAME,
                null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_KUE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateObat (Obat mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_obat_id, mdNotif.getmId());
        values.put(tb_obat_nama, mdNotif.getmNama());
        values.put(tb_obat_jenis, mdNotif.getmJenis());
        values.put(tb_obat_guna, mdNotif.getmGuna());
        db.insert(tb_obat, null, values);
        db.close();
    }

    public List<Obat> ReadObat() {
        List<Obat> judulModelList = new ArrayList<Obat>();
        String selectQuery = "SELECT * FROM " + tb_obat;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Obat dataObat = new Obat();
                dataObat.setmId(cursor.getString(0));
                dataObat.setmNama(cursor.getString(1));
                dataObat.setmJenis(cursor.getString(2));
                dataObat.setmGuna(cursor.getString(3));
                judulModelList.add(dataObat);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateObat (Obat mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_obat_nama, mdNotif.getmNama());
        values.put(tb_obat_jenis, mdNotif.getmJenis());
        values.put(tb_obat_guna, mdNotif.getmGuna());
        return db.update(tb_obat, values, tb_obat_id + " = ?",
                new String[] { String.valueOf(mdNotif.getmId())});
    }
    public void DeleteObat (Obat mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_obat, tb_obat_id+ " = ?",
                new String[]{String.valueOf(mdNotif.getmId())});
        db.close();
    }

}
