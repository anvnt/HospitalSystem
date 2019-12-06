package com.an.hospitalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ProfileFragment extends Fragment {
    TextView txtAnamnesis, txtFamilyContact, txtDrugAllergy, txtCard, txtSupportCenter, txtAboutUs;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_profiles,container,false);
        addControls();
        addEvents();
        return view;
    }

    private void addEvents() {
        txtAnamnesis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new AnamnesisFragment());
                fragmentTransaction.commit();
            }
        });
    }

    private void addControls() {
        txtAnamnesis=view.findViewById(R.id.txtAnamnesis);
    }
}
