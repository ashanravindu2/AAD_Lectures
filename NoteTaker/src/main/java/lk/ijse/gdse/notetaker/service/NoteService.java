package lk.ijse.gdse.notetaker.service;

import lk.ijse.gdse.notetaker.dto.NoteDto;

import java.util.List;

public  interface NoteService {
    String saveNote(NoteDto noteDto);
    boolean updateNote(String noteId, NoteDto noteDto);
    boolean deleteNote(String noteId);
    NoteDto getNote(String note);
    List<NoteDto> getAllNotes();

}
