package lk.ijse.gdse.notetaker.bo;

import lk.ijse.gdse.notetaker.bo.NoteBo;
import lk.ijse.gdse.notetaker.dto.NoteDto;

import java.util.List;

public final class NoteBoImpl implements NoteBo {
    @Override
    public String saveNote(NoteDto noteDto) {
        return null;
    }

    @Override
    public boolean updateNote(String noteId, NoteDto noteDto) {
        return false;
    }

    @Override
    public boolean deleteNote(String noteId) {
        return false;
    }

    @Override
    public NoteDto findNoteById(String noteId) {
        return null;
    }

    @Override
    public List<NoteDto> getAllNotes() {
        return null;
    }
}
