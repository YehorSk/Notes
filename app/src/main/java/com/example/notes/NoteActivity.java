package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class NoteActivity extends AppCompatActivity {
    TextView name;
    TextView text;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        setUI();
        name.setText(getIntent().getStringExtra("name"));
        text.setText(getIntent().getStringExtra("text"));
        date.setText(getIntent().getStringExtra("date"));
    }

    private void setUI(){
        name = findViewById(R.id.name);
        text = findViewById(R.id.text);
        date = findViewById(R.id.date);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Note");
        setSupportActionBar(toolbar);
    }
}