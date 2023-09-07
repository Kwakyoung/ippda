package com.example.ipdda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ActivityMainBinding;
import com.example.ipdda.delivery.DeliveryFragment;
import com.example.ipdda.home.HomeFragment;
import com.example.ipdda.like.LikeFragment;
import com.example.ipdda.packaging.PackagingFragment;
import com.example.ipdda.profile.NotificationService;
import com.example.ipdda.profile.ProfileFragment;
import com.example.ipdda.search.SearchFragment;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    private boolean doubleBackToExitPressedOnce = false;
    ActivityMainBinding binding;
    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    LikeFragment likeFragment = new LikeFragment();
    ProfileFragment profileFragment = new ProfileFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        if ("Y".equals(CommonVar.loginInfo.getPopup())) {
            startService(new Intent(MainActivity.this, NotificationService.class));
        }

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment;
        if(item.getItemId() == R.id.page_1){
            fragment = homeFragment;
            backPressed=1;
        }else if (item.getItemId() == R.id.page_2) {
            fragment = searchFragment;
            backPressed=2;
        }else if (item.getItemId() == R.id.page_3) {
            fragment = likeFragment;
        } else if (item.getItemId() == R.id.page_4) {
            fragment = profileFragment;
        }else {
            return false;
        }

        if(fragment == null){
            Toast.makeText(this, "아직 준비되지 않았습니다.", Toast.LENGTH_SHORT).show();
        }else {
            manager.beginTransaction().replace(R.id.container,fragment).commit();
        }
        return true;
        });


    }


    int backPressed = 0;


    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.container);

        if (currentFragment instanceof HomeFragment) {
            ((HomeFragment) currentFragment).handleBackPressed();
        } else if (currentFragment instanceof SearchFragment) {
            ((SearchFragment) currentFragment).handleBackPressed();
        } else if (currentFragment instanceof LikeFragment) {
            ((LikeFragment) currentFragment).handleBackPressed();
        } else if (currentFragment instanceof ProfileFragment) {
            ((ProfileFragment) currentFragment).handleBackPressed();
        }else if (currentFragment instanceof DeliveryFragment) {
            ((DeliveryFragment) currentFragment).handleBackPressed();
        }else if (currentFragment instanceof PackagingFragment) {
            ((PackagingFragment) currentFragment).handleBackPressed();
        } else {
            super.onBackPressed();
        }

    }



}