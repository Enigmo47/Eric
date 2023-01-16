package com.example.dialogosynotificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private NotificationManager notificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificacion = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);


        Button boton = (Button) findViewById(R.id.buttonReloj2);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                notification(
                        1,
                        R.drawable.download,
                        "Buenas",
                        "Notificacion personalizada"
                );
            }
        });
    }

    public void toast(View view){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast,
                (ViewGroup) findViewById(R.id.layoutToast));

        TextView text = (TextView) layout.findViewById(R.id.textToast);
        text.setText("Hola, soy Cthulhu");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void calendario(View view){
        final Calendar calen= Calendar.getInstance();
        int year = calen.get(Calendar.YEAR);
        int month = calen.get(Calendar.MONTH);
        int day = calen.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog fecha =new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener(){
            public void onDateSet(DatePicker view, int year_a,
                                  int month_a, int day_a){
                Toast.makeText(getApplicationContext(),"Dia: "+day_a+" Mes: "+(month_a+1)+" Año: "+year_a,Toast.LENGTH_SHORT).show();
            }
        },year,month,day);
    fecha.show();
    }

    public void reloj(View view){
        final Calendar calen= Calendar.getInstance();
        int hora = calen.get(Calendar.HOUR_OF_DAY);
        int mins = calen.get(Calendar.MINUTE);

        TimePickerDialog horas =new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
                    public void onTimeSet(TimePicker view, int horas,
                                          int minutos){
                        Toast.makeText(getApplicationContext(),"Horas: "+horas+" Minutos: "+(minutos+1),Toast.LENGTH_SHORT).show();
                    }
                },hora,mins,true);
        horas.show();
    }



    public void notification(int id, int iconId, String titulo, String contenido) {

        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setLargeIcon(BitmapFactory.decodeResource(
                                getResources(),
                                R.drawable.download)
                        )
                        .setSmallIcon(iconId)
                        .setContentTitle(titulo)
                        .setColor(getResources().getColor(R.color.purple_500))
                        .setContentText(contenido).setNumber(id);

        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        PendingIntent fullScreenPendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent,
                PendingIntent.FLAG_IMMUTABLE);

        builder.setFullScreenIntent(fullScreenPendingIntent, true);

        // Construir la notificación y emitirla
        notificacion.notify(id, builder.build());
    }

    public void dialogo(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Dialogo");
        builder.setMessage("Soy un dialogo");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Pulsaste a Si",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Pulsaste a No",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

}