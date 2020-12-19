package com.example.priori_t.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.priori_t.R;

public class TaskFragment extends Fragment {
//    public static String DRAWABLE_RES;
//    public static TaskFragment newInstance(int drawableResIndex) {
//        Bundle args = new Bundle();
//        args.putInt(DRAWABLE_RES, drawableResIndex);
//        TaskFragment taskFragment = new TaskFragment();
//        taskFragment.setArguments(args);
//        return taskFragment;
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Bundle args = getArguments();
//        mDrawableRes = args.getInt(DRAWABLE_RES);
//    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedStateInstance) {
        View view = inflater.inflate(R.layout.day_ofweek, container, false);
        return view;
    }
}
