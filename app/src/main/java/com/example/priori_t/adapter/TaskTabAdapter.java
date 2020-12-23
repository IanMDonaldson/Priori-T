package com.example.priori_t.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.priori_t.fragments.TaskFragment;

import java.util.ArrayList;

public class TaskTabAdapter extends FragmentStatePagerAdapter {
    Context context;
    ArrayList<Fragment> fragments;
    public TaskTabAdapter(@NonNull FragmentManager fm, int behavior, Context context, ArrayList<Fragment> fragments) {
        super(fm, behavior);
        this.context = context;
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new TaskFragment();
    }

    @Override
    public int getCount() {
        return -1;
    }
}
