package com.example.banksoal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KategoriSoal extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnK1, btnK2, btnK3, btnK4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_soal);

        //Menghubungkan variabel button dengan komponen pada layout
        btnK1 = findViewById((R.id.btK1));
        btnK2 = findViewById((R.id.btK2));
        btnK3 = findViewById((R.id.btk3));
        btnK4 = findViewById((R.id.btK4));

        btnK1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman dashboard ke halaman yang menampilkan kategori soal
                Intent i = new Intent(getApplicationContext(),UploadSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        btnK2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman dashboard ke halaman yang menampilkan kategori soal
                Intent i = new Intent(getApplicationContext(),UploadSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
        btnK3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman dashboard ke halaman yang menampilkan kategori soal
                Intent i = new Intent(getApplicationContext(),UploadSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        btnK4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman dashboard ke halaman yang menampilkan kategori soal
                Intent i = new Intent(getApplicationContext(),UploadSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}