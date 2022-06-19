package com.example.banksoal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TambahView extends AppCompatActivity {

    private EditText editData, editJawab;
    private Button simpanBtn;
    String dt, jw;
    int success;

    private static String url_insert = "https://banksoalta.praktikumtiumy.com/tambahsoal.php";
    private static final String TAG = TambahView.class.getSimpleName();
    private static final String TAG_SUCCES = "success";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_view);

        editData = findViewById(R.id.edData);
        editJawab = findViewById(R.id.edJawab);
        simpanBtn = findViewById(R.id.btnSave);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpanData();
            }
        });
    }

    public void SimpanData()
    {
        if (editData.getText().toString().equals("") || editJawab.getText().toString().equals("")) {
            Toast.makeText(TambahView.this,"Harus mengisi kolom untuk menambah soal", Toast.LENGTH_SHORT).show();
        }
        else
        {
            dt = editData.getText().toString();
            jw = editJawab.getText().toString();

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest strReq = new StringRequest(Request.Method.POST, url_insert, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d(TAG, "Response : " + response.toString());
                    try {
                        JSONObject jObj = new JSONObject(response);
                        success = jObj.getInt(TAG_SUCCES);
                        if (success == 1) {
                            Toast.makeText(TambahView.this, "Berhasil menambah soal", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(TambahView.this, "gagal", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }}
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG,"Error : "+error.getMessage());
                    Toast.makeText(TambahView.this,"Gagal menambah soal",Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String,String> getParams() {
                    Map<String,String> params = new HashMap<>();
                    params.put("data",dt);
                    params.put("jawab",jw);

                    return params;
                }
            };
            requestQueue.add(strReq);
        }
    }
}