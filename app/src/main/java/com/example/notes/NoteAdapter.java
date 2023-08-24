package com.example.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {

    private final AdapterInterface adapterInterface;
    private ArrayList<Note> notes;
    Context context;
    public NoteAdapter(Context context,  ArrayList<Note> notes,AdapterInterface adapterInterface){
        this.context = context;
        this.notes = notes;
        this.adapterInterface = adapterInterface;
    }
    @NonNull
    @Override
    public NoteAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_recycler_item,parent,false);
        return new NoteAdapter.MyViewHolder(view,adapterInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.MyViewHolder holder, int position) {
        holder.name.setText(notes.get(position).getName());
        holder.text.setText(notes.get(position).getText());
        holder.date.setText(notes.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView text;
        TextView date;
        public MyViewHolder(@NonNull View itemView,AdapterInterface adapterInterface) {
            super(itemView);
            name = itemView.findViewById(R.id.note_name);
            text = itemView.findViewById(R.id.note_text);
            date = itemView.findViewById(R.id.note_date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(adapterInterface != null){
                        int pos = getAdapterPosition();
                        if(pos!= RecyclerView.NO_POSITION){
                            adapterInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
