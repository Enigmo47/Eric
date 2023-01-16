package com.example.checkbox;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView tv1;
    private CheckBox check1, check2, check3, check4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//TODO: Recoger los elementos de la vista en las variables privadas.

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv1 = (TextView) findViewById(R.id.tv1);
        check1 = (CheckBox) findViewById(R.id.check1);
        check2 = (CheckBox) findViewById(R.id.check2);
        check3 = (CheckBox) findViewById(R.id.check3);
        check4 = (CheckBox) findViewById(R.id.check4);

    }

    //Este método se ejecutará cuando se presione el botón
    public void operar(View view) {

        String resu = "";

        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();
        int nro1 = Integer.parseInt(valor1);
        int nro2 = Integer.parseInt(valor2);

        if (check1.isChecked()) {
            Context context = getApplicationContext();
            CharSequence text = "Suma";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            int suma = nro1 + nro2;
           resu= "La suma es: "+ suma+"\n";
        }

        if (check2.isChecked()) {

            Context context = getApplicationContext();
            CharSequence text = "Resta";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            int resta = nro1 - nro2;

            resu= resu+"La resta es: "+ resta+"\n";
        }
        if (check3.isChecked()) {
            int multiplicacion = nro1 * nro2;

            Context context = getApplicationContext();
            CharSequence text = "Producto";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            resu= resu+"La multiplicacion es: "+ multiplicacion+"\n";
        }
        if (check4.isChecked()) {

            Context context = getApplicationContext();
            CharSequence text = "Division";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            if(nro2 ==0){
                resu="No puedes dividir entre 0";

            }else{
                int division = nro1 / nro2;
                resu= resu+"La division es: "+ division;
            }
        }

        if(!(check1.isChecked())&&!(check2.isChecked()) &&!(check3.isChecked())&&!(check4.isChecked())){
            resu="Selecciona una operacion a realizar";
        }
        tv1.setText(resu);
    }
}
