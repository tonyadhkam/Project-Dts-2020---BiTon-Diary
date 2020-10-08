package com.example.csuser.biton_diary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.csuser.biton_diary.entities.Diary;
import com.example.csuser.biton_diary.models.DiaryModel;

public class TambahDiaryActivity extends AppCompatActivity {
    // Data
    private DiaryModel mDiary;

    // Komponen
    private EditText txtTanggal;
    private EditText txtJudul;
    private EditText txtPesan;
    private Button btnSimpan;
    private Button btnBatal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_diary);
        this.initData();
        this.initComponents();
    }

    private void initData() {
        this.mDiary = new DiaryModel(this);
    }

    private void initComponents() {
        this.txtTanggal = (EditText) this.findViewById(R.id.txtTanggal);
        this.txtJudul = (EditText) this.findViewById(R.id.txtJudul);
        this.txtPesan = (EditText) this.findViewById(R.id.txtPesan);
        this.btnSimpan = (Button) this.findViewById(R.id.btnSimpan);
        this.btnBatal = (Button) this.findViewById(R.id.btnBatal);
    }

    public void button_onClick(View view) {
        Button b = (Button) view;
        if (b == this.btnSimpan) {
            this.tambahDiary();
        } else if (b == this.btnBatal) {
            this.finish();
        }
    }

    private void tambahDiary() {
        String tanggal = this.txtTanggal.getText().toString();
        String judul = this.txtJudul.getText().toString();
        String pesan = this.txtPesan.getText().toString();

        if (isAngka(tanggal)) {
            Diary diaryBaru = new Diary();
            diaryBaru.setTanggal(tanggal);
            diaryBaru.setJudul(judul);
            diaryBaru.setPesan(pesan);
            this.mDiary.insert(diaryBaru);
            Toast.makeText(this, "Diary berhasil ditambahkan", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Tanggal harus memasukkan angka", Toast.LENGTH_SHORT).show();
        }
        this.btnBatal.setText("Kembali");
    }

    private boolean isAngka(String tanggal) {
        try {
            Double.parseDouble(tanggal);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}