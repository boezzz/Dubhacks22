package com.example.aidhere;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

// Implement OnMapReadyCallback.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout file as the content view.
        setContentView(R.layout.ui1);
        setRequest();
    }

    private void setRequest() {
        ImageView button = findViewById(R.id.image_request);
        button.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), CallActivity.class);
            startActivity(i);
        });
    }
}
