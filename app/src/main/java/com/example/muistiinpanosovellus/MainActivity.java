package com.example.muistiinpanosovellus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Storage storage;

    private RecyclerView recyclerView;
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage = Storage.getInstance();

        recyclerView = findViewById(R.id.rvListItems);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter(getApplicationContext(), (ArrayList<Note>) storage.getNotes());
        recyclerView.setAdapter(adapter);

        storage.loadNotes(this.getDataDir().getPath());
    }

    public void switchToAddNote(View view) {
        startActivity(new Intent(this, AddNote_Activity.class));
    }

    @Override
    protected void onResume() { //IMPORTANT
        super.onResume();
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        storage.saveNotes(this.getDataDir().getPath());
    }
}
