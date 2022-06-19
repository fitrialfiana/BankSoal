package com.example.banksoal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeUploadSoal extends AppCompatActivity {
    FloatingActionButton tambahS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_upload_soal);

        //Menghubungkan variabel button dengan komponen pada layout
        tambahS = findViewById((R.id.floatingActionButton2));

        tambahS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                //Buat objek berpindah act dari halaman home upload ke halaman upload soal
                //CRUD
                Intent i = new Intent(getApplicationContext(), ViewSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}