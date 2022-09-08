package com.example.atividadequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class mapa extends AppCompatActivity {

    EditText etView;
    Button btSubmit;
    TextView txtLoc;
    String aDdress;
    String lat;
    String lon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        etView = findViewById(R.id.etView);
        btSubmit = findViewById(R.id.btnSubmit);
        txtLoc = findViewById(R.id.txtLoc);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor ed = prefs.edit();
                ed.putString("local", etView.getText().toString());
                ed.apply();
                Toast.makeText(mapa.this, "Localização Gravada", Toast.LENGTH_SHORT).show();

                aDdress = etView.getText().toString();

                GeoLocation geoLocation = new GeoLocation();
                geoLocation.getAddress(aDdress,getApplicationContext(),new mapa.GeoHandler());
            }
        });
    }
    private class GeoHandler extends Handler {
        @Override
        public void  handleMessage (Message msg){
            String address;

            switch (msg.what){
                case 1:
                    Bundle bundle = msg.getData();
                    address = bundle.getString("address");
                    lat = bundle.getString("lat");
                    lon = bundle.getString("long");
                    aDdress = address;
                    break;
                default:
                    address = null;
            }
            txtLoc.setText(aDdress);
            mostrarGoogleMaps(Double.valueOf(lat),Double.valueOf(lon));
        }
    }

    public void mostrarGoogleMaps(double latitude, double longitude) {
        WebView wv = findViewById(R.id.webv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("https://www.google.com/maps/search/?api=1&query=" + latitude + "," + longitude);
    }

    public void limpar(View view){
        etView.setText("");
        txtLoc.setText("");
    }
    public void rec(View view){
        SharedPreferences pref = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        etView.setText(((SharedPreferences) pref).getString("local", "nada salvo"));
    }

    public void voltar(View d){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}