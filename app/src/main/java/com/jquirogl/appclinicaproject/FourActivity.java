package com.jquirogl.appclinicaproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jquirogl.appclinicaproject.Menu.BottomNavigationViewHelper;
import com.jquirogl.appclinicaproject.adapter.HistorialAdapter;
import com.jquirogl.appclinicaproject.beans.HistorialBean;

import java.util.ArrayList;

public class FourActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_citas:
                    Intent intent = new Intent(FourActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_servicios:
                    Intent intent2 = new Intent(FourActivity.this, TwoActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_campana:
                    Intent intent3 = new Intent(FourActivity.this, ThreeActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.navigation_contactanos:
                    //Intent intent4 = new Intent(FourActivity.this, FourActivity.class);
                    //startActivity(intent4);
                    break;
                case R.id.navigation_perfil:
                    Intent intent5 = new Intent(FourActivity.this, FiveActivity.class);
                    startActivity(intent5);
                    break;
            }
            return false;
        }

    };

    ArrayList<HistorialBean> listaHistorial = new ArrayList<>();
    RecyclerView recyclerView;
    HistorialAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_four);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        listadoHistorial();

        adapter = new HistorialAdapter(listaHistorial, this);
        recyclerView.setAdapter(adapter);

    }
    private void listadoHistorial(){
        listaHistorial.add(new HistorialBean(1,"Emergencia","24/10/2017","Carlos Vega","Curacion de dos dientes molares y limpieza profunda de toda la dentadura",160.10,132225,"Visa"));
        listaHistorial.add(new HistorialBean(2,"Odontologia","20/09/2017","Edgar Javier","Curacion de dos dientes molares y limpieza profunda de toda la dentadura",200.10,612331,"Efectivo"));
        listaHistorial.add(new HistorialBean(3,"Emergencia","15/08/2016","Jamer Quiroga","Curacion de dos dientes molares y limpieza profunda de toda la dentadura",100.00,768906,"Efectivo"));
        listaHistorial.add(new HistorialBean(4,"Pediatria","12/07/2016","Steven Cachillo","Curacion de dos dientes molares y limpieza profunda de toda la dentadura",150.30,672340,"Visa"));
        listaHistorial.add(new HistorialBean(5,"Cirujia","02/07/2016","Edgar Javier","Curacion de dos dientes molares y limpieza profunda de toda la dentadura",140.20,987432,"Visa"));
        listaHistorial.add(new HistorialBean(6,"Emergencia","06/05/2016","Jamer Quiroga","Curacion de dos dientes molares y limpieza profunda de toda la dentadura",4000.90,143532,"Amex"));
        listaHistorial.add(new HistorialBean(7,"Prenatologia","24/07/2012","Steven Cachillo","Curacion de dos dientes molares y limpieza profunda de toda la dentadura",1000.10,111111,"Visa"));
        listaHistorial.add(new HistorialBean(8,"Emergencia","07/11/2012","Carlos Vega","Curacion de dos dientes molares y limpieza profunda de toda la dentadura",200.10,222222,"Visa"));
        listaHistorial.add(new HistorialBean(9,"Prenatal","24/10/2012","Carlos Vega","Curacion de dos dientes molares y limpieza profunda de toda la dentadura",400.10,945788,"Mastercard"));

    }
}
