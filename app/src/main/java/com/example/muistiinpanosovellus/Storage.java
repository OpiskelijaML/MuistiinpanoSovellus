package com.example.muistiinpanosovellus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    ArrayList<Note> notes = new ArrayList<>();
    ArrayList<Note> backupNotes = new ArrayList<>();
    private static Storage storage = null;

    private Storage() {}

    public List<Note> getNotes() {
        return notes;
    }
    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public Note getNotesByID(int id) {return notes.get(id);}


    public void addNote(Note note) {
        backupNotes.add(note);
        notes.add(note);
    }
    public void removeNote(String id) {
        Note noteToRemove = null;
        for (Note note : notes) {
            if (note.getID().equals(id)) {
                noteToRemove = note;
                break;
            }
        }
        notes.remove(noteToRemove);
        backupNotes.remove(noteToRemove);
    }

    public void saveNotes(String path ) {

        File notesFile = new File(path + "/notes.dat");
        try (FileOutputStream fos = new FileOutputStream(notesFile)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(notes);
            oos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void loadNotes(String path) {
        File notesFile = new File(path + "/notes.dat");
        try (FileInputStream fis = new FileInputStream(notesFile)) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            ((ArrayList)ois.readObject()).forEach((n) -> notes.add((Note)n));


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
