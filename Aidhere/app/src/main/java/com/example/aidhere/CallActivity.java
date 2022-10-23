package com.example.aidhere;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout file as the content view.
        setContentView(R.layout.ui2);
        final Handler handler = new Handler();

        handler.postDelayed(() -> {
            // Do something after 5s = 5000ms
            Intent i = new Intent(getApplicationContext(), MapsActivity.class);
            startActivity(i);
        }, 5000);

        TextView txt = findViewById(R.id.text_calling);

        for (int i = 0; i < 5; i++) {
            handler.postDelayed(() -> txt.setText(txt.getText() + "."), 1000 + 1000 * i);
        }

        ImageView button = findViewById(R.id.cancel_button);
        button.setOnClickListener(v -> {
            handler.removeCallbacksAndMessages(null);
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        });

        ImageView phone = findViewById(R.id.image_phone);

        ObjectAnimator anim = ObjectAnimator.ofFloat(phone,
                "alpha", 1f, 0.3f);
        anim.setDuration(300);
        anim.setStartDelay((long) (Math.random() * 1000));
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.setInterpolator(new LinearInterpolator());
        anim.start();
    }
}
