package com.example.priori_t.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.priori_t.R;
import com.example.priori_t.model.database.entity.Task;

public class DueDayPickerFragment extends Fragment {
    private onDueDayBtnListener listener;
    public abstract interface onDueDayBtnListener{
        void onButtonClicked(Task task);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.day_picker_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        Button dialog = view.findViewById(R.id.buttonCustomTime);
        Button firstDay = view.findViewById(R.id.buttonTime1);
        Button secondDay = view.findViewById(R.id.buttonTime2);
        Button thirdDay = view.findViewById(R.id.buttonTime3);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO make dialog pop up

            }
        });
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof onDueDayBtnListener) {
            listener = (onDueDayBtnListener) context;
        }
    }

}
