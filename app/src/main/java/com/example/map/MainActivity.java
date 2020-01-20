package com.example.map;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    Button showBtn;
    GoogleMap googleMap;
    CardView cardView;
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showBtn = findViewById(R.id.button);
        cardView = findViewById(R.id.map_card);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardView.getVisibility()==View.INVISIBLE){
                    cardView.setVisibility(View.VISIBLE);

                }
                else
                cardView.setVisibility(View.INVISIBLE);
            }
        });
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mgoogleMap) {
                googleMap = mgoogleMap;
                LatLng place1 = new LatLng(41.890190, 12.492150);
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(44.4, 12.4), 5));
                googleMap.addMarker(new MarkerOptions().position(place1).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            }
        });

    }
}
