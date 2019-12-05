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

public class ConsultantResultFragment extends Fragment {
    View view;
    Button btnPrescription, btnPrediction, btnBooking;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_consultantresult,container,false);
        addControls();
        addEvents();
        return view;
    }

    private void addControls() {
        btnPrescription=view.findViewById(R.id.btnPrescription);
        btnPrediction=view.findViewById(R.id.btnPrediction);
        btnBooking=view.findViewById(R.id.btnBooking);
    }
    private void addEvents() {
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mở màn hình Booking Fragment
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new BookingFragment());
                fragmentTransaction.commit();
            }
        });
    }

}
