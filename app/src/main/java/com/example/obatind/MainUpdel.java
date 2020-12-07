package com.example.obatind;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.chrono.Era;

public class MainUpdel extends AppCompatActivity{
    private DatabaseObat db;
    private String Sid, Snama, Sjenis, Sguna;
    private EditText Enama, Ejenis, Eguna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new DatabaseObat(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sjenis = i.getStringExtra("Ijenis");
        Sguna = i.getStringExtra("Iguna");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Ejenis = (EditText) findViewById(R.id.updel_jenis);
        Eguna = (EditText) findViewById(R.id.updel_guna);
        Enama.setText(Snama);
        Ejenis.setText(Sjenis);
        Eguna.setText(Sguna);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                Sguna = String.valueOf(Eguna.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi jenis obat",
                            Toast.LENGTH_SHORT).show();
                } else if (Sguna.equals("")){
                    Eguna.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi manfaat obat",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateObat(new Obat(Sid, Snama, Sjenis, Sguna));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteObat(new Obat(Sid, Snama, Sjenis, Sguna));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}