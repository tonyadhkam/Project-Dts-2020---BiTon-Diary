package com.example.csuser.biton_diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends AppCompatActivity {
    private Button btnLihatDiary;
    private Button btnTambahDiary;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initComponents();
    }
    private void initComponents()
    {
        this.btnLihatDiary = (Button) this.findViewById(R.id.btnLihatDiary);
        this.btnTambahDiary = (Button) this.findViewById(R.id.btnTambahDiary);
    }
    public void button_onClick(View view)
    {
        Button b = (Button) view;
        if(b == this.btnLihatDiary)
        {
            this.openLihatDiaryActivity();
        }
        else if(b == this.btnTambahDiary)
        {
            this.openTambahDiaryActivity();
        }
    }
    private void openLihatDiaryActivity()
    {
        Intent i = new Intent(this, LihatDiaryActivity.class);
        this.startActivity(i);
    }
    private void openTambahDiaryActivity()
    {
        Intent i = new Intent(this, TambahDiaryActivity.class);
        this.startActivity(i);
    }
}
