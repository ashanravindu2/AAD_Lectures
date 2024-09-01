package lk.ijse.gdse.notetaker.bo;

import lk.ijse.gdse.notetaker.dto.NoteDto;

import java.util.List;

public sealed interface NoteBo permits NoteBoImpl {
    String saveNote(NoteDto noteDto);
    void updateNote(String noteId, NoteDto noteDto);
    void deleteNote(String noteId);
    NoteDto getNote(String note);
    List<NoteDto> getAllNotes();

}
