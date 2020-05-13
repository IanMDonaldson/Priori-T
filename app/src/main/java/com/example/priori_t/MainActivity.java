package com.example.priori_t;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.priori_t.adapter.ViewPagerAdapter;
import com.example.priori_t.model.Task;
import com.example.priori_t.model.TaskDB;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Task> tasks;
    private ViewPager2 viewPager;
    private ViewPagerAdapter pageAdapter;
    private TabLayout tabLayout;
    private FragmentManager fragmentManager;
    TaskDB db = Room.databaseBuilder(
            getApplicationContext(),
            TaskDB.class,
            "task-database").build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tasks = db.getTaskDao().getAllTasks(); //TODO: implement taskdao to retrieve subtask list

        viewPager = findViewById(R.id.viewPager);
        pageAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(pageAdapter);
    }



    //todo: 01 implement room data persistence for tasks to populate and test stuff
}
