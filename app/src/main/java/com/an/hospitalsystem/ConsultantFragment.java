package com.an.hospitalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ConsultantFragment extends Fragment {
    View view;
    Button btnConsult;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_consultant, container, false);
        addControls();
        addEvents();
        return view;
    }

    private void addEvents() {
        btnConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new ConsultantResultFragment());
                fragmentTransaction.commit();
            }
        });
    }

    public void addControls() {
        btnConsult=view.findViewById(R.id.btnConsult);
    }


}
