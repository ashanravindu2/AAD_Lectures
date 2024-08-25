package lk.ijse.gdse.notetaker.bo;

import lk.ijse.gdse.notetaker.bo.NoteBo;
import lk.ijse.gdse.notetaker.dto.NoteDto;
import lk.ijse.gdse.notetaker.util.AppUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@Service
public final class NoteBoImpl implements NoteBo {

    List<NoteDto> saveNoteTemp = new ArrayList<NoteDto>();
    public NoteBoImpl() {
        saveNoteTemp.add(new NoteDto(AppUtil.createNoteId(),"Note 1", "This is Note 1", "High", "2021-09-01"));
        saveNoteTemp.add(new NoteDto(AppUtil.createNoteId(), "Note 2", "This is Note 2", "Medium", "2021-09-02"));
        saveNoteTemp.add(new NoteDto(AppUtil.createNoteId(), "Note 3", "This is Note 3", "Low", "2021-09-03"));
        saveNoteTemp.add(new NoteDto(AppUtil.createNoteId(), "Note 4", "This is Note 4", "High", "2021-09-04"));
        System.out.println("NoteBoImpl Instantiated"+saveNoteTemp );

    }
    @Override
    public String saveNote(NoteDto noteDto) {
        noteDto.setNoteId(AppUtil.createNoteId());
        System.out.println("NoteBoImpl saveNote Method"+noteDto);
        saveNoteTemp.add(noteDto);
        return "Note Created Successfully BO layer";
    }

    @Override
    public void updateNote(String noteId, NoteDto noteDto) {

        ListIterator<NoteDto> noteDtoListIterator = saveNoteTemp.listIterator();

        while (noteDtoListIterator.hasNext()) {
            NoteDto next = noteDtoListIterator.next();
            if (noteId.equals(next.getNoteId() )) {
                noteDto.setNoteId(next.getNoteId());
                noteDtoListIterator.set(noteDto);
                break;
            }
        }
    }


    @Override
    public boolean deleteNote(String noteId) {
        ListIterator<NoteDto> noteDtoListIterator = saveNoteTemp.listIterator();
        while (noteDtoListIterator.hasNext()) {
            NoteDto next = noteDtoListIterator.next();
            if (noteId.equals(next.getNoteId())) {
                noteDtoListIterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public NoteDto findNoteById(String noteId) {

     for (NoteDto noteDto: saveNoteTemp){
         if (noteDto.getNoteId().equals(noteId)){
             return noteDto;
         }
     }
        return null;



    }

    @Override
    public List<NoteDto> getAllNotes() {

        return saveNoteTemp;
    }
}
