package com.example.atividadequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class quiz3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);
    }
    public void certo(View h){
        Intent intent = new Intent(this, fim.class);
        startActivity(intent);
    }
    public void errado(View f){
        Intent intent = new Intent(this, erro.class);
        startActivity(intent);
    }
}