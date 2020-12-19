package com.example.priori_t.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public abstract class BasicActivity extends AppCompatActivity {
    public void addFragment(FragmentManager fragmentManager,
                            Fragment fragment,
                            int viewID,
                            String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(viewID, fragment, tag);
        fragmentTransaction.commit();
    }
}
