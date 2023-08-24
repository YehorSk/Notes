package com.example.notes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Note {
    private String name;
    private String text;
    private final String date;

    public Note(String name, String text){
        this.name = name;
        this.text = text;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE LLLL yyyy");
        this.date = simpleDateFormat.format(calendar.getTime()).toString();

    }

    public String getName(){ return this.name; }
    public String getDate(){ return this.date; }
    public String getText(){ return this.text; }
    public void setName(String name){this.name= name;}
    public void setText(String text){this.text = text;}
}
