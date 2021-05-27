package com.adrydev.sporty2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends Activity {

    private EditText etLoginEmail,etLoginPass;
    private Button btnLoginRegistro,btnLoginAcede;

    private String emilio;
    private String contrasenia;
    private ProgressDialog progressDialog;
    private DatabaseReference mDataBase;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLoginEmail = (EditText) findViewById(R.id.etEmailLogin);
        etLoginPass = (EditText) findViewById(R.id.etContraseniaLogin);
        btnLoginRegistro = (Button) findViewById(R.id.btnRegistroLogin);
        btnLoginAcede = (Button) findViewById(R.id.btnAccedeLogin);
        progressDialog = new ProgressDialog(this);
        mDataBase = (FirebaseDatabase.getInstance().getReference());
        mAuth = FirebaseAuth.getInstance();

        btnLoginRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emilio = etLoginEmail.getText().toString();
                contrasenia = etLoginPass.getText().toString();
                if( !emilio.isEmpty() && !contrasenia.isEmpty()){

                    if(contrasenia.length() >= 6){

                        registrarUsuario();

                    }else{
                        Toast.makeText(LoginActivity.this, "La contraseña tiene que tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(LoginActivity.this, "Debes rellenar los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnLoginAcede.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emilio = etLoginEmail.getText().toString();
                contrasenia = etLoginPass.getText().toString();
                if( !emilio.isEmpty() && !contrasenia.isEmpty()){

                    if(contrasenia.length() >= 6){

                        logearUsuario();

                    }else{
                        Toast.makeText(LoginActivity.this, "La contraseña tiene que tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(LoginActivity.this, "Debes rellenar los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void registrarUsuario() {
        progressDialog.setMessage("Realizando el registro en linea...");
        progressDialog.show();
        mAuth.createUserWithEmailAndPassword(emilio,contrasenia).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //validamos si la tarea (task) fue exitosa osea si el registro del usuario se realizo correctamente
                if(task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                    Map<String, Object> map = new HashMap<>();
                    map.put("email", emilio);
                    map.put("contrasenia", contrasenia);


                    String id = mAuth.getCurrentUser().getUid();// obtener el id del objeto generado
                    mDataBase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                finish();
                            }else {
                                Toast.makeText(LoginActivity.this,"No se pudieron crear los datos correctamente", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(LoginActivity.this, "Ese usuario ya existe", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this, "No se pudo realizar el registro correctamente", Toast.LENGTH_LONG).show();
                    }
                    progressDialog.dismiss();
                    }
            }
        });



    }


    private void logearUsuario() {
        progressDialog.setMessage("Accediendo a la base de datos...");
        progressDialog.show();
        mAuth.signInWithEmailAndPassword(emilio,contrasenia).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //logeamos usuario
                if(task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                    Map<String, Object> map = new HashMap<>();
                    map.put("email", emilio);
                    map.put("contrasenia", contrasenia);



                }else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(LoginActivity.this, "Ese usuario ya existe", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this, "No se pudo realizar el registro correctamente", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }



}


