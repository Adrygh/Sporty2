package com.adrydev.sporty2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SkateMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skate_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng f1 = new LatLng(40.3994582212128, -3.7026898114613678);
        mMap.addMarker(new MarkerOptions().position(f1).title("Skatepark Madrid Río").snippet("Suelo perfecto").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


        LatLng f2 = new LatLng(40.456431396270816, -3.4760967975224166);
        mMap.addMarker(new MarkerOptions().position(f2).title("Skatepark Torrejon").snippet("Profesional").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


        LatLng f3 = new LatLng(40.440755519673715, -3.6027828916791935);
        mMap.addMarker(new MarkerOptions().position(f3).title("Skate Park San Blas").snippet("Suelo en mal estado").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(f3,14), 5000, null);

        LatLng f4 = new LatLng(40.47523762153203, -3.708526298184038);
        mMap.addMarker(new MarkerOptions().position(f4).title("Skate Plaza").snippet("Suelo muy bueno").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f5 = new LatLng(40.50134864274838, -3.693763420003166);
        mMap.addMarker(new MarkerOptions().position(f5).title("Skatepark Fuencarral").snippet("Suelo mejorable").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        //mMap.setOnMarkerClickListener();
        LatLng f6 = new LatLng(40.45251276990925, -3.4541241416253063);
        mMap.addMarker(new MarkerOptions().position(f6).title("On Fire Skate Park").snippet("Suelo de madera").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f7 = new LatLng(40.45590892595998, -3.4778134112643784);
        mMap.addMarker(new MarkerOptions().position(f7).title("Skatepark Torrejón de Ardoz").snippet("Suelo para Surfskate").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f8 = new LatLng(40.362102125151594, -3.8117090745847486);
        mMap.addMarker(new MarkerOptions().position(f8).title("Skatepark San Jose De Valderas").snippet("Suelo en buen estado").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));




    }
}