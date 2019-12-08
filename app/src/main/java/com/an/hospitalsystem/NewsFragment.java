package com.an.hospitalsystem;

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
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import com.an.adapter.DrugReminderAdapter;
import com.an.adapter.NewsAdapter;
import com.an.model.DrugReminder;

public class NewsFragment extends Fragment {
    View view;
    ListView lvNews, lvDrugReminder;
    NewsAdapter newsAdapter;
    private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;
    DrugReminderAdapter drugReminderAdapter;

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
        lvDrugReminder=view.findViewById(R.id.lvDrugReminder);
        drugReminderAdapter= new DrugReminderAdapter(getActivity(),R.layout.itemdrug);
        lvDrugReminder.setAdapter(drugReminderAdapter);
    }

    private void addEvents() {
        lvDrugReminder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DrugReminder dr = drugReminderAdapter.getItem(position);
                Toast.makeText(getActivity(),dr.getDrugname(),Toast.LENGTH_LONG).show();
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
}

