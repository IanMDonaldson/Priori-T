package com.example.priori_t.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.priori_t.R;

public class CalendarFragment extends Fragment {
    //todo define click listeners here
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedStateInstance) {
        View view = inflater.inflate(R.layout.day_ofweek, container, false);
        return view;
    }
}
