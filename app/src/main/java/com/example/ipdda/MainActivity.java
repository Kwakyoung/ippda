package com.example.ipdda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ipdda.databinding.ActivityMainBinding;
import com.example.ipdda.delivery.DeliveryFragment;
import com.example.ipdda.home.HomeFragment;
import com.example.ipdda.like.LikeFragment;
import com.example.ipdda.packaging.PackagingFragment;
import com.example.ipdda.profile.ProfileFragment;
import com.example.ipdda.search.SearchFragment;
import com.example.ipdda.search.URLConnector;

public class MainActivity extends AppCompatActivity {
    private TextView txtv1;
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

        setContentView(R.layout.activity_main);

        txtv1 = findViewById(R.id.txtv1);

        // 백그라운드 스레드에서 웹 서버로 요청을 보냄.
        new Thread(new Runnable() {
            @Override
            public void run() {
                String test = "http://192.168.0.14/MediumServer/SelectAllPost.php";
                URLConnector task = new URLConnector(test);

                task.start();

                try {
                    task.join(); // 요청이 완료될 때까지 대기
                    System.out.println("waiting... for result");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                final String result = task.getResult();

                // UI 업데이트를 위해 UI 스레드로 돌아감
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        txtv1.setText(result); // 결과를 TextView에 표시
                    }
                });
            }
        }).start();




        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
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
    public void changeFragment(int backPressed, Fragment fragment){
        this.backPressed = backPressed;
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
//    @Override
//    public void onBackPressed() {
//        if(backPressed==1){
//            changeFragment(0 , homeFragment );
//        }else if (backPressed==2){
//            changeFragment(1 , searchFragment );
//        }else {
//            finish();
//        }
//    }


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