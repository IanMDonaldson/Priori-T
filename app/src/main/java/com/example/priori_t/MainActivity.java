package com.example.priori_t;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private ViewPagerAdapter pageAdapter;
    private TabLayout tabLayout;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        pageAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(pageAdapter);
    }

//TODO: implement recyclerview adapters for each day
    //todo: 01 implement room data persistence for tasks to populate and test stuff
}
