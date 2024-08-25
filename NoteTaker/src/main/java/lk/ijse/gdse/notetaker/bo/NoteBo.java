package lk.ijse.gdse.notetaker.bo;

import lk.ijse.gdse.notetaker.dto.NoteDto;

import java.util.List;

public sealed interface NoteBo permits NoteBoImpl {
    String saveNote(NoteDto noteDto);
    void updateNote(String noteId,NoteDto noteDto);
    boolean deleteNote(String noteId);
    NoteDto findNoteById(String noteId);
    List<NoteDto> getAllNotes();

}
