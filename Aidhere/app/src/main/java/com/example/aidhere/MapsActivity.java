package com.example.aidhere;


import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Random;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Random rand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        rand = new Random();
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     *
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        double latitude = 47.608013;
        double longitude = -122.335167;
        LatLng seattle = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions()
                .position(seattle)
                .title("Marker in Seattle"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(seattle, 15));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(20), 500, null);

        final Handler handler = new Handler();

        for (int i = 0; i < 3; i++) {
            handler.postDelayed(() -> {
                // Do something after 5s = 5000ms
                LatLng p = new LatLng(latitude + (rand.nextDouble() - 0.5) / 3000,
                        longitude + (rand.nextDouble() - 0.5) / 3000);
                mMap.addMarker(new MarkerOptions()
                        .position(p)
                        .title("People")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
                handler.postDelayed(() -> mMap.addMarker(new MarkerOptions()
                        .position(p)
                        .title("People")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))), 1000 + (int)(rand.nextDouble() * 1000));
            }, 500 + i * (600 + (int)(rand.nextDouble() * 1000)));
        }

        handler.postDelayed((Runnable) () -> {
            TextView eta = findViewById(R.id.eta_text);
            eta.setText(getString(R.string.updated_eta));
        }, 3000);
    }
}