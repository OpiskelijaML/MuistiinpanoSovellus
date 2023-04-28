package com.example.muistiinpanosovellus;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {
    ImageView removeImage, editImage, editColor;
    TextView Title, NoteText, dateText;
    EditText editTitle, editNoteText;
    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        Title = itemView.findViewById(R.id.inputNoteTitle);
        NoteText = itemView.findViewById(R.id.txtNote);
        removeImage = itemView.findViewById(R.id.imgRemove);
        editImage = itemView.findViewById(R.id.imgEdit);
        editColor = itemView.findViewById(R.id.imgColor);
        editTitle = itemView.findViewById(R.id.editTitle);
        editNoteText = itemView.findViewById(R.id.editNoteText);
        dateText = itemView.findViewById(R.id.textView);
    }
}
