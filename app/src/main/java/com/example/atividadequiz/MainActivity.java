package com.example.atividadequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

        public void jogar(View a){
            Intent intent = new Intent(this, quiz1.class);
            startActivity(intent);
        }
    public void credito(View b){
        Intent intent = new Intent(this, configuracao.class);
        startActivity(intent);
    }
    public void site(View j){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://masp.org.br/"));
        startActivity(intent);
    }
    public void local(View q) {
        Intent intent = new Intent(this, mapa.class);
        startActivity(intent);
    }
    }

