package com.example.priori_t.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.priori_t.R;
import com.example.priori_t.ui.adapter.ViewPagerAdapter;
import com.example.priori_t.model.database.entity.Task;
import com.example.priori_t.model.database.TaskDB;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public List<Task> taskEntities;
    private ViewPager2 viewPager;
    private ViewPagerAdapter pageAdapter;
    private TabLayout tabLayout;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testdb);
//        tasks = db.getTaskDao().getAllTasks(); //TODO: implement taskdao to retrieve subtask list
//
//        viewPager = findViewById(R.id.viewPager);
//        pageAdapter = new ViewPagerAdapter(this);
//        viewPager.setAdapter(pageAdapter);
         final TaskDB db = Room.databaseBuilder(
                getApplicationContext(),
                TaskDB.class,
                "task-database").build();
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
//
//                db.getTaskDao().addTask(new Task(todoSt, date, time));
//            }
//        });
    }



    //todo: 01 implement room data persistence for tasks to populate and test stuff
}