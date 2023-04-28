package com.example.muistiinpanosovellus;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddNote_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
    }

    public void addNote(View view) {
        EditText headline = findViewById(R.id.id_headline);
        EditText noteText = findViewById(R.id.id_inputNote);
        Note note = new Note(headline.getText().toString(), noteText.getText().toString());
        Storage.getInstance().addNote(note);

    }


}