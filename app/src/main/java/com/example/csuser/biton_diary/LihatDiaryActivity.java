package com.example.csuser.biton_diary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.csuser.biton_diary.entities.Diary;
import com.example.csuser.biton_diary.models.DiaryModel;
import java.util.ArrayList;
public class LihatDiaryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // Data
    private DiaryModel mDiary;
    private ArrayList<Diary> allDiary;
    private ArrayList<String> daftarDiary;
    // Komponen
    private ListView lstDaftarDiary;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_diary);
        this.initData();
        this.initComponents();
    }
    private void initData()
    {
        this.daftarDiary = new ArrayList<>();
        this.mDiary = new DiaryModel(this);
        this.allDiary = this.mDiary.selectAll();
        for(Diary d : allDiary)
        {
            this.daftarDiary.add(d.getJudul());
        }
    }
    private void initComponents()
    {
        this.lstDaftarDiary = (ListView) this.findViewById(R.id.lstDaftarDiary);
        this.btnOk = (Button) this.findViewById(R.id.btnOk);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, this.daftarDiary);
        this.lstDaftarDiary.setAdapter(adapter);

        this.lstDaftarDiary.setOnItemClickListener(this);
    }
    public void button_onClick(View view)
    {
        Button b = (Button) view;
        if(b == this.btnOk)
            this.finish();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        int id = this.allDiary.get(i).getId();

        Intent intent = new Intent(this, DetailDiaryActivity.class);
        intent.putExtra("selectedContactId", id);
        this.startActivity(intent);
    }
}
