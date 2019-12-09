package com.an.hospitalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ConsultantResultFragment extends Fragment {
    View view;
    LinearLayout btnPrescription, btnPrediction, btnBooking;
    TextView txt29,txt33;
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
        txt29=view.findViewById(R.id.textView29);
        txt29.setText("Extreme fatigue, drowsiness and physical weakness\nIncreased hunger\nIncreased thirst\nIncreased urine volume and frequency\nLoss or gain of weight without a clear cause\nBlurry vision\nPoor wound healing"+
                "Infection of the genitals, gums or skin\nTingling in hands and feet");
        txt33=view.findViewById(R.id.textView33);
        txt33.setText("Diet too high in carbohydrates or unbalanced\n" +
                "A sedentary life\n" +
                "Insufficient insulin and / or antidiabetic drugs\n" +
                "Weight too high");
    }
    private void addEvents() {
        //đang lỗi
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
