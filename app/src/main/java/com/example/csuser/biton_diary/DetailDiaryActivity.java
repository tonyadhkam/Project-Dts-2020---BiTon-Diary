package com.example.csuser.biton_diary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.csuser.biton_diary.entities.Diary;
import com.example.csuser.biton_diary.models.DiaryModel;
public class DetailDiaryActivity extends AppCompatActivity
{
    // Data
    private DiaryModel mDiary;
    private Diary selectedDiary;
    // Komponen
    private EditText txtTanggal;
    private EditText txtJudul;
    private EditText txtPesan;
    private Button btnHapus;
    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_diary);
        this.initData();
        this.initComponents();
    }
    private void initData()
    {
        this.mDiary = new DiaryModel(this);
        int selectedContactId = this.getIntent().getIntExtra("selectedContactId", -1);
        this.selectedDiary = this.mDiary.selectOne(selectedContactId);
    }
    private void initComponents()
    {
        this.txtTanggal = (EditText) this.findViewById(R.id.txtTanggal);
        this.txtJudul = (EditText) this.findViewById(R.id.txtJudul);
        this.txtPesan = (EditText) this.findViewById(R.id.txtPesan);
        this.btnHapus = (Button) this.findViewById(R.id.btnHapus);
        this.btnKembali = (Button) this.findViewById(R.id.btnKembali);

        this.txtTanggal.setText(this.selectedDiary.getTanggal());
        this.txtJudul.setText(this.selectedDiary.getJudul());
        this.txtPesan.setText(this.selectedDiary.getPesan());
    }
    public void button_onClick(View view)
    {
        Button b = (Button) view;
        if(b == this.btnHapus)
        {
            this.hapusDiary();
        }
        else if(b == this.btnKembali)
        {
            this.finish();
        }
    }


    private void resetFields(String pesan, boolean clear)
    {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();
        if(clear)
        {
            this.txtTanggal.setText("");
            this.txtJudul.setText("");
            this.txtPesan.setText("");
        }
    }

    private void hapusDiary()
    {
        this.mDiary.delete(this.selectedDiary);
        this.resetFields("Diary dihapus..", true);
        this.btnHapus.setEnabled(false);
    }
}
