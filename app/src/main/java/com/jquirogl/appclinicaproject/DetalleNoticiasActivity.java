package com.jquirogl.appclinicaproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.jquirogl.appclinicaproject.Menu.BottomNavigationViewHelper;
import com.jquirogl.appclinicaproject.R;

public class DetalleNoticiasActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_citas:
                    //Intent intent = new Intent(DetalleNoticiasActivity.this, MainActivity.class);
                    //startActivity(intent);
                    break;
                case R.id.navigation_servicios:
                    Intent intent2 = new Intent(DetalleNoticiasActivity.this, TwoActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_campana:
                    Intent intent3 = new Intent(DetalleNoticiasActivity.this, ThreeActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.navigation_contactanos:
                    Intent intent4 = new Intent(DetalleNoticiasActivity.this, FourActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.navigation_perfil:
                    Intent intent5 = new Intent(DetalleNoticiasActivity.this, FiveActivity.class);
                    startActivity(intent5);
                    break;
            }
            return false;
        }

    };

    ImageView imgFotoN;
    TextView txtFechaN, txtHoraN, txtTituloN, txtConteN, txtUbicaN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_noticias);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        imgFotoN = (ImageView) findViewById(R.id.img_foto_n);
        txtFechaN = (TextView) findViewById(R.id.txt_fecha_n);
        txtHoraN = (TextView) findViewById(R.id.txt_hora_n);
        txtTituloN = (TextView) findViewById(R.id.txt_titulo_n);
        txtConteN = (TextView) findViewById(R.id.txt_conte_n);
        txtUbicaN = (TextView) findViewById(R.id.txt_ubica_n);

        int resID = getResources().getIdentifier(getIntent().getStringExtra("imgFotoN"), "drawable", getPackageName());

        imgFotoN.setImageResource(resID);
        txtFechaN.setText(getIntent().getStringExtra("txtFechaN"));
        txtHoraN.setText(getIntent().getStringExtra("txtHoraN"));
        txtTituloN.setText(getIntent().getStringExtra("txtTituloN"));
        txtConteN.setText(getIntent().getStringExtra("txtConteN"));
        txtUbicaN.setText("Ubicación: " + getIntent().getStringExtra("txtUbicaN"));

    }
}
