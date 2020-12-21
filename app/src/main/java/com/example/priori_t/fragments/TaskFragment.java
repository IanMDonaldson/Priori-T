package com.example.priori_t.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.example.priori_t.R;
import com.example.priori_t.model.TaskGenerator;
import com.example.priori_t.model.entity.Task;
import com.example.priori_t.view.TaskRecyclerAdapter;
import com.example.priori_t.view.viewholder.TaskViewHolder;

import java.util.List;

public class TaskFragment extends Fragment {
    private RecyclerView recyclerView;
    private TaskGenerator taskGen = new TaskGenerator();
    public static String DRAWABLE_RES;
    private List<Task> taskList = taskGen.taskGenerator(5,3);
    private LiveData<List<Task>> taskLiveData;

    public static TaskFragment newInstance(int drawableResIndex) {
        Bundle args = new Bundle();
        args.putInt(DRAWABLE_RES, drawableResIndex);
        TaskFragment taskFragment = new TaskFragment();
        taskFragment.setArguments(args);
        return taskFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedStateInstance) {
        View view = inflater.inflate(R.layout.day_ofweek, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        return view;
    }
}
