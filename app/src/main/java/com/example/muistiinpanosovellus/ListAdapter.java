package com.example.muistiinpanosovellus;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    private final Context context;
    private ArrayList<Note> notes;

    public ListAdapter(Context context, ArrayList<Note> notes) {
        this.context = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(LayoutInflater.from(context).inflate(R.layout.list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.Title.setText(notes.get(position).getTitle());
        holder.NoteText.setText(notes.get(position).getNoteText());
        holder.editTitle.setText(notes.get(position).getTitle());
        holder.editNoteText.setText(notes.get(position).getNoteText());
        holder.dateText.setText(notes.get(position).getDateText());

        holder.removeImage.setOnClickListener(view -> {
            int pos = holder.getBindingAdapterPosition();
            Storage.getInstance().removeNote(notes.get(pos).getID());
            notifyItemRemoved(pos);
        });

        holder.editColor.setOnClickListener(view -> {
            int pos = holder.getBindingAdapterPosition();
            holder.itemView.setBackgroundColor(Color.RED);
        });


        holder.editImage.setOnClickListener(view -> {
            int pos = holder.getBindingAdapterPosition();

            if(holder.editTitle.getVisibility() == View.VISIBLE) {
                Note item = Storage.getInstance().getNotesByID(pos);
                item.setTitle(holder.editTitle.getText().toString());
                holder.editTitle.setVisibility(View.GONE);

                item.setNoteText(holder.editNoteText.getText().toString());
                holder.editNoteText.setVisibility(View.GONE);

                notifyDataSetChanged();
            }
            else {
                holder.editTitle.setVisibility(View.VISIBLE);
                holder.editNoteText.setVisibility(View.VISIBLE);
            }
        });


    }

    @Override
    public int getItemCount() {
        return notes.size();}

}
