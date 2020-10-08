package com.example.csuser.biton_diary.libraries;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper( Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql = "CREATE TABLE IF NOT EXISTS diary(id integer PRIMARY KEY, tanggal VARCHAR, judul VARCHAR, pesan VARCHAR)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        String sql = "DROP TABLE IF EXISTS diary";
        db.execSQL(sql);
        this.onCreate(db);
    }

    public DbHelper(Context context)
    {
        super(context, "diary.db", null, 1);
    }

    public Cursor executeRead(String sql)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return cursor;
    }
    public void executeWrite(String sql)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
}
