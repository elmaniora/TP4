package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.tp4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG="TP4";
    private ActivityMainBinding ui;
    //private int compteur = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
// initialisation interne de l'activité
            super.onCreate(savedInstanceState);
// mise en place du layout par un view binding
            ui = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(ui.getRoot());
// titre de l'activité
            setTitle(getLocalClassName());
// message d'information
            Log.i(TAG, "dans "+getLocalClassName()+".onCreate");
//Récupération de TextView dans un objet java et changement du texte affiché
            //TextView texte = findViewById(R.id.texte);
            //texte.setText("Bonjour");
//Changement du texte affiché par le TextView avec un view bindings
            //ui.texte.setText("Voici MainActivity");
// écouteur pour le bouton2, lambda
            ui.bouton2.setOnClickListener(btn -> {
                TP4Application app = (TP4Application) getApplicationContext();
                int compteur = app.getNombre();
                compteur += 5;
                app.setNombre(compteur);
                ui.texte.setText("compteur = "+compteur);
            });
// écouteur pour le bouton3, référence de méthode
        ui.bouton3.setOnClickListener(this::onBouton3Click);
// écouteur pour le bouton4, l'activité elle-même
        ui.bouton4.setOnClickListener(this);
//écouteur pour le bouton5 et 6; référence de méthode
        ui.bouton5.setOnClickListener(this::onBouton5Click);
        ui.bouton6.setOnClickListener(this::onBouton6Click);

        ui.cours.setOnClickListener(this::onBoutonCoursClick);

        Intent intent = getIntent();
        String information= intent.getStringExtra("username");
        ui.texte.setText("Bonjour "+information);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "dans "+getLocalClassName()+".onDestroy");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "dans "+getLocalClassName()+".onPause");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "dans "+getLocalClassName()+".onResume");
    }
    public void onBouton1Click(View view) {
        // récupérer le contexte d'application et la donnée qu'elle contient
        TP4Application app = (TP4Application) getApplicationContext();
        int compteur = app.getNombre();
        compteur += 1;
        app.setNombre(compteur);
        ui.texte.setText("compteur = "+compteur);
    }
    private void onBouton3Click(View view) {
        // récupérer le contexte d'application et la donnée qu'elle contient
        TP4Application app = (TP4Application) getApplicationContext();
        int compteur = app.getNombre();
        compteur *= 2;
        app.setNombre(compteur);
        ui.texte.setText("compteur = "+compteur);
    }

    @Override
    public void onClick(View v) {
        // récupérer le contexte d'application et la donnée qu'elle contient
        TP4Application app = (TP4Application) getApplicationContext();
        int compteur = app.getNombre();
        compteur *= 5;
        app.setNombre(compteur);
        ui.texte.setText("compteur = "+compteur);
    }

    private void onBouton5Click(View view) {
        Intent intent = new Intent(this, InfosActivity.class);
        startActivity(intent);
    }

    private void onBouton6Click(View view) {
        Intent intent = new Intent(this, InfosActivity.class);
        startActivity(intent);
        finish();
    }

    private void onBoutonCoursClick(View view) {
        String url = "https://perso.univ-rennes1.fr/pierre.nerzic/Android";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
