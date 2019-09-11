package com.example.recyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewList extends AppCompatActivity {
    private ArrayList<Integer> jHsptIDs = new ArrayList<>();
    private ArrayList<String> jHsptNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_list);

        jHsptIDs.add(101);
        jHsptNames.add("Civil Hospital");
        jHsptIDs.add(110);
        jHsptNames.add("Sterling Hospital");
        jHsptIDs.add(204);
        jHsptNames.add("Govertment Hospital");

        RecyclerView recyclerView = findViewById(R.id.showHospitals);
        ListWithIDAdapter adapter = new ListWithIDAdapter(this, jHsptIDs, jHsptNames);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
