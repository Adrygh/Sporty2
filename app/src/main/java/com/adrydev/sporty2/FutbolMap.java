package com.adrydev.sporty2;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class FutbolMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDataBase;
    private String randonKey;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_futbol_map);
        mDataBase = (FirebaseDatabase.getInstance().getReference());
        mAuth = FirebaseAuth.getInstance();
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
        randonKey = UUID.randomUUID().toString();

        LatLng f1 = new LatLng(40.418000640396656, -3.6548328640284247);
        mMap.addMarker(new MarkerOptions().position(f1).title("Campo f??tbol AFE").snippet("Cesped Artificial").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
//

        LatLng f2 = new LatLng(40.44348070503213, -3.6067676792534953);
        mMap.addMarker(new MarkerOptions().position(f2).title("Campo de futbol Antonio Palacios").snippet("Cesped Artificial").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String id = mAuth.getCurrentUser().getUid();
                mDataBase.child("Users").child(id).child("Loca").setValue(marker);//guardar la loca

                return false;
            }
        });

        LatLng f3 = new LatLng(40.42218264647024, -3.61912729819562);
        mMap.addMarker(new MarkerOptions().position(f3).title("Campo Municipal San Blas").snippet("Cesped Artificial").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(f3,14), 5000, null);

        LatLng f4 = new LatLng(40.419960988112614, -3.574152018156222);
        mMap.addMarker(new MarkerOptions().position(f4).title("Campos de futbol Barrio del Puerto").snippet("Cesped Artificial").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f5 = new LatLng(40.419960988112614, -3.574152018156222);
        mMap.addMarker(new MarkerOptions().position(f5).title("Campo de f??tbol Ciudad de ??guilas").snippet("Campo de Tierra").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f6 = new LatLng(40.412717803038134, -3.6427231313264974);
        mMap.addMarker(new MarkerOptions().position(f6).title("Campo de f??tbol Moratalaz").snippet("Campo de Tierra").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f7 = new LatLng(40.40332489129164, -3.636866036620011);
        mMap.addMarker(new MarkerOptions().position(f7).title("Campo de f??tbol El Hoyo").snippet("Campo de Futbol sala").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        LatLng f8 = new LatLng(40.412485131093035, -3.6175573604421793);
        mMap.addMarker(new MarkerOptions().position(f8).title("Campo de f??tbol Cu??a verde").snippet("Campo de Tierra").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));







    }
}