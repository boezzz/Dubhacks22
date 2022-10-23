package com.example.aidhere;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CallActivity extends AppCompatActivity {

    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout file as the content view.
        setContentView(R.layout.ui2);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                Intent i = new Intent(getApplicationContext(), CallActivity.class);
                startActivity(i);
            }
        }, 5000);

        ImageView button = findViewById(R.id.cancel_button);
        button.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            setContentView(R.layout.ui1);
        });
    }
}
