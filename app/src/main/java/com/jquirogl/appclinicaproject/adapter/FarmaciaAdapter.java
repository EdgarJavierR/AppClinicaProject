package com.jquirogl.appclinicaproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jquirogl.appclinicaproject.DetalleFiveActivity;
import com.jquirogl.appclinicaproject.R;
import com.jquirogl.appclinicaproject.beans.FarmaciaBean;

import java.util.ArrayList;

/**
 * Created by INTEL on 12/11/2017.
 */

public class FarmaciaAdapter extends RecyclerView.Adapter<FarmaciaAdapter.FarmaciaViewHolder> implements View.OnClickListener {

    ArrayList<FarmaciaBean> listaFarmacia;
    Context ctx;
    private View.OnClickListener listener;

    public FarmaciaAdapter(ArrayList<FarmaciaBean> listaFarmacia, Context ctx) {
        this.listaFarmacia = listaFarmacia;
        this.ctx = ctx;
    }

    @Override
    public FarmaciaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        v.setOnClickListener(this);
        FarmaciaViewHolder farmaciaViewHolder = new FarmaciaViewHolder(v, ctx, listaFarmacia);
        return farmaciaViewHolder;
    }

    @Override
    public void onBindViewHolder(FarmaciaViewHolder holder, int position) {
        android.content.res.Resources getResources = null;
        android.support.v7.app.AppCompatActivity app = new AppCompatActivity();

        holder.txtItem1.setText(listaFarmacia.get(position).getNombre_farma());
        holder.txtItem2.setText("S/ " + listaFarmacia.get(position).getPrecio_farma().toString());
        Integer dispo = listaFarmacia.get(position).getStock_farma();
        holder.txtItem3.setText(listaFarmacia.get(position).getDisponibilidad(dispo));

        if (listaFarmacia.get(position).getStock_farma() > 25)  holder.imgSto.setImageResource(R.drawable.estrella);
        else holder.imgSto.setImageResource(0);
    }

    @Override
    public int getItemCount() {
        return listaFarmacia.size();
    }

    @Override
    public void onClick(View v) {

    }

    public void setFiltroFarmacio(ArrayList<FarmaciaBean> lista)  {
        listaFarmacia  = new ArrayList<>();
        listaFarmacia.addAll(lista);
        notifyDataSetChanged();
    }

    public class FarmaciaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imgSto;
        TextView txtItem1, txtItem2, txtItem3;
        ArrayList<FarmaciaBean> lista = new ArrayList<>();
        Context ctx;

        public FarmaciaViewHolder(View itemView, Context ctx, ArrayList<FarmaciaBean> lista) {
            super(itemView);
            this.lista = lista;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            imgSto = (ImageView) itemView.findViewById(R.id.img_sto);
            txtItem1 = (TextView) itemView.findViewById(R.id.txt_item_1);
            txtItem2 = (TextView) itemView.findViewById(R.id.txt_item_2);
            txtItem3 = (TextView) itemView.findViewById(R.id.txt_item_3);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            FarmaciaBean farmacia = this.lista.get(position);
            Intent intent = new Intent(this.ctx, DetalleFiveActivity.class);
            intent.putExtra("imgFoto", farmacia.getCodigo_farma());
            intent.putExtra("txtNom", farmacia.getNombre_farma());
            intent.putExtra("txtTip", farmacia.getTipo_farma());
            intent.putExtra("txtLab", farmacia.getLabo_farma());
            intent.putExtra("txtSto", farmacia.getStock_farma().toString());
            intent.putExtra("txtPre", farmacia.getPrecio_farma().toString());
            this.ctx.startActivity(intent);
        }
    }


}
