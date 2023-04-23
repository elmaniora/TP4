package com.example.tp4;

import android.app.Application;

public class TP4Application extends Application {
    private int nombre;
    public void onCreate()
    {
        super.onCreate();
        this.nombre=0;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    public int getNombre() {
        return nombre;
    }


}
