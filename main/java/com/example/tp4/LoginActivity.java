package com.example.tp4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.example.tp4.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding ui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
// initialisation interne de l'activité
        super.onCreate(savedInstanceState);
// mise en place du layout par un view binding
        ui = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
// titre de l'activité
        setTitle(getLocalClassName());
// écouteur quand on valide la saisie du pseudo
        ui.username.setOnEditorActionListener(this::onEditorAction);
    }

    private boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
// texte saisi
            String username = ui.username.getText().toString();
            Intent intent=new Intent(this, MainActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
            finish();
            return true;
        }
        else {
// événement non consommé
            return false;
        }
    }
}