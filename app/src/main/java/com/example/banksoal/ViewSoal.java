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

import com.example.banksoal.Adapter.TampilSoalAdapter;
import com.example.banksoal.database.dbTampilSoal;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class ViewSoal extends AppCompatActivity {

    private FloatingActionButton fab2;
    private RecyclerView recyclerView2;
    private TampilSoalAdapter adapterr;
    private ArrayList<dbTampilSoal> teman2ArrayList = new ArrayList<>();


    private static final String TAG = ViewSoal.class.getSimpleName();
    private static String url_select = "http://10.0.2.2/umyTI/bacasoal.php";
    public static final String TAG_ID = "id";
    public static final String TAG_DATA = "data";
    public static final String TAG_JAWAB = "jawab";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_soal);

        recyclerView2 = findViewById(R.id.recyclerView2);
        fab2 = findViewById(R.id.floatBtn);
        BacaData();
        adapterr = new TampilSoalAdapter(teman2ArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ViewSoal.this);
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView2.setAdapter(adapterr);

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewSoal.this, TambahView.class);
                startActivity(intent);
            }
        });

    }


    public void BacaData()
    {
        teman2ArrayList.clear();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jArr = new JsonArrayRequest(url_select, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());

                //parsing json
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        dbTampilSoal item = new dbTampilSoal();
                        item.setIdd(obj.getString(TAG_ID));
                        item.setData(obj.getString(TAG_DATA));
                        item.setJawab(obj.getString(TAG_JAWAB));

                        //menambah item ke array
                        teman2ArrayList.add(item);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                error.printStackTrace();
                Toast.makeText(ViewSoal.this,"gagal", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jArr);
    }
}