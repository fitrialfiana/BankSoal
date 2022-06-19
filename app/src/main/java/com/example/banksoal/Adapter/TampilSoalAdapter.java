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
import com.example.banksoal.R;
import com.example.banksoal.ViewSoal;
import com.example.banksoal.database.dbTampilSoal;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TampilSoalAdapter extends RecyclerView.Adapter<TampilSoalAdapter.TemanViewHolder> {
    private ArrayList<dbTampilSoal> listData;

    public TampilSoalAdapter(ArrayList<dbTampilSoal> listData) {
        this.listData = listData;
    }

    @Override
    public TemanViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInf = LayoutInflater.from(parent.getContext());
        View view = layoutInf.inflate(R.layout.row_list_soal,parent,false);
        return new TemanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TemanViewHolder holder, int position) {
        String id,dt,jw;

        id = listData.get(position).getIdd();
        dt = listData.get(position).getData();
        jw = listData.get(position).getJawab();

        holder.dataTxt.setTextColor(Color.BLUE);
        holder.dataTxt.setTextSize(10);
        holder.dataTxt.setText(dt);
        holder.jawabTxt.setText(jw);

        holder.cardmu.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
    }


    @Override
    public int getItemCount() {
        return (listData != null)?listData.size() : 0;
    }

    public class TemanViewHolder extends RecyclerView.ViewHolder {
        private CardView cardmu;
        private TextView dataTxt, jawabTxt;
        public TemanViewHolder(View view) {
            super(view);
            cardmu =(CardView) view.findViewById(R.id.kartumu);
            dataTxt =(TextView) view.findViewById(R.id.textData);
            jawabTxt =(TextView) view.findViewById(R.id.textAns);
        }
    }
}