package com.jquirogl.appclinicaproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetalleNumeroActivity extends AppCompatActivity {

    TextView tvNombreHistorial,
            tvFechaHistorial,
            tvNombreDoctor,
            tvResumenAtencion,
            tvCostoTotal,
            tvNumeroBoleta,
            tvMetodoPago;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_numero);

        tvNombreHistorial = (TextView) findViewById(R.id.tvNombreHistorial);
        tvFechaHistorial = (TextView) findViewById(R.id.tvFechaHistorial);
        tvNombreDoctor = (TextView) findViewById(R.id.tvNombreDoctor);
        tvResumenAtencion = (TextView) findViewById(R.id.tvResumenAtencion);
        tvCostoTotal = (TextView) findViewById(R.id.tvCostoTotal);
        tvNumeroBoleta = (TextView) findViewById(R.id.tvNumeroBoleta);
        tvMetodoPago = (TextView) findViewById(R.id.tvMetodoPago);



        tvNombreHistorial.setText(getIntent().getStringExtra("nombreHistorial"));
        tvFechaHistorial.setText(getIntent().getStringExtra("fechaHistorial"));
        tvNombreDoctor.setText(getIntent().getStringExtra("nombreDoctor"));
        tvResumenAtencion.setText(getIntent().getStringExtra("resumenAtencion"));
        tvCostoTotal.setText(String.valueOf(getIntent().getDoubleExtra("costoHistorial",0)));
        tvNumeroBoleta.setText(String.valueOf(getIntent().getIntExtra("numeroBoleta",0)));
        tvMetodoPago.setText(getIntent().getStringExtra("metodoPago"));
    }
}
