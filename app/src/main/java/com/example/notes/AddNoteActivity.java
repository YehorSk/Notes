package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddNoteActivity extends AppCompatActivity {
    EditText noteName;
    EditText noteText;
    TextView noteDateCharacters;
    Integer curr_amm_of_char = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        setUI();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        noteDateCharacters.setText(simpleDateFormat.format(calendar.getTime()).toString() +" | "+noteText.length()+" characters");
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if(noteText.length()>curr_amm_of_char || noteText.length()<curr_amm_of_char){
                    curr_amm_of_char=noteText.length();
                    noteDateCharacters.setText(simpleDateFormat.format(calendar.getTime()).toString() +" | "+noteText.length()+" characters");
                }
                handler.postDelayed(this,100);
            }
        });
    }
    private void setUI(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        noteName = findViewById(R.id.noteName);
        noteText = findViewById(R.id.noteText);
        noteDateCharacters = findViewById(R.id.noteDate);

    }
}