package com.an.hospitalsystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.an.model.Symptoms;

public class ConsultantFragment extends Fragment {
    View view;
    ListView lvSymptom;
    Button btnConsult;
    AutoCompleteTextView autoCompleteSymptom;
    ArrayAdapter<String>symptomAdapter;
    ArrayAdapter<Symptoms>listviewsymptomAdapter;
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

        //xử lý khi click vào 1 item trong autocompletetextview
        autoCompleteSymptom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                xuLyThemSymptoms();
                autoCompleteSymptom.setText("");
            }
        });

        lvSymptom.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Symptoms s = listviewsymptomAdapter.getItem(position);
                listviewsymptomAdapter.remove(s);
                return false;
            }
        });
    }

    private void xuLyThemSymptoms() {
        Symptoms s=new Symptoms();
        //lấy data từ autocompletetextview
        s.setSymptoms(autoCompleteSymptom.getText().toString());
        //đẩy data vào listview bên dưới
        listviewsymptomAdapter.add(s);
    }

    public void addControls() {
        //autocompletetextview: tự động gợi ý nhập liệu
        autoCompleteSymptom=view.findViewById(R.id.autoCompleteSymptom);
        symptomAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1); //hiển thị dữ liệu
        autoCompleteSymptom.setAdapter(symptomAdapter);
        symptomAdapter.addAll(getResources().getStringArray(R.array.arrSymptoms)); //lấy dữ liệu từ strings.xml

        //listview hiện symptoms mới nhập
        lvSymptom=view.findViewById(R.id.lvSymptoms);
        listviewsymptomAdapter=new ArrayAdapter<Symptoms>(getActivity(),android.R.layout.simple_list_item_1);
        lvSymptom.setAdapter(listviewsymptomAdapter);

        //button consult
        btnConsult=view.findViewById(R.id.btnConsult);
    }
}
