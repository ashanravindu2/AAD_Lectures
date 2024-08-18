package lk.ijse.gdse.notetaker.bo;

import lk.ijse.gdse.notetaker.bo.NoteBo;
import lk.ijse.gdse.notetaker.dto.NoteDto;
import lk.ijse.gdse.notetaker.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class NoteBoImpl implements NoteBo {
    @Override
    public String saveNote(NoteDto noteDto) {
        noteDto.setNoteId(AppUtil.createNoteId());
        System.out.println("Note ID : "+noteDto);
        return "Note Created Successfully BO layer";
    }

    @Override
    public boolean updateNote(String noteId, NoteDto noteDto) {
        System.out.println("Note ID : "+noteId);
        System.out.println(noteDto + " Updated");
       return true;
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
