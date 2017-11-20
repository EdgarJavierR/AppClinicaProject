package com.jquirogl.appclinicaproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jquirogl.appclinicaproject.Menu.BottomNavigationViewHelper;

public class DetalleThreeActivity extends AppCompatActivity {

    TextView txtNom, txtTip, txtCan;
    Button btnAlarma;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_citas:
                    Intent intent = new Intent(DetalleThreeActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_servicios:
                    Intent intent2 = new Intent(DetalleThreeActivity.this, TwoActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_campana:
                    //Intent intent3 = new Intent(MedicamentoActivity.this, ThreeActivity.class);
                    //startActivity(intent3);
                    break;
                case R.id.navigation_contactanos:
                    Intent intent4 = new Intent(DetalleThreeActivity.this, FourActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.navigation_perfil:
                    Intent intent5 = new Intent(DetalleThreeActivity.this, FiveActivity.class);
                    startActivity(intent5);
                    break;
            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_three);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        txtNom = (TextView) findViewById(R.id.txt_nombre);
        txtTip = (TextView) findViewById(R.id.txt_tipo);
        txtCan = (TextView) findViewById(R.id.txt_cantidad);
        btnAlarma = (Button) findViewById(R.id.btnAlarma);

        txtNom.setText(getIntent().getStringExtra("txtNom"));
        txtTip.setText(getIntent().getStringExtra("txtTip"));
        txtCan.setText(getIntent().getStringExtra("txtCan"));

        btnAlarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidad = Integer.parseInt(txtCan.getText().toString());
                String nombre = String.valueOf(txtNom.getText());
                String tipo = String.valueOf(txtTip.getText());
                Intent intent = new Intent(DetalleThreeActivity.this, AlarmaActivity.class);
                intent.putExtra("cantidad",cantidad);
                intent.putExtra("nombre",nombre);
                intent.putExtra("tipo",tipo);

                startActivity(intent);
            }
        });

    }
}
