package com.example.ipdda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.ipdda.databinding.ActivityMainBinding;
import com.example.ipdda.home.HomeFragment;
import com.example.ipdda.like.LikeFragment;
import com.example.ipdda.profile.ProfileActivity;
import com.example.ipdda.profile.ProfileFragment;
import com.example.ipdda.search.SearchFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
        if(item.getItemId() == R.id.page_1){
            manager.beginTransaction().replace(R.id.container , new HomeFragment()).commit();
        }else if (item.getItemId() == R.id.page_2) {
            manager.beginTransaction().replace(R.id.container , new SearchFragment()).commit();
        }else if (item.getItemId() == R.id.page_3) {
            manager.beginTransaction().replace(R.id.container , new LikeFragment()).commit();
        } else if (item.getItemId() == R.id.page_4) {
            manager.beginTransaction().replace(R.id.container, new ProfileFragment()).commit();
        }
        return true;

        });


    }
}