package com.an.hospitalsystem;

import android.app.DatePickerDialog;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import com.an.adapter.DrugReminderAdapter;
import com.an.adapter.NewsAdapter;
import com.an.model.DrugReminder;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewsFragment extends Fragment {
    View view;
    ListView lvNews, lvDrugReminder;
    NewsAdapter newsAdapter;
    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;
    DrugReminderAdapter drugReminderAdapter;
    Calendar calendarDate=Calendar.getInstance();
    SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
    TextView txtDate;
    String today=sdfDate.format(System.currentTimeMillis());
    Spinner spTime;
    ArrayAdapter <String>adapter;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_news,container,false);
        setHasOptionsMenu(true); // Add this!
        addControls();
        addEvents();
        fakedata();
        return view;

    }

    private void fakedata() {
        drugReminderAdapter.add(new DrugReminder(R.drawable.pacman3,"Paracetamol",R.drawable.likeblank));
        drugReminderAdapter.add(new DrugReminder(R.drawable.pacman1,"Oxymetazolin",R.drawable.likeblank));
        drugReminderAdapter.add(new DrugReminder(R.drawable.pacman2,"Codein",R.drawable.likeblank));

    }

    private void addControls() {
        txtDate=view.findViewById(R.id.txtDate);
        txtDate.setText("Today, "+today);
        lvDrugReminder=view.findViewById(R.id.lvDrugReminder);
        drugReminderAdapter= new DrugReminderAdapter(getActivity(),R.layout.itemdrug);
        lvDrugReminder.setAdapter(drugReminderAdapter);
      /*  spTime=view.findViewById(R.id.spTime);
        adapter=new ArrayAdapter<String>(view.getContext(),android.R.layout.simple_spinner_item);
        adapter.add("Morning");
        adapter.add("Noon");
        adapter.add("Afternoon");
        adapter.add("Evening");
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTime.setAdapter(adapter);*/

    }
    private void addEvents() {
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moManHinhDatePickerDialog();
            }
        });
        lvDrugReminder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DrugReminder dr = drugReminderAdapter.getItem(position);
                //Toast.makeText(getActivity(),dr.getDrugname(),Toast.LENGTH_SHORT).show();
                //Change like image from blank to fill (successful) and from fill to blank (failed)
                if (dr.getImglikeblank()==R.drawable.like){
                    dr.setImglikeblank(R.drawable.likeblank);            }
                else if (dr.getImglikeblank()==R.drawable.likeblank) {
                    dr.setImglikeblank(R.drawable.like);
                }
                //Change like image
                dr.setImglikeblank(R.drawable.like);
                //Notify adapter about changing of model list
                drugReminderAdapter.notifyDataSetChanged();
            }
        });
    }

    //Nút search
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.mnuSearch);
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);

        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

            queryTextListener = new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextChange(String newText) {

                    return true;
                }
                @Override
                public boolean onQueryTextSubmit(String query) {

                    return true;
                }
            };
            searchView.setOnQueryTextListener(queryTextListener);
        }

        super.onCreateOptionsMenu(menu, inflater);
    }

    //date picker
    private void moManHinhDatePickerDialog() {
        DatePickerDialog.OnDateSetListener callBack = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarDate.set(Calendar.YEAR,year);
                calendarDate.set(Calendar.MONTH,month);
                calendarDate.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                String currentdate = sdfDate.format(System.currentTimeMillis());
                String date = sdfDate.format(calendarDate.getTime());
                if (date.compareTo(currentdate)==0){
                txtDate.setText("Today morning, "+date);
            }
                else {
                    txtDate.setText("Morning, " + date);

                }}};

        DatePickerDialog dialog=new DatePickerDialog(
                view.getContext(),
                callBack,
                calendarDate.get(Calendar.YEAR),
                calendarDate.get(Calendar.MONTH),
                calendarDate.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    };

}


