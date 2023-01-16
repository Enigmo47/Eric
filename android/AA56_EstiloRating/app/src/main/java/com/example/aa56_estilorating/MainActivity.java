package com.example.aa56_estilorating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RatingBar miRatingBar1,miRatingBar2;
    private TextView miTexto1, miTexto2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miRatingBar1 = findViewById(R.id.miRb1);
        miTexto1 = findViewById(R.id.miTexto1);
        miRatingBar2 = findViewById(R.id.miRb2);
        miTexto2 = findViewById(R.id.miTexto2);

        miRatingBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                miTexto1.setText(String.valueOf(ratingBar.getRating()));
            }
        });

        miRatingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                miTexto2.setText(String.valueOf(ratingBar.getRating()));
            }
        });
    }
}