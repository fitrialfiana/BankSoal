package com.example.banksoal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi variabel untuk button signin
    Button btnSignin;

    //Deklarasi variabel untuk EditText
    EditText edEmail, edPassword;

    //deklarasi variabel untuk menyimpan nama dan password
    String nama, password;

    TextView Register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan variabel btnSignn dengan component pada layout
        btnSignin = findViewById(R.id.btRegis);

        //Menghubungkan variabel edemail dengan component pada layout
        edEmail = findViewById(R.id.txEmail);
        //menghubungkan variabel edpassword dengan component pada layout
        edPassword = findViewById(R.id.txPassword);

        //menghubungkan variabel Register dengan component pada layout
        Register = findViewById(R.id.idreg);

        //Membuat method saat klik Register berpindah ke Activity hasil
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Membuat objek intent supaya activity berpindah dari mainactivity ke ActivityHasil
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
            }
        });


        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Menyimpan input user di edittext email kedalam variabel nama
                nama = edEmail.getText().toString();

                //Menyimpan input user di edittext password kedalam variabel password
                password = edPassword.getText().toString();

                //Mengeset isi nama yang benar
                String email = "Fitri";

                //Mengeset password yang benar
                String pass = "1234";

                //Mengecek apakah edittext nama, email, password dan repass sudah terdapat isi atau tidak
                if (nama.length()==0) {
                    edEmail.setError("Nama harus ada");
                    //Membuat variabel toast dan menampilkan pesan "edittext tidak boleh kosong"
                    Toast.makeText(getApplicationContext(),"Data anda tidak boleh kosong",Toast.LENGTH_LONG).show();
                }else if (password.length()==0){
                    Toast.makeText(getApplicationContext(),"Password anda tidak boleh kosong",Toast.LENGTH_LONG).show();
                }
                else if (!nama.equals(email)){
                    Toast.makeText(getApplicationContext(),"Nama salah",Toast.LENGTH_LONG).show();
                }
                else if(!password.equals(pass)){
                    Toast.makeText(getApplicationContext(),"Nama salah",Toast.LENGTH_LONG).show();
                }
                else if (nama.equals(email) && password.equals(pass)) {
                    //Membuat variabel toast dan menampilkan pesan "login sukses"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Sukses",
                            Toast.LENGTH_LONG);
                    //Menampilkan toast
                    t.show();
                    Bundle bundle = new Bundle();
                    bundle.putString("x",nama.trim());
                    //Membuat objek intent berpindah activity dari mainactivity ke Halamanhasil
                    Intent i = new Intent(getApplicationContext(), Dashboard.class);
                    i.putExtras(bundle);
                    //berpindah ke ActivityHasil
                    startActivity(i);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Nama salah",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}