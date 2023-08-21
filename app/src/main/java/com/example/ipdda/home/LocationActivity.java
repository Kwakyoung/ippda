package com.example.ipdda.home;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.ipdda.MainActivity;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityLocationBinding;
import com.example.ipdda.map.GPSTrackerActivity;
import com.example.ipdda.map.MapActivity;
import com.example.ipdda.map.WebViewActivity;
import com.example.ipdda.member.MemberVO;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.util.ArrayList;

public class LocationActivity extends AppCompatActivity  {

    private static final int PERMISSION_REQUEST_CODE = 123;

    String address;




    private LocationManager locationManager;
    private static final int REQUEST_CODE_LOCATION = 2;

    ActivityLocationBinding binding;

    private final ActivityResultLauncher<Intent> getSearchResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK){
                    if (result.getData() != null) {
                        String data = result.getData().getStringExtra("data");
                        address = data+"";
                        binding.edtSearch.setText(data);
                    }
                }
            }

    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLocationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        CommonConn addressConn = new CommonConn(this, "address/select");
        addressConn.addParamMap("member_no" , CommonVar.loginInfo.getMember_no());
        addressConn.onExcute((isResult, data) -> {
            ArrayList<AddressVO> arrayList = new Gson().fromJson(data, new TypeToken<ArrayList<AddressVO>>(){}.getType());
            AddressAdapter adapter = new AddressAdapter(arrayList, this);
            binding.recvAddress.setAdapter(adapter);
            binding.recvAddress.setLayoutManager(new LinearLayoutManager(this));
        });



        binding.imgvBack.setOnClickListener(v -> {
            finish();
        });


        binding.edtSearch.setOnClickListener(v -> {
            Intent intent = new Intent(this , WebViewActivity.class);
            getSearchResult.launch(intent);
        });



        binding.lnCurrentlocation.setOnClickListener(v -> {

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                // 권한이 이미 부여된 경우 위치 업데이트 시작
                startLocationUpdates();
                Intent intent = new Intent(this , MapActivity.class);
                startActivity(intent);
            } else {
                // 권한 요청
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_LOCATION);
            }

        });

        binding.btnSearch.setOnClickListener(v -> {
            if(address != null){
                CommonConn conn = new CommonConn(this, "address/insert");
                conn.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
                conn.addParamMap("delivery_address", address);
                conn.addParamMap("delivery_sub_address", binding.edtSubAddress.getText().toString());
                conn.onExcute((isResult, data) -> {


                });

                CommonConn updateConn = new CommonConn(this, "address/update");
                updateConn.addParamMap("member_address", address);
                updateConn.addParamMap("member_sub_address", binding.edtSubAddress.getText().toString());
                updateConn.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
                updateConn.onExcute((isResult, data) -> {
                    Intent intent = new Intent(this , MainActivity.class);
                    startActivity(intent);
                });



            }else {
                Toast.makeText(this, "주소를 입력해주세요", Toast.LENGTH_SHORT).show();
            }

        });

    }



    private void startLocationUpdates() {
        LocationActivity.MyLocationListener locationListener = new LocationActivity.MyLocationListener();
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
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();


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