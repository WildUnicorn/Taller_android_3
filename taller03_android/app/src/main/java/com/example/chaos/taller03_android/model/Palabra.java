package com.example.chaos.taller03_android.model;

/**
 * Created by Darklook64 on 03-05-2018.
 */

public class Palabra {
    private String palabra;


    public Palabra(String palabra) {
        this.palabra = palabra;
    }

    public Palabra() {
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    @Override
    public String toString() {
        return palabra;
    }
}
