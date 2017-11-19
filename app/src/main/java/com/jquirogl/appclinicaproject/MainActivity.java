package com.jquirogl.appclinicaproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.jquirogl.appclinicaproject.Menu.BottomNavigationViewHelper;
import com.jquirogl.appclinicaproject.adapter.NoticiasAdapter;
import com.jquirogl.appclinicaproject.beans.NoticiasBean;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_citas:
                    //Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    //startActivity(intent);
                    break;
                case R.id.navigation_servicios:
                    Intent intent2 = new Intent(MainActivity.this, TwoActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.navigation_campana:
                    Intent intent3 = new Intent(MainActivity.this, ThreeActivity.class);
                    startActivity(intent3);
                    break;
                case R.id.navigation_contactanos:
                    Intent intent4 = new Intent(MainActivity.this, FourActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.navigation_perfil:
                    Intent intent5 = new Intent(MainActivity.this, FiveActivity.class);
                    startActivity(intent5);
                    break;
            }
            return false;
        }

    };

    ArrayList<NoticiasBean> listaNoticias = new ArrayList<>();
    RecyclerView recyclerView;
    NoticiasAdapter adapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);
        Menu menu = navigation.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_noti);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        listadoNoticias();

        adapter = new NoticiasAdapter(listaNoticias, this);
        recyclerView.setAdapter(adapter);
    }

    private void listadoNoticias() {
        listaNoticias.add(new NoticiasBean(1,"Promoción Pediatria: Solo hoy, cita a S/20 por paciente","n01","20/04/2017","09:00am","Sede Principal"));
        listaNoticias.add(new NoticiasBean(2,"Promoción en Ecografias: Descuentos hasta 40% solo hoy","n02","25/08/2017","08:00pm","Sede Principal"));
        listaNoticias.add(new NoticiasBean(3,"Consulta de Otorrino, nueva especialidad. Ofrecida por la Dra. Garcia","n03","14/09/2017","10:00am","Sede Anexo 1"));
        listaNoticias.add(new NoticiasBean(4,"Promocion Resonancia Magnetica, Precio Preferenciales desde S/499","n04","20/04/2017","01:00pm","Sede Principal"));
        listaNoticias.add(new NoticiasBean(5,"Promocion Oftamologia, cirugias desde S/900 para todos nuestros afiliados","n05","20/04/2017","12:00pm","Sede Anexo 1"));
        listaNoticias.add(new NoticiasBean(6,"Campaña de Despitaje de Cancer de Mama. GRATUITO","n06","20/04/2017","02:00pm","Sede Principal"));
        listaNoticias.add(new NoticiasBean(7,"Plan Pre-natal: Charlas para llevar un embarazo feliz, por el Dr. Perez. Entrada Libre","n07","20/04/2017","10:00am","Sede Anexo 2"));
        listaNoticias.add(new NoticiasBean(8,"Charla nutricional sobre la alimentación en la menopausia, Entrada LIBRE","n08","21/08/2017","10:00am","Sede Principal"));
        listaNoticias.add(new NoticiasBean(9,"Nuevo Programa de Adulto Mayor: Consulta con descuento de hasta 50%","n09","20/04/2017","11:001m","Sede Anexo 2"));
        listaNoticias.add(new NoticiasBean(10,"Mejoras en Emergencias: Se habilitó un area exclusivo para las emergencias pedriaticas","n10" ,"30/05/2017","10:00am","Sede Principal"));
    }


}
