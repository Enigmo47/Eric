package com.example.aa75_notificacionsincronizacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NotificationManager notificador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button boton = (Button) findViewById(R.id.button1);

        notificador = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                notification(
                        1,
                        android.R.drawable.stat_sys_warning,
                        "NOTIFICACIÓN",
                        "SINCRONIZANDO LA NOTIFICACIÓN"
                );
            }
        });
    }

    public void notification(final int id, int iconId, String titulo, String contenido) {

        final NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(iconId)
                        .setLargeIcon(BitmapFactory.decodeResource(
                                        getResources(),
                                        R.mipmap.ic_launcher
                                )
                        )
                        .setContentTitle(titulo)
                        .setContentText(contenido)
                        .setColor(getResources().getColor(R.color.purple_700));

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        int i;
                        // SIMULACIÓN DEL PROGRESO
                        for (i = 0; i <= 100; i += 5) {
                            // PONER 100 COMO MEDIDA MÁXIMA
                            builder.setProgress(100, i, false);
                            // Emitir la notificación
                            notificador.notify(id, builder.build());
                            // CREAR RETARDO DEL HILO
                            try {
                                // DEMORA 1 SEGUNDO
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                Log.d("ERROR", "Falló sleep(1000) ");
                            }
                        }
                        //ACTUALIZACIÓN DE LA NOTIFICACION
                        // INFORMAR DE FIN DE PROCESO
                        builder.setContentText("SINCRONIZACIÓN COMPLETADA")
                                // ELIINAR BARRA DE PROGRESO
                                .setProgress(0, 0, false);
                        notificador.notify(id, builder.build());
                    }
                }
        ).start();
    }
}
