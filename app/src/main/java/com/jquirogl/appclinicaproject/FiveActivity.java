package com.jquirogl.appclinicaproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MenuCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jquirogl.appclinicaproject.Menu.BottomNavigationViewHelper;
import com.jquirogl.appclinicaproject.adapter.FarmaciaAdapter;
import com.jquirogl.appclinicaproject.beans.FarmaciaBean;

import java.util.ArrayList;

public class FiveActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_citas:
                    Intent intent = new Intent(FiveActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case R.id.navigation_servicios:
                    Intent intent2 = new Intent(FiveActivity.this, TwoActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_campana:
                    Intent intent3 = new Intent(FiveActivity.this, ThreeActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.navigation_contactanos:
                    Intent intent4 = new Intent(FiveActivity.this, FourActivity.class);
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


    ArrayList<FarmaciaBean> listaFarmacia = new ArrayList<>();
    ArrayList<FarmaciaBean> nuevaLista = new ArrayList<>();
    RecyclerView recyclerView;
    FarmaciaAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(4);
        menuItem.setChecked(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_far);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        listadoFarmacia();

        adapter = new FarmaciaAdapter(listaFarmacia, this);
        recyclerView.setAdapter(adapter);

    }

    private void listadoFarmacia(){
        listaFarmacia.add(new FarmaciaBean(1,"Paracetamol 500mg","Pastillas",50,5.0));
        listaFarmacia.add(new FarmaciaBean(2,"Aspirina 500mg","Pastillas",10,3.0));
        listaFarmacia.add(new FarmaciaBean(3,"Ibuprofeno 500mg","Pastillas",20,2.0));
        listaFarmacia.add(new FarmaciaBean(4,"Apronax 500mg","Pastillas",50,6.0));
        listaFarmacia.add(new FarmaciaBean(5,"Amoxicilina 500mg","Pastillas",40,6.0));
        listaFarmacia.add(new FarmaciaBean(6,"Paltomiel","Jarabe",50,5.0));
        listaFarmacia.add(new FarmaciaBean(7,"Aspirina FORTE","Pastillas",10,3.0));
        listaFarmacia.add(new FarmaciaBean(8,"Ibuprofeno 500mg","Pastillas",20,2.0));
        listaFarmacia.add(new FarmaciaBean(9,"Dalsy","Jarabe",50,6.0));
        listaFarmacia.add(new FarmaciaBean(10,"Dexametasona 500mg","Pastillas",40,6.0));
        listaFarmacia.add(new FarmaciaBean(11,"Ampicilina 1m","Inyectable",50,5.0));
        listaFarmacia.add(new FarmaciaBean(12,"Bismutol","Pastillas",10,3.0));
        listaFarmacia.add(new FarmaciaBean(13,"Bismutol","Jarabe",20,2.0));
        listaFarmacia.add(new FarmaciaBean(14,"Viagra 25mg","Pastillas",50,6.0));
        listaFarmacia.add(new FarmaciaBean(15,"Panadol 500mg","Pastillas",40,6.0));
        listaFarmacia.add(new FarmaciaBean(16,"Abrilar","Jarabe",50,5.0));
        listaFarmacia.add(new FarmaciaBean(17,"Tioctan Plus 500mg","Pastillas",10,3.0));
        listaFarmacia.add(new FarmaciaBean(18,"Ibuprofeno","Jarabe",20,2.0));
        listaFarmacia.add(new FarmaciaBean(19,"Gripadex","Jarabe",50,6.0));
        listaFarmacia.add(new FarmaciaBean(20,"Doloflam 100mg","Pastillas",40,6.0));
        listaFarmacia.add(new FarmaciaBean(21,"Tempra","Inyectable",50,5.0));
        listaFarmacia.add(new FarmaciaBean(22,"Kitadol","Jarabe",10,3.0));
        listaFarmacia.add(new FarmaciaBean(23,"Panadol Niños","Jarabe",20,2.0));
        listaFarmacia.add(new FarmaciaBean(24,"Sinutab","Pastillas",50,6.0));
        listaFarmacia.add(new FarmaciaBean(25,"Amidol","Jarabe",40,6.0));
        listaFarmacia.add(new FarmaciaBean(26,"Paracetamol","Jarabe",50,5.0));
        listaFarmacia.add(new FarmaciaBean(27,"Formula 44","Jarabe",10,3.0));
        listaFarmacia.add(new FarmaciaBean(28,"Penicilina 500mg","Inyectable",20,2.0));
        listaFarmacia.add(new FarmaciaBean(29,"Sinachis","Pastillas",50,6.0));
        listaFarmacia.add(new FarmaciaBean(30,"Hepabionta","Pastillas",40,6.0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_buscar, menu);
        MenuItem menuItem = menu.findItem(R.id.action_buscar);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText = newText.toLowerCase();
        nuevaLista = new ArrayList<>();
        for (FarmaciaBean farmacia : listaFarmacia) {
            String nombre = farmacia.getNombre_farma().toLowerCase();
            if(nombre.contains(newText)) {
                nuevaLista.add(farmacia);
            }
        }
        adapter.setFiltroFarmacio(nuevaLista);
        return true;
    }
}