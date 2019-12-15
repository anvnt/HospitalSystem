package com.an.hospitalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PrescriptionFragment extends Fragment {
    View view;
    Button btnFind;
    ImageView imgPrescription;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_prescription, container, false);
        addControls();
        addEvents();
        return view;
    }

    private void addEvents() {
        //hiện đơn thuốc sau khi tìm mã đơn thuốc
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgPrescription.setImageResource(R.drawable.diabetesprescription);
            }
        });
    }

    public void addControls() {
        btnFind=view.findViewById(R.id.btnFind);
        imgPrescription=view.findViewById(R.id.imgPrescription);
    }


}
