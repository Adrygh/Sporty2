//package com.adrydev.sporty2;
//
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.util.HashMap;
//
//public class DAOUsuario {
//
//    private DatabaseReference databaseReference;
//
//    public DAOUsuario(){
//        FirebaseDatabase db = FirebaseDatabase.getInstance();
//        databaseReference = db.getReference(Usuario.class.getSimpleName());
//    }
//
//    public Task<Void> add(Usuario usuario){
//        return databaseReference.push().setValue(usuario);
//    }
//
//    public Task<Void> update(String key, HashMap<String , Object> hashMap){
//
//       return databaseReference.child(key).updateChildren(hashMap);
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
