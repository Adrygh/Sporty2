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

public class BaloncestoMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baloncesto_map);
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

        LatLng f1 = new LatLng(40.47919714744627, -3.696853200700267);
        mMap.addMarker(new MarkerOptions().position(f1).title("Cancha de Baloncesto").snippet("Suelo Poco Cuidado").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


        LatLng f2 = new LatLng(40.435310351774774, -3.7263789570620083);
        mMap.addMarker(new MarkerOptions().position(f2).title("Cancha de Baloncesto Paseo Camoens").snippet("Muy cuidadas").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));


        LatLng f3 = new LatLng(40.41361760559365, -3.7037196556681136);
        mMap.addMarker(new MarkerOptions().position(f3).title("Canchas De Embajadores").snippet("Suelos Nuevos").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(f3,14), 5000, null);

        LatLng f4 = new LatLng(40.47684679587297, -3.6549678253964006);
        mMap.addMarker(new MarkerOptions().position(f4).title("Canchas De Baloncesto").snippet("Suelo poco cuidado").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f5 = new LatLng(40.40472940061158, -3.6779704495386882);
        mMap.addMarker(new MarkerOptions().position(f5).title("Canchas Baloncesto Pacífico").snippet("Suelo normal").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f6 = new LatLng(40.41387900561696, -3.639174978970352);
        mMap.addMarker(new MarkerOptions().position(f6).title("Campos de baloncesto").snippet("Suelo normal").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f7 = new LatLng(40.40499083515974, -3.6707606718224484);
        mMap.addMarker(new MarkerOptions().position(f7).title("Cancha Baloncesto Pública Luis Mitjans").snippet("Suelo en mal estado").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f8 = new LatLng(40.436094295932705, -3.734962025771817);
        mMap.addMarker(new MarkerOptions().position(f8).title("Cancha de Baloncesto loeches").snippet("Suelo en buen estado").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));




        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}