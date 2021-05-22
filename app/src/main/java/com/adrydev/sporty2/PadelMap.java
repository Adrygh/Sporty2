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

public class PadelMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_padel_map);
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

        LatLng f1 = new LatLng(40.37958484766354, -3.7159221519325385);
        mMap.addMarker(new MarkerOptions().position(f1).title("Pistas de pádel").snippet("Buenas instalaciones").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f2 = new LatLng(40.42795102031972, -3.7248485433907397);
        mMap.addMarker(new MarkerOptions().position(f2).title("Pistas de Padel Marqués de Monistrol").snippet("Muy buenas instalaciones").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f3 = new LatLng(40.40887014103973, -3.696352755274175);
        mMap.addMarker(new MarkerOptions().position(f3).title("Pistas de pádel Fabricante").snippet("Buenas instalaciones").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(f3,14), 5000, null);

        LatLng f4 = new LatLng(40.36990744313447, -3.6503475069896);
        mMap.addMarker(new MarkerOptions().position(f4).title("Pistas de Pádel CTM").snippet("Muy buenas instalaciones").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f5 = new LatLng(40.40965439338804, -3.5875194440338);
        mMap.addMarker(new MarkerOptions().position(f5).title("Madrid Central Padel").snippet("Buenas instalaciones").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f6 = new LatLng(40.36336786949875, -3.5435741322395793);
        mMap.addMarker(new MarkerOptions().position(f6).title("Pistas de padel, Polideportivo Cerro del Telégrafo").snippet("Malas instalaciones").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f7 = new LatLng(40.397628186470214, -3.720042024913247);
        mMap.addMarker(new MarkerOptions().position(f7).title("Río Arena Padel").snippet("Buenas instalaciones").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f8 = new LatLng(40.306120118817695, -3.6917855101312673);
        mMap.addMarker(new MarkerOptions().position(f8).title("GET Indoor Padel").snippet("Buenas instalaciones").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));




    }
}