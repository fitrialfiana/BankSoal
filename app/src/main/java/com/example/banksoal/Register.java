package com.example.banksoal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {
    //Mendeklarasikan variabel dengan tipe data EditText
    EditText txEmail, edPass, erepass, edAlamat;

    //Deklarasi variabel untuk button
    Button btnRegister;

    String taEmail;

    String nama2, email2, password2, repass2;


    @Override
    protected void onCreate (Bundle savedInstancestate){
        super.onCreate(savedInstancestate);
        setContentView(R.layout.activity_register);

        //menghubungkan variabel btnRegis dengan component pada layout
        btnRegister = findViewById(R.id.btReg);

        //Menghubungkan variabel txEmail dengan componen Textview pada Layout
        txEmail = findViewById(R.id.tvEmail);

        //Menghubungkan variabel txEmail dengan componen Textview pada Layout
        edPass = findViewById(R.id.tvPassword);

        //Menghubungkan variabel txEmail dengan componen Textview pada Layout
        edAlamat = findViewById(R.id.emNama);

        //Menghubungkan variabel txEmail dengan componen Textview pada Layout
        erepass = findViewById(R.id.eMrepas);
        taEmail = txEmail.getText().toString();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                password2 = edPass.getText().toString();
                repass2 = erepass.getText().toString();

                if (password2.length()==0) {
                    edPass.setError("Password harus di isi");
                    Toast.makeText(getApplicationContext(),"Data tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else if (repass2.length()==0){
                    Toast.makeText(getApplicationContext(),"Konfirmasi Password tidak boleh kosong",Toast.LENGTH_LONG).show();
                }
                else if (!password2.equals(repass2)){
                    Toast.makeText(getApplicationContext(),"Isi password yang sama",Toast.LENGTH_LONG).show();
                }
                else if (password2.equals(repass2)) {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Register Sukses",
                            Toast.LENGTH_LONG);
                    //Menampilkan toast
                    t.show();
                    Bundle bundle = new Bundle();
                    bundle.putString("a",taEmail.trim());
                    //Membuat objek intent berpindah activity dari halamankedua ke HalamanHasil
                    Intent i = new Intent(getApplicationContext(), Dashboard.class);
                    i.putExtras(bundle);
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Nama salah",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}