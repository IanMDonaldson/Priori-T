package com.example.priori_t.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.priori_t.R;

import com.example.priori_t.TaskViewModel;
import com.example.priori_t.model.TaskDB;
import com.example.priori_t.model.TaskRepository;
import com.example.priori_t.model.entity.Task;
import com.example.priori_t.fragments.CalendarFragment;
import com.example.priori_t.fragments.TaskFragment;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Task> taskEntities;
    private TaskDB taskDB;
    private TaskRepository taskRepository;
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private AppBarLayout appBar;
    private FragmentManager fragmentManager;
    private FragmentStateAdapter pageAdapter;
    private TaskFragment taskFragment;
    private CalendarFragment calendarFragment;
    private ArrayList<Fragment> fragments;
    private ImageButton taskAddButton;
    private ConstraintLayout activityContainer;
    static Task newTask = new Task();
    private TaskViewModel vm;

    final int TASK_REQUEST = 1;
    final static String TASK_FRAGMENT = "TaskFragment";
    public static void getAddTaskResult(Task task) {

    }
    //TODO: recyclerview Adapter needs to be set here or..in taskFragment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityContainer = findViewById(R.id.activity_container);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        this.taskAddButton = findViewById(R.id.button_task_add);

        pageAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pageAdapter);
        this.vm = new ViewModelProvider(this).get(TaskViewModel.class);
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        onTabNameSet(tab,position);
                    }
                }).attach();
        this.taskAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //send data to activity handling adding task
               onAddTaskClicked(viewPager, tabLayout);

            }
        });
    }
    public void onAddTaskClicked(View viewPager, View tabLayout) {
        TaskAddFragment taskAddFragment = new TaskAddFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        viewPager.setVisibility(View.GONE);
        tabLayout.setVisibility(View.GONE);
        ft.remove(taskFragment);

        ft.replace(R.id.activity_container, new TaskAddFragment()).addToBackStack(TASK_FRAGMENT);

        ft.commit();
        getSupportFragmentManager().executePendingTransactions();
    }
    public void onSaveButtonClicked() {
        activityContainer = findViewById(R.id.activity_container);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        this.taskAddButton = findViewById(R.id.button_task_add);

        pageAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pageAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        onTabNameSet(tab,position);
                    }
                }).attach();
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
                case TASK_FRAGMENT_ID:
                    taskFragment = new TaskFragment();
                    return taskFragment;
                case CALENDAR_FRAGMENT_ID:
                    calendarFragment = new CalendarFragment();
                    return calendarFragment;
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
    //RECEIVES DATA FROM TASK ADD ACTIVITY
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
            //add the new task to the list shown by recyclerview in taskFragment
        Task task = getIntent().getParcelableExtra("newTask");

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
