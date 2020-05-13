package com.example.priori_t.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.priori_t.fragment.CalendarFragment;
import com.example.priori_t.fragment.TaskFragment;
import com.example.priori_t.fragment.WeekFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private final List<Fragment> fragList = new ArrayList<>();
    private final List<String> fragTitleList = new ArrayList<>();
    private static final int NUM_PAGES = 3;

    private static final int TASKS_FRAGMENT_IDX = 0;
    private static final int WEEK_FRAGMENT_IDX = 1;
    private static final int CALENDAR_FRAGMENT_IDX = 2;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case TASKS_FRAGMENT_IDX:
                return new TaskFragment();
            case WEEK_FRAGMENT_IDX:
                return new WeekFragment();
            case CALENDAR_FRAGMENT_IDX:
                return new CalendarFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
