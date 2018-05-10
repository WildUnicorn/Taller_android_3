package com.example.chaos.taller03_android.model;

import android.content.Intent;

import com.example.chaos.taller03_android.ChallengeFragment;

import java.util.List;

public class Data {
    public static int tiempo = 5*1000;
    private static Palabra palabra;
    public static String frase = "asd";
    public static List<String> listaTiempo;



    public Data() {

        this.palabra= new Palabra("asd");


    }

    public Palabra getPalabra() {
        return palabra;
    }

    public void setPalabra(Palabra palabra) {
        frase=palabra.getPalabra();
        this.palabra = palabra;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
