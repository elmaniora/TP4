package com.example.tp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tp4.databinding.ActivityInfosBinding;
import com.example.tp4.databinding.ActivityMainBinding;

public class InfosActivity extends AppCompatActivity {
    private ActivityInfosBinding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
// initialisation interne de l'activité
        super.onCreate(savedInstanceState);
// mise en place du layout par un view binding
        ui = ActivityInfosBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
// titre de l'activité
        setTitle(getLocalClassName());


        ui.bouton1.setOnClickListener(this::onBouton1Click);
    }

    private void onBouton1Click(View view) {
        finish();
    }
}