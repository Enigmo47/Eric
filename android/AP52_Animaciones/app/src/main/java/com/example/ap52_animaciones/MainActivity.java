package com.example.ap52_animaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        /**TextView ejemplo = (TextView) findViewById(R.id.texto);
        Animation td = AnimationUtils.loadAnimation(this, R.anim.mueve1);
        td.setFillAfter(true);
        ejemplo.startAnimation(td);
        ejemplo.append("\n TEXTO MOVIENDOSE");**/
    }

    public void ver(View v){
        TextView ejemplo = (TextView) findViewById(R.id.texto);
        Animation td = AnimationUtils.loadAnimation(this, R.anim.rotar1);
        td.setFillAfter(true);
        ejemplo.startAnimation(td);
        //ejemplo.append("\n TEXTO MOVIENDOSE");
    }
}