package com.adrydev.sporty2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.maps.model.Marker;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.adrydev.sporty2.Usuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Datos extends AppCompatActivity {//-----------------------------------------------------------------------
    // aqui declaramos las variables
    private List<Usuario> usuarioList = new ArrayList<Usuario>();
    ArrayAdapter<Usuario> usuarioArrayAdapter;
    private String randonKey;
    EditText nombreP, depoP, edadP,pesoP;
    TextView datosS;
    ListView lvZusuario;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    Usuario usuarioSeleccionado;

    //METODO ON CREATE---------------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        mAuth = FirebaseAuth.getInstance();
        nombreP = (EditText) findViewById(R.id.etNomD);
        depoP = (EditText) findViewById(R.id.etDeporD);
        edadP = (EditText) findViewById(R.id.etEdadD);
        pesoP = (EditText) findViewById(R.id.etPesoD);
        datosS = (TextView) findViewById(R.id.tvDatos);
        // con este metodo iniciamos Firebase
        inicializarFirebase();
        // con este metodo listamos los datos
        listarDatos();
        // creamos este metodo para al pinchar en el item listado nos rellene los campos con sus atributos


    }
    //creamos este metodo para listar los datos-----------------------------------------------------------------------------------
    private void listarDatos() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

        ref.child("Users").child("Loca").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String valor = dataSnapshot.getValue(String.class);
                datosS.setText(String.valueOf(valor));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("Fallo la lectura: " + databaseError.getCode());
            }
        });
    }
//        String id = mAuth.getCurrentUser().getUid();
//        databaseReference.child("Users").child(id).child("Loca").set;


    //creamos este metodo para iniciar Firebase con una instancia y una referencia-------------------------------------------
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    // Creamos este metodo para implementar el menu en el layout main---------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //agregamos esta linea para vincular el menu que hicimos nuevo
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //Metodo que gestiona los items del menu en base a su seleccion-----------------------------------------------------------------
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String nombre = nombreP.getText().toString();
        String deporte = depoP.getText().toString();
        String peso = pesoP.getText().toString();
        String edad = edadP.getText().toString();
        // depende de que icono pinchamos asi hacemos
        switch (item.getItemId()){
            case R.id.iconAñadir:{
                if(nombre.equals("") || (deporte.equals("") || (peso.equals("") || (edad.equals(""))))){
                    validacion();
                }else{
                    //creamos un objeto zapatilla y enviamos los atributos
                    Usuario u = new Usuario();
                    u.setId(UUID.randomUUID().toString());// agregamos un ramdomidazor en el id
                    u.setNombre(nombre);
                    u.setDeporte(deporte);
                    u.setPeso(peso);

                    // con esto creamos la tabla zapatilla que contendra ids aleatorias de las diferentes zapas
                    databaseReference.child("Usuario").child(u.getId()).setValue(u);
                    Toast.makeText(this, "Agregado correctamente", Toast.LENGTH_SHORT).show();
                    limpiarCajas();
                }
                break;
            }
            case R.id.iconEditar:{
                Usuario u = new Usuario();
                u.setId(usuarioSeleccionado.getId());//cogemos el id de la zapatilla seleccionada
                u.setNombre(nombreP.getText().toString().trim());
                u.setDeporte(depoP.getText().toString().trim());
                u.setPeso(pesoP.getText().toString().trim());
                u.setEdad(edadP.getText().toString().trim());
                //con esta llamada sobreescribimos el objeto seleccionado en la database
                databaseReference.child("Usuario").child(u.getId()).setValue(u);
                Toast.makeText(this, "Modificado correctamente", Toast.LENGTH_SHORT).show();
                //limpiamos al actualizar con nuestro metodo
                limpiarCajas();
                break;
            }
            case R.id.iconEliminar:{
                Usuario u = new Usuario();
                u.setId(usuarioSeleccionado.getId());
                // con esta llamada eliminamos el objeto seleccionado
                databaseReference.child("Usuario").child(u.getId()).removeValue();
                Toast.makeText(this, "Eliminado correctamente", Toast.LENGTH_SHORT).show();
                limpiarCajas();
                break;
            }
            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
    //Creamos un metodo para limpiar los campos de los editText--------------------------------------------------------------------
    private void limpiarCajas() {
        nombreP.setText("");
        depoP.setText("");
        pesoP.setText("");
        edadP.setText("");
    }


    //Creamos un metodo para validar------------------------------------------------------------------------------------------------
    private void validacion() {
        String nombre = nombreP.getText().toString();
        String deporte = depoP.getText().toString();
        String peso = pesoP.getText().toString();
        String edad = edadP.getText().toString();
        if(nombre.equals("")){
            nombreP.setError("Se necesita");
        }
        else if(deporte.equals("")){
            depoP.setError("Se necesita");
        }
        else if(peso.equals("")){
            pesoP.setError("Se necesita");
        }
        else if(edad.equals("")){
            edadP.setError("Se necesita");
        }
    }
}