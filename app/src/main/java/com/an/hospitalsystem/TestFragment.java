package com.an.hospitalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.an.adapter.TestAdapter;
import com.an.model.Test;

public class TestFragment extends Fragment {
    View view;
    ListView lvTest;
    TestAdapter testAdapter;
    LinearLayout btnConsultancyResult, btnPrescription, btnBooking;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_test, container, false);
        addControls();
        addEvents();
        fakeData();
        return view;
    }

    private void fakeData() {
        //
        testAdapter.add(new Test(R.drawable.test1,"Glucose test"));
        testAdapter.add(new Test(R.drawable.test2,"Blood glucose monitoring"));
        testAdapter.add(new Test(R.drawable.test3,"Homeostatic model assessment"));
        testAdapter.add(new Test(R.drawable.test2,"Hemoglobin A1C"));
        testAdapter.add(new Test(R.drawable.test5,"Postprandial glucose test"));
        testAdapter.add(new Test(R.drawable.test6,"Glucose clamp technique"));
        testAdapter.add(new Test(R.drawable.test2,"Glucose tolerance test"));
        testAdapter.add(new Test(R.drawable.test2,"Blood ketones test"));
        testAdapter.add(new Test(R.drawable.test9,"Fluid deprivation test"));


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
        btnPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new TestFragment());
                fragmentTransaction.commit();
            }
        });
        btnConsultancyResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new PrescriptionFragment());
                fragmentTransaction.commit();
            }
        });
    }

    public void addControls() {
        lvTest=view.findViewById(R.id.lvTest);
        testAdapter=new TestAdapter(getActivity(),R.layout.itemtest);
        lvTest.setAdapter(testAdapter);
        btnConsultancyResult=view.findViewById(R.id.btnConsultancyResult);
        btnPrescription=view.findViewById(R.id.btnPrescription);
        btnBooking=view.findViewById(R.id.btnBooking);

    }


}
