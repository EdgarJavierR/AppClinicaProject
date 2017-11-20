package com.jquirogl.appclinicaproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jquirogl.appclinicaproject.DetalleNumeroActivity;
import com.jquirogl.appclinicaproject.R;
import com.jquirogl.appclinicaproject.beans.HistorialBean;

import java.util.ArrayList;

/**
 * Created by cayomt56 on 11/19/2017.
 */

public class HistorialAdapter extends RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder> implements View.OnClickListener {

    ArrayList<HistorialBean> listaHistorial;
    Context ctx;
    private View.OnClickListener listener;

    public HistorialAdapter(ArrayList<HistorialBean> listaHistorial, Context ctx) {
        this.listaHistorial = listaHistorial;
        this.ctx = ctx;
    }

    @Override
    public HistorialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_historial, null, false);
        v.setOnClickListener(this);
        HistorialViewHolder HistorialViewHolder = new HistorialViewHolder(v, ctx, listaHistorial);
        return HistorialViewHolder;
    }

    @Override
    public void onBindViewHolder(HistorialViewHolder holder, int position) {
        holder.txtItem1.setText(listaHistorial.get(position).getNombre_historial());
        holder.txtItem2.setText(listaHistorial.get(position).getFecha_historial());

    }

    @Override
    public int getItemCount() {
        return listaHistorial.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class HistorialViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtItem1, txtItem2,txtItem3;
        ArrayList<HistorialBean> lista = new ArrayList<>();
        Context ctx;

        public HistorialViewHolder(View itemView, Context ctx, ArrayList<HistorialBean> lista) {
            super(itemView);
            this.lista = lista;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            txtItem1 = (TextView) itemView.findViewById(R.id.tvDescripcion);
            txtItem2 = (TextView) itemView.findViewById(R.id.tvFecha);
            txtItem3 = (TextView) itemView.findViewById(R.id.tvFijo);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            HistorialBean Historial = this.lista.get(position);
            Intent intent = new Intent(this.ctx, DetalleNumeroActivity.class);
            intent.putExtra("nombreHistorial", Historial.getNombre_historial());
            intent.putExtra("fechaHistorial", Historial.getFecha_historial());
            intent.putExtra("costoHistorial", Historial.getCosto_historial());
            intent.putExtra("metodoPago", Historial.getMetodo_pago());
            intent.putExtra("nombreDoctor", Historial.getNombre_doctor());
            intent.putExtra("numeroBoleta", Historial.getNumero_boleta());
            intent.putExtra("resumenHistorial", Historial.getResumen_historial());
            this.ctx.startActivity(intent);
        }
    }

}



