package com.example.atividadequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class configuracao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao);
    }
    public void voltar(View d){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void thiago(View view){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cactocareca/"));
        startActivity(intent);
    }
    public void henri(View vie){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/henritubosaka/"));
        startActivity(intent);
    }
}
