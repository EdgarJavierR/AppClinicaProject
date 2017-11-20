package com.jquirogl.appclinicaproject;

import android.annotation.TargetApi;
import android.app.TimePickerDialog;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.jquirogl.appclinicaproject.alarma.AlarmReceiver;
import com.jquirogl.appclinicaproject.alarma.LocalData;
import com.jquirogl.appclinicaproject.alarma.NotificationScheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AlarmaActivity extends AppCompatActivity {

    String TAG = "Recordar medicamento";
    LocalData localData;

    SwitchCompat reminderSwitch;
    TextView tvTime, tvTimeRepetir, tvNombre, tvDosis;

    LinearLayout ll_set_time, ll_terms, ll_set_time_repetir;

    Intent intent2 = new Intent();

    int hour, min;

    ClipboardManager myClipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_alarma);



        localData = new LocalData(getApplicationContext());

        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        ll_set_time = (LinearLayout) findViewById(R.id.ll_set_time);
        ll_terms = (LinearLayout) findViewById(R.id.ll_terms);

        tvTime = (TextView) findViewById(R.id.tv_reminder_time_desc);

        reminderSwitch = (SwitchCompat) findViewById(R.id.timerSwitch);

        hour = localData.get_hour();
        min = localData.get_min();

        tvTime.setText(getFormatedTime(hour, min));
        reminderSwitch.setChecked(localData.getReminderStatus());

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvDosis = (TextView) findViewById(R.id.tvDosis);

        if (getIntent().getStringExtra("nombre") == null){
            tvNombre.setText("arreglarclicknotificacion");
            tvDosis.setText("arreglarclicknotificacion");
        }else {

            tvNombre.setText(getIntent().getStringExtra("nombre"));
            tvDosis.setText(getIntent().getStringExtra("tipo").concat(" ").concat(String.valueOf(getIntent().getIntExtra("cantidad", 1))));

        }



        tvTimeRepetir = (TextView) findViewById(R.id.tv_reminder_time_desc_repetir);
        ll_set_time_repetir = (LinearLayout) findViewById(R.id.ll_set_time_repetir);


        //obtenemos estado de la alarma(activado o desactivado)
        if (!localData.getReminderStatus())
            ll_set_time.setAlpha(0.4f);

        reminderSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                localData.setReminderStatus(isChecked);
                //si es verdadero>habilitamos
                if (isChecked) {
                    Log.d(TAG, "onCheckedChanged: true");
                    final int horasRepetir = Integer.parseInt(tvTimeRepetir.getText().toString());
                    final String nombre = (String) tvNombre.getText();
                    final String dosis = (String) tvDosis.getText();
                    intent2.putExtra("horasRepetir", horasRepetir);
                    intent2.putExtra("nombre", nombre);
                    intent2.putExtra("dosis", dosis);
                    NotificationScheduler.setReminder(AlarmaActivity.this, AlarmReceiver.class, localData.get_hour(), localData.get_min(),intent2);
                    ll_set_time.setAlpha(1f);
                    ll_set_time_repetir.setAlpha(1f);
                    //sino, desactivamos
                } else {
                    Log.d(TAG, "onCheckedChanged: false");
                    NotificationScheduler.cancelReminder(AlarmaActivity.this, AlarmReceiver.class);
                    ll_set_time.setAlpha(0.4f);
                    ll_set_time_repetir.setAlpha(0.4f);
                }

            }
        });

        ll_set_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (localData.getReminderStatus())
                    showTimePickerDialog(localData.get_hour(), localData.get_min());
            }
        });

        ll_terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }


    private void showTimePickerDialog(int h, int m) {

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.timepicker_header, null);




        TimePickerDialog builder = new TimePickerDialog(this, R.style.DialogTheme,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int min) {
                        Log.d(TAG, "onTimeSet: hour " + hour);
                        Log.d(TAG, "onTimeSet: min " + min);
                        localData.set_hour(hour);
                        localData.set_min(min);
                        tvTime.setText(getFormatedTime(hour, min));


                        final int horasRepetir = Integer.valueOf(tvTimeRepetir.getText().toString());
                        final String nombre = (String) tvNombre.getText();
                        final String dosis = (String) tvDosis.getText();
                        Log.d(TAG, "horasRepertir" + horasRepetir);
                        Log.d(TAG, "nombre" + nombre);
                        Log.d(TAG, "dosis" + dosis);


                        intent2.putExtra("horasRepetir", horasRepetir);
                        intent2.putExtra("nombre", nombre);
                        intent2.putExtra("dosis", dosis);



                        NotificationScheduler.setReminder(AlarmaActivity.this, AlarmReceiver.class, localData.get_hour(), localData.get_min(), intent2);


                    }
                }, h, m, false);

        builder.setCustomTitle(view);
        builder.show();


    }

    //metodo para darle formato a la hora escogida en el TimePicker
    public String getFormatedTime(int h, int m) {
        final String OLD_FORMAT = "HH:mm";
        final String NEW_FORMAT = "hh:mm a";

        String oldDateString = h + ":" + m;
        String newDateString = "";

        try {
            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT, getCurrentLocale());
            Date d = sdf.parse(oldDateString);
            sdf.applyPattern(NEW_FORMAT);
            newDateString = sdf.format(d);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return newDateString;
    }

    @TargetApi(Build.VERSION_CODES.N)
    public Locale getCurrentLocale() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return getResources().getConfiguration().getLocales().get(0);
        } else {
            //noinspection deprecation
            return getResources().getConfiguration().locale;
        }
    }
}
