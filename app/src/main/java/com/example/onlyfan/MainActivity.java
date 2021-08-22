package com.example.onlyfan;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imgFan;
    TextView txtHint;
    boolean spinnerIsAtivated = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        imgFan = findViewById(R.id.imgFan);
        txtHint = findViewById(R.id.textView);

        imgFan.setImageResource(R.drawable.spinner);

        Animation fanAnimation = AnimationUtils.loadAnimation(this, R.anim.animation);
        Animation textAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_text);

        txtHint.setText("Tap the spinner to active it!");
        txtHint.startAnimation(textAnimation);

        imgFan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spinnerIsAtivated == false) {
                    view.startAnimation(fanAnimation);
                    txtHint.setText("");
                    spinnerIsAtivated = true;
                }
                else {
                    view.clearAnimation();
                    spinnerIsAtivated = false;
                    txtHint.setText("Tap the spinner to active it!");
                    txtHint.startAnimation(textAnimation);
                }
            }
        });

    }
}