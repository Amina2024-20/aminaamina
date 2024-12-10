package com.example.piano;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButton(R.id.buttonC, R.raw.a);
        setupButton(R.id.buttonD, R.raw.b);
        setupButton(R.id.buttonE, R.raw.c);
        setupButton(R.id.buttonF, R.raw.d);
        setupButton(R.id.buttonG, R.raw.e);
        setupButton(R.id.buttonA, R.raw.f);
        setupButton(R.id.buttonB, R.raw.g);
    }

    private void setupButton(int buttonId, int soundId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(v -> playSound(soundId));
    }

    private void playSound(int soundId) {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        mediaPlayer = MediaPlayer.create(this, soundId);
        mediaPlayer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
