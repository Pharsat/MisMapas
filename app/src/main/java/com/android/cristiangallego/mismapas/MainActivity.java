package com.android.cristiangallego.mismapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirMapa(int ubicacionElegida) {
        Intent maps = new Intent(this, MapsActivity.class);
        maps.putExtra(getResources().getString(R.string.ubicacionElegida), ubicacionElegida);
        startActivity(maps);
    }

    public void miCasa(View view){
        abrirMapa(R.drawable.lacasa);
    }
    public void sanFelix(View view){
        abrirMapa(R.drawable.sanfelix);
    }
    public void parqueArvi(View view){
        abrirMapa(R.drawable.parquearvi);
    }
    public void palermo(View view){
        abrirMapa(R.drawable.palermo);
    }
}
