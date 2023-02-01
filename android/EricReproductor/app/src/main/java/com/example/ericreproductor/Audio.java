package com.example.ericreproductor;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Audio extends AppCompatActivity {
    MediaPlayer mp;
    Button b1;
    int posicion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio_main);
        b1 = (Button) findViewById(R.id.button5);
    }


    public void destruir() {
        if (mp != null)
            mp.release();
    }

    public void iniciar(View v) {
        destruir();
        mp = MediaPlayer.create(this, R.raw.numero2);
        mp.start();
        String op = b1.getText().toString();
        if (op.equals("No reproducir en forma circular"))
            mp.setLooping(false);
        else
            mp.setLooping(true);
    }

    public void pausar(View v) {
        if (mp != null && mp.isPlaying()) {
            posicion = mp.getCurrentPosition();
            mp.pause();
        }
    }

    public void continuar(View v) {
        if (mp != null && mp.isPlaying() == false) {
            mp.seekTo(posicion);
            mp.start();
        }
    }

    public void detener(View v) {
        if (mp != null) {
            mp.stop();
            posicion = 0;
        }
    }

    public void circular(View v) {
        detener(null);
        String op = b1.getText().toString();
        if (op.equals("No reproducir en forma circular"))
            b1.setText("reproducir en forma circular");
        else
            b1.setText("No reproducir en forma circular");
    }
}
