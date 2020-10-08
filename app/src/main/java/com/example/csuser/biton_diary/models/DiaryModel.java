package com.example.csuser.biton_diary.models;

import android.content.Context;
import android.database.Cursor;
import java.util.ArrayList;
import com.example.csuser.biton_diary.entities.Diary;
import com.example.csuser.biton_diary.libraries.DbHelper;


public class DiaryModel
{
    private Context context;
    private DbHelper db;
    public DiaryModel(Context context)
    {
        this.context = context;
        this.db = new DbHelper(this.context);
    }
    public ArrayList<Diary> selectAll()
    {
        String sql = "SELECT * FROM diary";
        ArrayList<Diary> semuaDiary = new ArrayList<>();
        Cursor cursor = this.db.executeRead(sql);
        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            do
            {
                int id = cursor.getInt(0);
                String tanggal = cursor.getString(1);
                String judul = cursor.getString(2);
                String pesan = cursor.getString(3);
                Diary d = new Diary();
                d.setId(id);
                d.setTanggal(tanggal);
                d.setJudul(judul);
                d.setPesan(pesan);
                semuaDiary.add(d);
            }
            while (cursor.moveToNext());
        }
        return semuaDiary;
    }

    public void insert(Diary d)
    {
        String tanggal = d.getTanggal();
        String judul = d.getJudul();
        String pesan = d.getPesan();
        String sql = "INSERT INTO diary(tanggal, judul, pesan) VALUES('" + tanggal + "', '" + judul + "', '" + pesan + "')";
        this.db.executeWrite(sql);
    }

    public void update(Diary d)
    {
        if(d.getId() < 0)
            return;
        int id = d.getId();
        String tanggal = d.getTanggal();
        String judul = d.getJudul();
        String pesan = d.getPesan();
        String sql = "UPDATE diary SET tanggal = '" + tanggal + "', judul = '" + judul + "', pesan = '" + pesan + "' WHERE id = '" + id + "'";
        this.db.executeWrite(sql);
    }

    public Diary selectOne(int id)
    {
        String sql = "SELECT * FROM diary WHERE id = '" + id + "'";
        Cursor cursor = this.db.executeRead(sql);
        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            Diary d = new Diary();
            d.setId(cursor.getInt(0));
            d.setTanggal(cursor.getString(1));
            d.setJudul(cursor.getString(2));
            d.setPesan(cursor.getString(3));
            return d;
        }
        return null;
    }

    public void delete(Diary d)
    {
        if(d.getId() < 0) // ID negatif -> Bukan dari tabel
            return;
        String sql = "DELETE FROM diary WHERE id = '" + d.getId() + "'";
        this.db.executeWrite(sql);
    }
}
