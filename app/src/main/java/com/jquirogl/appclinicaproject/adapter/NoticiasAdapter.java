package com.jquirogl.appclinicaproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jquirogl.appclinicaproject.DetalleNoticiasActivity;
import com.jquirogl.appclinicaproject.R;
import com.jquirogl.appclinicaproject.beans.NoticiasBean;

import java.util.ArrayList;

/**
 * Created by INTEL on 18/11/2017.
 */

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.NoticiasViewHolder> implements View.OnClickListener {

    ArrayList<NoticiasBean> listaNoticias;
    Context ctx;
    private View.OnClickListener listener;
    AppCompatActivity appCompatActivity = new AppCompatActivity();


    public NoticiasAdapter(ArrayList<NoticiasBean> listaNoticias, Context ctx) {
        this.listaNoticias = listaNoticias;
        this.ctx = ctx;
    }

    @Override
    public NoticiasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_n, null, false);
        v.setOnClickListener(this);
        NoticiasViewHolder noticiasViewHolder = new NoticiasViewHolder(v, ctx, listaNoticias);
        return noticiasViewHolder;
    }

    @Override
    public void onBindViewHolder(NoticiasViewHolder holder, int position) {
        int[] resId = {R.drawable.n01, R.drawable.n02,R.drawable.n03, R.drawable.n04,R.drawable.n05, R.drawable.n06,R.drawable.n07, R.drawable.n08,R.drawable.n09, R.drawable.n10};

        holder.imgFoto.setImageResource(resId[position]);
        holder.txtItemN1.setText(listaNoticias.get(position).getFecha_noti());
        holder.txtItemN2.setText(listaNoticias.get(position).getContenido_noti());
    }

    @Override
    public int getItemCount() {
        return listaNoticias.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class NoticiasViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imgFoto;
        TextView txtItemN1, txtItemN2;
        ArrayList<NoticiasBean> lista = new ArrayList<>();
        Context ctx;

        public NoticiasViewHolder(View itemView, Context ctx, ArrayList<NoticiasBean> lista) {
            super(itemView);
            this.lista = lista;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            imgFoto = (ImageView) itemView.findViewById(R.id.img_foto_n);
            txtItemN1 = (TextView) itemView.findViewById(R.id.txt_item_n1);
            txtItemN2 = (TextView) itemView.findViewById(R.id.txt_item_n2);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            NoticiasBean noticias = this.lista.get(position);
            Intent intent = new Intent(this.ctx, DetalleNoticiasActivity.class);
            intent.putExtra("imgFotoN", noticias.getFoto_noti());
            intent.putExtra("txtConteN", noticias.getContenido_noti());
            intent.putExtra("txtFechaN", noticias.getFecha_noti());
            intent.putExtra("txtHoraN", noticias.getHora_noti());
            intent.putExtra("txtUbicaN", noticias.getUbica_noti());
            this.ctx.startActivity(intent);
        }
    }

}
