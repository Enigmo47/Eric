package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // calling this activity's function to use ActionBar utility methods
        ActionBar actionBar = getSupportActionBar();

        // providing title for the ActionBar
        actionBar.setTitle("  WhatsApp 2077");

        // providing subtitle for the ActionBar
        actionBar.setSubtitle(" contactos");

        // adding icon in the ActionBar
        actionBar.setIcon(R.drawable.logo);

        // methods to display the icon in the ActionBar
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.opcion1) {
            Toast.makeText(this,"Se seleccionó el contacto de Eric",Toast.LENGTH_LONG).show();
        }
        if (id==R.id.opcion2) {
            Toast.makeText(this,"Se seleccionó el contacto de Marta",Toast.LENGTH_LONG).show();
        }
        if (id==R.id.opcion3) {
            Toast.makeText(this,"Se seleccionó el contacto de Minaya", Toast.LENGTH_LONG).show();
        }
        if (id==R.id.video) {
            Toast.makeText(this,"Se seleccionó hacer videollamada", Toast.LENGTH_LONG).show();
        }
        if (id==R.id.llamada) {
            Toast.makeText(this,"Se seleccionó hacer llamada", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
    public void ocultar(View v) {
        getSupportActionBar().hide();
    }

    public void mostrar(View v) {
        getSupportActionBar().show();
    }
}