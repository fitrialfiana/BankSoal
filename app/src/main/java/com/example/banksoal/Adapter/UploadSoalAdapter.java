package com.example.banksoal.Adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.banksoal.App.AppController;
import com.example.banksoal.EditSoal;
import com.example.banksoal.UploadSoal;
import com.example.banksoal.R;
import com.example.banksoal.database.dbUpSoal;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class UploadSoalAdapter extends RecyclerView.Adapter<UploadSoalAdapter.TemanViewHolder> {
    private ArrayList<dbUpSoal> listData;

    public UploadSoalAdapter(ArrayList<dbUpSoal> listData) {
        this.listData = listData;
    }


    @Override
    public TemanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_data_upsoal,parent,false);
        return new TemanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TemanViewHolder holder, int position) {
        String id,sol, jwb;

        id = listData.get(position).getId();
        sol = listData.get(position).getSoal();
        jwb = listData.get(position).getJawaban();

        holder.soalTxt.setTextColor(Color.BLUE);
        holder.soalTxt.setTextSize(20);
        holder.soalTxt.setText(sol);
        holder.jawabanTxt.setText(jwb);

        holder.cardku.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                PopupMenu pm = new PopupMenu(v.getContext(), v);
                pm.inflate(R.menu.popup_soal);
                pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.editSoal:
                                Bundle bendel = new Bundle();
                                bendel.putString("kunci1", id);
                                bendel.putString("kunci2", sol);
                                bendel.putString("kunci3", jwb);

                                Intent inten = new Intent(v.getContext(), EditSoal.class);
                                inten.putExtras(bendel);
                                v.getContext().startActivity(inten);
                                break;
                            case R.id.hapusSoal:
                                AlertDialog.Builder alertdb = new AlertDialog.Builder(v.getContext());
                                alertdb.setTitle("Yakin akan dihapus?");
                                alertdb.setMessage("Tekan Ya untuk menghapus");
                                alertdb.setCancelable(false);
                                alertdb.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int which) {
                                        HapusData(id);
                                        Toast.makeText(v.getContext(), "Data " +id+ " telah dihapus", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(v.getContext(), UploadSoal.class);
                                        v.getContext().startActivity(intent);
                                    }
                                });

                                alertdb.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                                AlertDialog adlg = alertdb.create();
                                adlg.show();
                                break;
                        }
                        return true;
                    }
                });
                pm.show();
                return true;
            }
        });
    }

    private void HapusData(final String idx) {
        String url_update = "https://banksoalta.praktikumtiumy.com/deletetm.php";
        final String TAG = UploadSoal.class.getSimpleName();
        final String TAG_SUCCES = "success";
        final int[] sukses = new int[1];

        StringRequest stringReq = new StringRequest(Request.Method.POST, url_update, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "Respon: " + response.toString());

                try {
                    JSONObject jobj = new JSONObject(response);
                    sukses[0] = jobj.getInt(TAG_SUCCES);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Error : " + error.getMessage());
            }
        })
        {
            @Override
            protected Map<String,String> getParams()
            {
                Map<String,String> params = new HashMap<>();
                params.put("id", idx);
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(stringReq);
    }

    @Override
    public int getItemCount() {
        return (listData != null)?listData.size() : 0;
    }

    public class TemanViewHolder extends RecyclerView.ViewHolder {
        private CardView cardku;
        private TextView soalTxt, jawabanTxt;
        public TemanViewHolder(View view) {
            super(view);
            cardku =(CardView) view.findViewById(R.id.cardku);
            soalTxt =(TextView) view.findViewById(R.id.txtSoal);
            jawabanTxt =(TextView) view.findViewById(R.id.txtJwb);
        }
    }
}
