package com.example.obatind;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DatabaseObat db;
    private List<Obat> ListObat = new ArrayList<Obat>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new DatabaseObat(this);
        adapter_off = new CustomListAdapter(this, ListObat );
        mListView = (ListView) findViewById(R.id.list_obat);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListObat.clear();
        List<Obat> contacts = db.ReadObat();
        for (Obat cn : contacts) {
            Obat dataObat = new Obat();
            dataObat.setmId(cn.getmId());
            dataObat.setmNama(cn.getmNama());
            dataObat.setmJenis(cn.getmJenis());
            dataObat.setmGuna(cn.getmGuna());
            ListObat.add(dataObat);
            if ((ListObat.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Obat obj_itemDetails = (Obat)o;
        String Sid = obj_itemDetails.getmId();
        String Snama = obj_itemDetails.getmNama();
        String Sjenis = obj_itemDetails.getmJenis();
        String Sguna = obj_itemDetails.getmGuna();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Iguna", Sguna);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListObat.clear();
        mListView.setAdapter(adapter_off);
        List<Obat> contacts = db.ReadObat();
        for (Obat cn : contacts) {
            Obat dataObat = new Obat();
            dataObat.setmId(cn.getmId());
            dataObat.setmNama(cn.getmNama());
            dataObat.setmJenis(cn.getmJenis());
            dataObat.setmGuna(cn.getmGuna());
            ListObat.add(dataObat);
            if ((ListObat.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
