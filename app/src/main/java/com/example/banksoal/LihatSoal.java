package com.example.banksoal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LihatSoal extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnB1, btnB2, btnB3, btnB4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_soal);

        //Menghubungkan variabel button dengan komponen pada layout
        btnB1 = findViewById((R.id.btbidang1));
        btnB2 = findViewById((R.id.btbidang2));
        btnB3 = findViewById((R.id.btbidang3));
        btnB4 = findViewById((R.id.btbidang4));

        btnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman dashboard ke halaman yang menampilkan kategori soal
                Intent i = new Intent(getApplicationContext(),KategoriSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman dashboard ke halaman yang menampilkan kategori soal
                Intent i = new Intent(getApplicationContext(),KategoriSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        btnB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman dashboard ke halaman yang menampilkan kategori soal
                Intent i = new Intent(getApplicationContext(),KategoriSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        btnB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman dashboard ke halaman yang menampilkan kategori soal
                Intent i = new Intent(getApplicationContext(),KategoriSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}