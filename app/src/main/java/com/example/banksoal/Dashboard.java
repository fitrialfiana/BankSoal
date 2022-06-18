package com.example.banksoal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Dashboard extends AppCompatActivity {

    //Deklarasi variabel untuk button
    Button btnCariSoal, btnUploadSoal, btnArtikel;
    ImageButton btnProfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Menghubungkan variabel button dengan komponen pada layout
        btnCariSoal = findViewById((R.id.btcari));
        btnUploadSoal = findViewById((R.id.btupload));
        btnArtikel = findViewById((R.id.btartikel));
        btnProfil = findViewById((R.id.ButtonProfil));

        btnCariSoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman dashboard ke halaman yang menampilkan kategori soal
                Intent i = new Intent(getApplicationContext(),LihatSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        btnUploadSoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman dashboard ke halaman yang menampilkan kategori soal
                Intent i = new Intent(getApplicationContext(), HomeUploadSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });


        btnArtikel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman dashboard ke halaman yang menampilkan kategori soal
                Intent i = new Intent(getApplicationContext(),Artikel.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman dashboard ke halaman yang menampilkan Profile
                Intent i = new Intent(getApplicationContext(),Profile.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}