package com.example.chaos.taller03_android.model;

/**
 * Created by Darklook64 on 03-05-2018.
 */

public class Intentos {
    private int aciertos;
    private int fallos;

    public Intentos(int aciertos, int fallos) {
        this.aciertos = aciertos;
        this.fallos = fallos;
    }

    public Intentos() {
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }
}
