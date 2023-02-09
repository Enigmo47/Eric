package com.example.ericcanvas2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


import static android.view.View.SYSTEM_UI_FLAG_FULLSCREEN;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyCanvasView myCanvasView;
        myCanvasView = new MyCanvasView(this);
        myCanvasView.setSystemUiVisibility(SYSTEM_UI_FLAG_FULLSCREEN);
        setContentView(myCanvasView);
    }
}