package com.adrydev.sporty2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button btnFut, btnBal, btnSka, btnPad, btnMisReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFut = (Button) findViewById(R.id.btnFutbol);
        btnBal = (Button) findViewById(R.id.btnBaloncesto);
        btnSka = (Button) findViewById(R.id.btnSkate);
        btnPad = (Button) findViewById(R.id.btnPadel);
        btnMisReg = (Button) findViewById(R.id.btnRegistros);

        btnFut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FutbolMap.class);
                startActivity(intent);
            }
        });
        btnBal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),BaloncestoMap.class);
                startActivity(intent);
            }
        });

        btnSka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SkateMap.class);
                startActivity(intent);
            }
        });

        btnPad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PadelMap.class);
                startActivity(intent);
            }
        });

        btnMisReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Registros.class);
                startActivity(intent);
            }
        });













    }
}