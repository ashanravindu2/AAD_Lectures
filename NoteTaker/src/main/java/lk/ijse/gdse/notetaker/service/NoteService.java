package lk.ijse.gdse.notetaker.service;

import lk.ijse.gdse.notetaker.dto.impl.NoteDto;

import java.util.List;

public  interface NoteService {
    String saveNote(NoteDto noteDto);
    void updateNote(String noteId, NoteDto noteDto);
    boolean deleteNote(String noteId);
    NoteDto getNote(String noteId);
    List<NoteDto> getAllNotes();

}
