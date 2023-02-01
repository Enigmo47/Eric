package com.example.ericreproductor;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class Video extends AppCompatActivity {

    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_main);
        //Inicializamos la clase VideoView asociandole el fichero de Video

        video = (VideoView) findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.winton;
        video.setVideoURI(Uri.parse(path));
        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        video.start();
    }
}