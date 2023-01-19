package com.example.aplicaciongirarmovil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.OrientationEventListener;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         OrientationEventListener Orientation = new OrientationEventListener(getApplicationContext()) {

             Horizontal horizontal = Horizontal.newInstance();
             Vertical vertical = Vertical.newInstance();
             FragmentManager fragmentManager = getSupportFragmentManager();
             @Override
             public void onOrientationChanged(int i) {

                 if(i==90 || i==270){

                     FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                     fragmentTransaction.replace(android.R.id.content,horizontal,null).commit();
                 }
                 if(i==0 || i==180){

                     FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                     fragmentTransaction.replace(android.R.id.content,vertical,null).commit();
                 }
             }
         };
        Orientation.enable();
    }


}