package com.example.obatind;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainCreate extends AppCompatActivity {
    private DatabaseObat db;
    private EditText Enama, Ejenis, Eguna;
    private String Snama, Sjenis, Sguna;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new DatabaseObat(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Eguna = (EditText) findViewById(R.id.create_guna);
        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                Sguna = String.valueOf(Eguna.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama obat",
                            Toast.LENGTH_SHORT).show();
                } else if (Sjenis.equals("")){
                    Ejenis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jenis obat",
                            Toast.LENGTH_SHORT).show();
                } else if (Sguna.equals("")){
                    Eguna.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi manfaat",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Ejenis.setText("");
                    Eguna.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateObat(new Obat(null, Snama, Sjenis, Sguna));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
