package com.example.priori_t.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.priori_t.fragments.TaskFragment;

public class TaskTabAdapter extends FragmentStatePagerAdapter {
    public TaskTabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return new TaskFragment();
    }

    @Override
    public int getCount() {
        return 0;
    }
}
