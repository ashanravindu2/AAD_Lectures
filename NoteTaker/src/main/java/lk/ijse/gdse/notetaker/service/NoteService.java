package lk.ijse.gdse.notetaker.service;

import lk.ijse.gdse.notetaker.dto.impl.NoteDto;

import java.util.List;

public  interface NoteService {
    void saveNote(NoteDto noteDto);
    void updateNote(String noteId, NoteDto noteDto);
    void deleteNote(String noteId);
    Object getNote(String noteId);
    List<NoteDto> getAllNotes();

}
