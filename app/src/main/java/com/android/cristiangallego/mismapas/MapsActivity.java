package com.android.cristiangallego.mismapas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private int ubicacionElegida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        obtenerUbicacionElegida();
    }

    private void obtenerUbicacionElegida() {
        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            if (parametros.containsKey(getResources().getString(R.string.ubicacionElegida))) {
                this.ubicacionElegida = parametros.getInt(getResources().getString(R.string.ubicacionElegida));
            }
        }
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        obtenerUbicacionElegida();
        LatLng miCasa = DevoverUbicacion(this.ubicacionElegida);


        mMap.addMarker(new MarkerOptions()
                .position(miCasa)
                .title("Aqui es =D")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.icons_mapa_de_pin)));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(miCasa));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15f));

    }


    public LatLng DevoverUbicacion(int Lugar) {
        LatLng lugarAElegir;
        switch (Lugar) {
            case R.drawable.lacasa:
                lugarAElegir = new LatLng(6.243857456039854, -75.56097710256678);
                break;
            case R.drawable.sanfelix:
                lugarAElegir = new LatLng(6.3299317, -75.59723);
                break;
            case R.drawable.parquearvi:
                lugarAElegir = new LatLng(6.2884781, -75.5091282);
                break;
            case R.drawable.palermo:
                lugarAElegir = new LatLng(5.7329423, -75.6961252);
                break;
            default:
                lugarAElegir = new LatLng(6.243857456039854, -75.56097710256678);
                break;
        }
        return lugarAElegir;
    }

}
