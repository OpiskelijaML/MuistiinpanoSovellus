package com.example.muistiinpanosovellus;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Note implements Comparable<Note>, Serializable {
    private String Title;
    private String NoteText;
    private final String ID;

    private final Date dateAdded;

    public Note (String Title, String NoteText) {
        this.Title = Title;
        this.NoteText = NoteText;
        this.ID = UUID.randomUUID().toString();
        this.dateAdded = new Date();
    }

    public String getTitle() {return Title;}

    public String getNoteText() {return NoteText;}

    public String getDateText() {return dateAdded.toLocaleString();}
    public String getID() {return ID;}

    public void setTitle(String Title) {this.Title = Title;}

    public void setNoteText(String NoteText) {this.NoteText = NoteText;}

    public void setDateText(String NoteText) {this.NoteText = NoteText;}
    public Date getDateAdded(){return dateAdded;}

    @Override
    public int compareTo(Note other) {
        return this.dateAdded.compareTo(other.getDateAdded());
    }

}
