package com.jquirogl.appclinicaproject.alarma;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.jquirogl.appclinicaproject.AlarmaActivity;

/**
 * Created by INTEL on 20/11/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {

    String TAG = "AlarmReceiver";


    @Override
    public void onReceive(Context context, Intent intent) {
        //despertamos el cpu
        WakeLocker.acquire(context);



        if (intent.getAction() != null && context != null) {
            if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
                //Seteamos la alarma.
                Log.d(TAG, "onReceive: BOOT_COMPLETED");
                //      Log.d(TAG, String.valueOf(horasRepetir));
                LocalData localData = new LocalData(context);
                NotificationScheduler.setReminder(context, AlarmReceiver.class, localData.get_hour(), localData.get_min(),intent);
                return;
            }
        }

        // int horasRepetir = intent.getIntExtra("horasRepetir", 0);
        String nombre = intent.getStringExtra("nombre");
        String dosis = intent.getStringExtra("dosis");
        //   Log.d(TAG, "AlarmReceiver horasRepetir " + horasRepetir);
        Log.d(TAG, "AlarmReceiver nombre " + nombre);
        Log.d(TAG, "AlarmReceiver dosis " + dosis);

        Log.d(TAG, "onReceive: ");

        //Lanzamos la notificacion
        NotificationScheduler.showNotification(context, AlarmaActivity.class,
                "Es hora de tomar tu medicamento", dosis.concat("").concat(nombre));
        //soltamos el acceso al cpu
        WakeLocker.release();

    }
}
