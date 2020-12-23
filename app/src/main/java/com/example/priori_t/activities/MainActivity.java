package com.example.priori_t.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.priori_t.R;

import com.example.priori_t.model.converter.DateConverter;
import com.example.priori_t.model.entity.Subtask;
import com.example.priori_t.model.entity.Task;
import com.example.priori_t.fragments.CalendarFragment;
import com.example.priori_t.fragments.TaskFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {
    public List<Task> taskEntities;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBar;
    private FragmentManager fragmentManager;
    private FragmentStateAdapter pageAdapter;
    private TaskFragment taskFragment;
    private CalendarFragment calendarFragment;
    private ArrayList<Fragment> fragments;

    //TODO: recyclerview Adapter needs to be set here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

//        appBar = findViewById(R.id.appBar);
//        fragments = new ArrayList<>();
//        fragments.add(new TaskFragment());
//        fragments.add(new CalendarFragment());

        pageAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pageAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        onTabNameSet(tab,position);
                    }
                });
    }
    private void onTabNameSet(TabLayout.Tab tab, int position) {
        String[] tabNames = getResources().getStringArray(R.array.tab_names);
        tab.setText(tabNames[position]);
    }
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        private static final int NUM_PAGES = 2;
        private static final int TASK_FRAGMENT_ID = 0;
        private static final int CALENDAR_FRAGMENT_ID = 1;
        public ScreenSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
//                case 0:
//                    return TaskFragment.newInstance(R.layout.task_fragment);
                case TASK_FRAGMENT_ID:
                    return new TaskFragment();
                case CALENDAR_FRAGMENT_ID:
                    return new CalendarFragment();
                default:
                    break;
            }
            return null;
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

}

//        tasks = db.getTaskDao().getAllTasks();
//
//        viewPager = findViewById(R.id.viewPager);
//        pageAdapter = new ViewPagerAdapter(this);
//        viewPager.setAdapter(pageAdapter);
//
//
//        final TextInputEditText todo = findViewById(R.id.todo);
//        final TextInputEditText due = findViewById(R.id.due);
//        final TextInputEditText ttc = findViewById(R.id.ttc);
//        MaterialButton send = findViewById(R.id.send);
//        send.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String todoSt = todo.getText().toString();
//                String date = due.getText().toString();
//                int time = Integer.parseInt(ttc.getText().toString());
//            }
//        });
