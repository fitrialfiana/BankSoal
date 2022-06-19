package com.example.banksoal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.example.banksoal.Adapter.UploadSoalAdapter;
import com.example.banksoal.database.dbUpSoal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class UploadSoal extends AppCompatActivity {
    private FloatingActionButton fab;
    private RecyclerView recyclerView;
    private UploadSoalAdapter adapter;
    private ArrayList<dbUpSoal> temanArrayList = new ArrayList<>();


    private static final String TAG = UploadSoal.class.getSimpleName();
    private static String url_select = "http://10.0.2.2/umyTI/bacateman.php";
    public static final String TAG_ID = "id";
    public static final String TAG_SOAL = "soal";
    public static final String TAG_JAWABAN = "jawaban";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_soal);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.floatingBtn);
        BacaData();
        adapter = new UploadSoalAdapter(temanArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(UploadSoal.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UploadSoal.this, tambahUpSoal.class);
                startActivity(intent);
            }
        });
    }

    public void BacaData()
    {
        temanArrayList.clear();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jArr = new JsonArrayRequest(url_select, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());

                //parsing json
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        dbUpSoal item = new dbUpSoal();
                        item.setId(obj.getString(TAG_ID));
                        item.setSoal(obj.getString(TAG_SOAL));
                        item.setJawaban(obj.getString(TAG_JAWABAN));

                        //menambah item ke array
                        temanArrayList.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                error.printStackTrace();
                Toast.makeText(UploadSoal.this,"gagal", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jArr);
    }

}