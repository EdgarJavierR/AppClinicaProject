package com.jquirogl.appclinicaproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jquirogl.appclinicaproject.DetalleThreeActivity;
import com.jquirogl.appclinicaproject.R;
import com.jquirogl.appclinicaproject.beans.FarmaciaBean;

import java.util.ArrayList;

public class MedicamentoAdapter extends RecyclerView.Adapter<MedicamentoAdapter.MedicamentoViewHolder> implements View.OnClickListener {

    ArrayList<FarmaciaBean> listaMedicamento;
    Context ctx;
    private View.OnClickListener listener;

    public MedicamentoAdapter(ArrayList<FarmaciaBean> listaMedicamento, Context ctx) {
        this.listaMedicamento = listaMedicamento;
        this.ctx = ctx;
    }

    @Override
    public MedicamentoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        v.setOnClickListener(this);
        MedicamentoViewHolder medicamentoViewHolder = new MedicamentoViewHolder(v, ctx, listaMedicamento);
        return medicamentoViewHolder;
    }

    @Override
    public void onBindViewHolder(MedicamentoViewHolder holder, int position) {
        holder.txtItem1.setText(listaMedicamento.get(position).getNombre_farma());
        holder.txtItem2.setText(listaMedicamento.get(position).getStock_farma().toString());
    }

    @Override
    public int getItemCount() {
        return listaMedicamento.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class MedicamentoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txtItem1, txtItem2;
        ArrayList<FarmaciaBean> lista = new ArrayList<>();
        Context ctx;

        public MedicamentoViewHolder(View itemView, Context ctx, ArrayList<FarmaciaBean> lista) {
            super(itemView);
            this.lista = lista;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            txtItem1 = (TextView) itemView.findViewById(R.id.txt_item_1);
            txtItem2 = (TextView) itemView.findViewById(R.id.txt_item_2);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            FarmaciaBean medicamento = this.lista.get(position);
            Intent intent = new Intent(this.ctx, DetalleThreeActivity.class);
            intent.putExtra("txtNom", medicamento.getNombre_farma());
            intent.putExtra("txtTip", medicamento.getTipo_farma());
            intent.putExtra("txtCan", medicamento.getStock_farma().toString());
            this.ctx.startActivity(intent);
        }
    }

}
