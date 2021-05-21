package com.adrydev.sporty2;

public class Persona {

    private String uid;
    private String Nombre;
    private String Deporte;
    private int Peso;
    private int Edad;

    public Persona(String uid, String nombre, String deporte, int peso, int edad) {
        this.uid = uid;
        Nombre = nombre;
        Deporte = deporte;
        Peso = peso;
        Edad = edad;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDeporte() {
        return Deporte;
    }

    public void setDeporte(String deporte) {
        Deporte = deporte;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int peso) {
        Peso = peso;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
