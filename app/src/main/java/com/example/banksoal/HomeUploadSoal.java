package com.example.banksoal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeUploadSoal extends AppCompatActivity {
    FloatingActionButton tambahS;
    Button add2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_upload_soal);

        //Menghubungkan variabel button dengan komponen pada layout
        tambahS = findViewById((R.id.floatingActionButton2));
        add2 = findViewById((R.id.Add2));

        tambahS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                Intent i = new Intent(getApplicationContext(), UploadSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                Intent i = new Intent(getApplicationContext(), ViewSoal.class);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }
}