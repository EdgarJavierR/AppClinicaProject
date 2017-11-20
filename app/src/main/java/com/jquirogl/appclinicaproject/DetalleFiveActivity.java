package com.jquirogl.appclinicaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.jquirogl.appclinicaproject.Menu.BottomNavigationViewHelper;

public class DetalleFiveActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_citas:
                    Intent intent = new Intent(DetalleFiveActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_servicios:
                    Intent intent2 = new Intent(DetalleFiveActivity.this, TwoActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_campana:
                    Intent intent3 = new Intent(DetalleFiveActivity.this, ThreeActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.navigation_contactanos:
                    Intent intent4 = new Intent(DetalleFiveActivity.this, FourActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.navigation_perfil:
                    //Intent intent5 = new Intent(FiveActivity.this, FiveActivity.class);
                    //startActivity(intent5);
                    break;
            }
            return false;
        }

    };


    TextView txtNom, txtTip, txtLab ,txtSto, txtPre;
    ImageView imgFarma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_five);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        imgFarma = (ImageView) findViewById(R.id.img_foto);
        txtNom = (TextView) findViewById(R.id.txt_nombre);
        txtTip = (TextView) findViewById(R.id.txt_tipo);
        txtLab = (TextView) findViewById(R.id.txt_labo);
        txtSto = (TextView) findViewById(R.id.txt_stock);
        txtPre = (TextView) findViewById(R.id.txt_precio);

        String drawableName = "f" + getIntent().getIntExtra("imgFoto", 00);

        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());

        imgFarma.setImageResource(resID);
        txtNom.setText(getIntent().getStringExtra("txtNom"));
        txtTip.setText(getIntent().getStringExtra("txtTip"));
        txtLab.setText("Laboratorio: " + getIntent().getStringExtra("txtLab"));
        txtSto.setText("Stock: " + getIntent().getStringExtra("txtSto"));
        txtPre.setText("Precio: S/ " + getIntent().getStringExtra("txtPre"));

    }
}
