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

public class tambahUpSoal extends AppCompatActivity {
    private EditText editQuest, editAnswer;
    private Button simpanBtn;
    String Quest, Answer;
    int success;

    private static String url_insert = "http://10.0.2.2/umyTI/tambahtm.php";
    private static final String TAG = tambahUpSoal.class.getSimpleName();
    private static final String TAG_SUCCES = "success";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_up_soal);
        editQuest = findViewById(R.id.edSoal);
        editAnswer = findViewById(R.id.edJawaban);
        simpanBtn = findViewById(R.id.btnSimpan);

        simpanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpanData();
                Intent inten = new Intent(getApplicationContext(), UploadSoal.class);
                startActivity(inten);
                finish();
            }
        });
    }
    public void SimpanData()
    {
        if (editQuest.getText().toString().equals("") || editAnswer.getText().toString().equals("")) {
            Toast.makeText(tambahUpSoal.this,"Semua harus diisi data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Quest = editQuest.getText().toString();
            Answer = editAnswer.getText().toString();

            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest strReq = new StringRequest(Request.Method.POST, url_insert, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d(TAG, "Response : " + response.toString());
                    try {
                        JSONObject jObj = new JSONObject(response);
                        success = jObj.getInt(TAG_SUCCES);
                        if (success == 1) {
                            Toast.makeText(tambahUpSoal.this, "Sukses simpan data", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(tambahUpSoal.this, "gagal", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }}
            },new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG,"Error : "+error.getMessage());
                    Toast.makeText(tambahUpSoal.this,"Gagal simpan data",Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String,String> getParams() {
                    Map<String,String> params = new HashMap<>();
                    params.put("soal",Quest);
                    params.put("jawaban",Answer);

                    return params;
                }
            };
            requestQueue.add(strReq);
        }
    }
}
