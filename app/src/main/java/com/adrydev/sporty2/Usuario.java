package com.adrydev.sporty2;

public class Usuario {
    private String nombre;
    private String deporte;
    private String edad;
    private String peso;

    public Usuario() {
    }

    public Usuario(String nombre, String deporte, String edad, String peso) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.edad = edad;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}
