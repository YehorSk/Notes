package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterInterface {
    RecyclerView notesRecyclerView;
    ArrayList<Note> notes = new ArrayList<>();
    FloatingActionButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillNotes();
        setUI();
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddNoteActivity.class);
                startActivity(intent);
            }
        });
    }


    private void setUI(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("All Notes");
        setSupportActionBar(toolbar);
        notesRecyclerView = findViewById(R.id.NotesRecyclerView);
        NoteAdapter noteAdapter = new NoteAdapter(this,notes,this);
        notesRecyclerView.setAdapter(noteAdapter);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        addBtn = (FloatingActionButton) findViewById(R.id.addBtn);
    }

    private void fillNotes(){
        notes.add(new Note("Lorem ipsum","Lorem ipsum dolor sit amet"));
        notes.add(new Note("Lorem ipsum","Lorem ipsum dolor sit amet amer ipsum"));
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this,NoteActivity.class);
        intent.putExtra("name",notes.get(position).getName());
        intent.putExtra("text",notes.get(position).getText());
        intent.putExtra("date",notes.get(position).getDate());
        startActivity(intent);
    }
}