package com.example.chaos.taller03_android.model;

import android.content.Intent;

import com.example.chaos.taller03_android.ChallengeFragment;

public class Data {
    private int tiempo;
    private Palabra palabra;


    public Data() {
        this.tiempo = 5*1000;

        this.palabra= new Palabra("asd");

    }

    public Palabra getPalabra() {
        return palabra;
    }

    public void setPalabra(Palabra palabra) {
        this.palabra = palabra;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}
