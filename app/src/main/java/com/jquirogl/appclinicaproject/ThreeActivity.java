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
import com.jquirogl.appclinicaproject.adapter.FarmaciaAdapter;
import com.jquirogl.appclinicaproject.adapter.MedicamentoAdapter;
import com.jquirogl.appclinicaproject.beans.FarmaciaBean;

import java.util.ArrayList;

public class ThreeActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_citas:
                    Intent intent = new Intent(ThreeActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_servicios:
                    Intent intent2 = new Intent(ThreeActivity.this, TwoActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_campana:
                    //Intent intent3 = new Intent(ThreeActivity.this, ThreeActivity.class);
                    //startActivity(intent3);
                    break;
                case R.id.navigation_contactanos:
                    Intent intent4 = new Intent(ThreeActivity.this, FourActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.navigation_perfil:
                    Intent intent5 = new Intent(ThreeActivity.this, FiveActivity.class);
                    startActivity(intent5);
                    break;
            }
            return false;
        }

    };

    ArrayList<FarmaciaBean> listaMedicamento = new ArrayList<>();
    RecyclerView recyclerView;
    MedicamentoAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_medicamentos);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        listadoMedicamento();

        adapter = new MedicamentoAdapter(listaMedicamento, this);
        recyclerView.setAdapter(adapter);

    }
    private void listadoMedicamento(){
        listaMedicamento.add(new FarmaciaBean(1,"Paracetamol 500mg","Pastillas","Laboratorios Peru",50,5.0));
        listaMedicamento.add(new FarmaciaBean(2,"Aspirina 500mg","Pastillas","Bayer",10,3.0));
        listaMedicamento.add(new FarmaciaBean(3,"Ibuprofeno 500mg","Pastillas","Laboratorios Peru",20,2.0));
        listaMedicamento.add(new FarmaciaBean(4,"Apronax 500mg","Pastillas","Bayer",50,6.0));
        listaMedicamento.add(new FarmaciaBean(5,"Amoxicilina 500mg","Pastillas","PME",40,6.0));
        listaMedicamento.add(new FarmaciaBean(6,"Paltomiel","Jarabe","MEDCO",50,5.0));
    }
}
