package com.example.ipdda.map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityGpstrackerBinding;
import com.google.android.gms.location.LocationListener;

public class GPSTrackerActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_LOCATION = 1;

    ActivityGpstrackerBinding binding;

    MapActivity mapActivity;


    double latitude;

    double longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGpstrackerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // 권한이 이미 부여된 경우 위치 업데이트 시작
            startLocationUpdates();
        } else {
            // 권한 요청
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION);
        }

    }


    private void startLocationUpdates() {
        MyLocationListener locationListener = new MyLocationListener();
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (locationManager != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10L, (float) 1, locationListener);
        }
    }

    private class MyLocationListener implements android.location.LocationListener {
        @Override
        public void onLocationChanged(@NonNull Location location) {
             latitude = location.getLatitude();
             longitude = location.getLongitude();



            binding.latitudeTextView.setText(latitude+"");
            binding.longitudeTextView.setText(longitude+"");



        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_LOCATION && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // 권한이 부여된 경우 위치 업데이트 시작
            startLocationUpdates();
        }
    }


}