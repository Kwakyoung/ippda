package com.example.ipdda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.ipdda.databinding.ActivityMainBinding;
import com.example.ipdda.home.HomeFragment;
import com.example.ipdda.like.LikeFragment;
import com.example.ipdda.profile.ProfileFragment;
import com.example.ipdda.search.SearchFragment;

public class MainActivity extends AppCompatActivity {

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

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
        if(item.getItemId() == R.id.page_1){
            fragment = homeFragment;
        }else if (item.getItemId() == R.id.page_2) {
            fragment = searchFragment;
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






}