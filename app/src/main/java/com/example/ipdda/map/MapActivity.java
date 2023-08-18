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
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityMapBinding;
import com.google.android.gms.location.LocationListener;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraUpdate;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapSdk;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.LocationTrackingMode;

import java.util.Map;

public class MapActivity extends AppCompatActivity  implements  OnMapReadyCallback, android.location.LocationListener  {

    private MapView mapView;
    private NaverMap naverMap;
    ActivityMapBinding binding;

    int REQUEST_CODE_LOCATION = 1;

     double latitude;  // 추가
     double longitude; // 추가

    private Marker marker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.mapView.getMapAsync(this);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // 권한이 이미 부여된 경우 위치 업데이트 시작
            startLocationUpdates();
        } else {
            // 권한 요청
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION);
        }



    }


    public void startLocationUpdates() {
        MapActivity locationListener = new MapActivity();
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (locationManager != null) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10L, (float) 1, locationListener);
        }
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        this.naverMap = naverMap;



        // 원하는 좌표 생성 (예시: 서울 시청 좌표)
        LatLng initialLatLng = new LatLng(latitude, latitude);

        // 초기 마커 설정
        marker = new Marker();
        marker.setPosition(initialLatLng);
        marker.setMap(naverMap);

        // 초기 카메라 이동
        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(initialLatLng);
        naverMap.moveCamera(cameraUpdate);

        // 원하는 좌표 생성

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {


         if(location.getLatitude()!= latitude && location.getLongitude() != longitude){

             latitude = location.getLatitude();
             longitude = location.getLongitude();
        LatLng initialLatLng = new LatLng(latitude, latitude);
        CameraUpdate cameraUpdate = CameraUpdate.scrollTo(initialLatLng);
        naverMap.moveCamera(cameraUpdate);
         }

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


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_LOCATION && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // 권한이 부여된 경우 위치 업데이트 시작
            startLocationUpdates();
        }
    }

}