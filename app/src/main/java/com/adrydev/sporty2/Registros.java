package com.adrydev.sporty2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Registros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        final EditText edName = findViewById(R.id.etNomReg);
        final EditText edDepor = findViewById(R.id.etDepReg);
        final EditText edPes = findViewById(R.id.etPesoReg);
        final EditText edEdad = findViewById(R.id.etEdadReg);
        Button btnEnviar = findViewById(R.id.btnEnviar);
        Button btnActualizar = findViewById(R.id.btnActualiza);
        DAOUsuario dao = new DAOUsuario();

        btnEnviar.setOnClickListener(v -> {
        Usuario usuario = new Usuario(edName.getText().toString(),edDepor.getText().toString(),edPes.getText().toString(),edEdad.getText().toString());
      dao.add(usuario).addOnSuccessListener(suc->
       {
           Toast.makeText(this, "Se inserto con exito", Toast.LENGTH_SHORT).show();
      }).addOnFailureListener(er->
      {
           Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
      }); });
        btnActualizar.setOnClickListener(v -> {
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("nombre",edName.getText().toString());
            hashMap.put("deporte",edDepor.getText().toString());
            hashMap.put("peso",edPes.getText().toString());
            hashMap.put("edad",edEdad.getText().toString());

            dao.update("usuario",hashMap).addOnSuccessListener(suc->
           {
                Toast.makeText(this, "Se inserto con exito", Toast.LENGTH_SHORT).show();
           }).addOnFailureListener(er->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

    }
}