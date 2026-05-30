package com.example.starsgallery.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.starsgallery.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView logoView;
    private TextView titleView;
    private TextView subtitleView;
    private static final int DISPLAY_DURATION = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logoView = findViewById(R.id.logo);
        titleView = findViewById(R.id.titre_splash);
        subtitleView = findViewById(R.id.sous_titre_splash);

        logoView.animate().rotation(360f).scaleX(0.5f).scaleY(0.5f).setDuration(2000)
                .withEndAction(() -> logoView.animate().translationYBy(-250f).setDuration(1500));
        titleView.animate().alpha(1f).setDuration(1000).setStartDelay(2500);
        subtitleView.animate().alpha(1f).setDuration(1000).setStartDelay(3000);
        logoView.animate().alpha(0f).setDuration(800).setStartDelay(3800);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, ListActivity.class));
            finish();
        }, DISPLAY_DURATION);
    }
}