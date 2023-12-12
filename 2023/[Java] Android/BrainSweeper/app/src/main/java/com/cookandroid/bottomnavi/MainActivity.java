package com.cookandroid.bottomnavi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰
    private FragmentManager fm;
    private FragmentTransaction ft;
    private frag1 frag1;
    private frag2 frag2;
    private frag3 frag3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch ((item.getItemId())) {
                    case R.id.add_task:
                        setFrag(1);
                        break;
                    case R.id.oranize_task:
                        setFrag(2);
                        break;
                    case R.id.list_task:
                        setFrag(3);
                        break;
                }
                return true;
            }
        });
        frag1 = new frag1();
        frag2 = new frag2();
        frag3 = new frag3();
        setFrag(1); // 첫 프래그먼트 화면을 무엇으로 지정할것인지 선택
    }

    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n) {
            case 1:
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
        }
    }
}