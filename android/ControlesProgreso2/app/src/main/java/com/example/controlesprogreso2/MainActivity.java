package com.example.controlesprogreso2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    Toast toast = Toast.makeText(getApplicationContext(), "ToggleButton ON", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    // The toggle is disabled
                    Toast toast = Toast.makeText(getApplicationContext(), "ToggleButton OFF", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });


        Switch simpleSwitch1 = (Switch) findViewById(R.id.switch1);
        simpleSwitch1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String statusSwitch1, statusSwitch2;
                if (simpleSwitch1.isChecked())
                    statusSwitch1 = simpleSwitch1.getTextOn().toString();
                else
                    statusSwitch1 = simpleSwitch1.getTextOff().toString();
                Toast.makeText(getApplicationContext(), "Switch " + statusSwitch1, Toast.LENGTH_LONG).show();

            }
        });


        SeekBar seekBar=(SeekBar)findViewById(R.id.seekBar);
        // perform seek bar change listener event used for getting the progress value
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });



            final RatingBar simpleRatingBar = (RatingBar) findViewById(R.id.ratingBar);

            simpleRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String totalStars = "Total Stars:: " + simpleRatingBar.getNumStars();
                String textrating = "Rating :: " + simpleRatingBar.getRating();
                Toast.makeText(getApplicationContext(), totalStars + "\n" + textrating, Toast.LENGTH_LONG).show();
            }
        });



    }
}