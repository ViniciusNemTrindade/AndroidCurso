package com.vinicius.applocalizacao;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int FINE_LOCATION_REQUEST_CODE = 1000;
    private FusedLocationProviderClient locationClient;
//  private LocationRequest mLocationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(MapsActivity.this);
        preparaServicoLocalizacao();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mostreMeALocalizacaoAtualDoUsuario();
    }

    private void meDePermissaoParaAcessarLocalizacao() {

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, FINE_LOCATION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == FINE_LOCATION_REQUEST_CODE) {

            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mostreMeALocalizacaoAtualDoUsuario();
            } else {

                Toast.makeText(this, "O usuário nos negou acesso a Localização", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void mostreMeALocalizacaoAtualDoUsuario() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            meDePermissaoParaAcessarLocalizacao();

        } else {

//            mMap.clear();
//
//            if (mLocationRequest == null) {
//
//                mLocationRequest = LocationRequest.create();
//
//                if (mLocationRequest != null ) {
//
//                    mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//                    mLocationRequest.setInterval(5000);
//                    mLocationRequest.setFastestInterval(1000);
//
//                    LocationCallback locationCallback = new LocationCallback() {
//
//
//                        @Override
//                        public void onLocationResult(LocationResult locationResult) {
//
//                            mostreMeALocalizacaoAtualDoUsuario();
//                        }
//                    };
//
//                    locationClient.requestLocationUpdates(mLocationRequest, locationCallback, null);
//                }
//            }

            mMap.setMyLocationEnabled(true);

            locationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {

                    Location location = task.getResult();
                    if (location != null) {
                        LatLng latLng = new LatLng(location.getLatitude(), location.getLatitude());

                        //mMap.addMarker(new MarkerOptions().position(latLng).title("Aqui, é sua atual localização!"));
                        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 0.0f);
                        mMap.moveCamera(cameraUpdate);
                    } else {

                        Toast.makeText(MapsActivity.this, "Ocorreu um erro! Tente novamente", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void preparaServicoLocalizacao() {

        locationClient = LocationServices.getFusedLocationProviderClient(MapsActivity.this);

    }


}