package com.an.hospitalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DrugAllergyFragment extends Fragment {
    View view;
    Spinner spReactionType, spCertainty, spSeverity;
    ArrayAdapter<String> adapter, adapterCertainty, adapterSeverity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_drugallergy, container, false);
        addControls();
        addEvents();
        return view;
    }

    private void addEvents() {

    }

    public void addControls() {
        spReactionType=view.findViewById(R.id.spReactionType);
        adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item);
        adapter.add("Allergy");
        adapter.add("Non Allergy");
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spReactionType.setAdapter(adapter);
        //certainty
        spCertainty=view.findViewById(R.id.spCertainty);
        adapterCertainty=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item);
        adapterCertainty.add("Likely");
        adapterCertainty.add("Very likely");
        adapterCertainty.add("Unlikely");
        adapterCertainty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCertainty.setAdapter(adapterCertainty);
        //severity
        spSeverity=view.findViewById(R.id.spSeverity);
        adapterSeverity=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item);
        adapterSeverity.add("Moderate");
        adapterSeverity.add("Low");
        adapterSeverity.add("Major");
        adapterSeverity.add("Critical");
        adapterSeverity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSeverity.setAdapter(adapterSeverity);
    }


}
