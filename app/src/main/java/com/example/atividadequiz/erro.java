package com.example.atividadequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class erro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erro);
    }
    public void voltar(View d){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}