package lk.ijse.gdse.notetaker.service;

import lk.ijse.gdse.notetaker.dao.NoteDao;
import lk.ijse.gdse.notetaker.dto.NoteDto;
import lk.ijse.gdse.notetaker.entity.NoteEntity;
import lk.ijse.gdse.notetaker.util.AppUtil;
import lk.ijse.gdse.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service

public  class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;
    @Autowired
    private Mapping mapping;



    @Override
    public String saveNote(NoteDto noteDto) {

        noteDto.setNoteId(AppUtil.createNoteId());
        var noteEntity = mapping.convertToEntity(noteDto);
        noteDao.save(noteEntity);
        return "Note Saved successfully in Bo Layer";
    }

    @Override
    public boolean updateNote(String noteId, NoteDto noteDto) {
        Optional<NoteEntity> noteEntity = noteDao.findById(noteId);
        if (noteEntity.isPresent()){
            var note = noteEntity.get();
            note.setNoteTitle(noteDto.getNoteTitle());
            note.setNoteDes(noteDto.getNoteDes());
            note.setProrityLevel(noteDto.getProrityLevel());
            note.setNoteDate(noteDto.getNoteDate());
            noteDao.save(note);

            return true;
        }
        else {
            return false;
        }


    }

    @Override
    public boolean deleteNote(String noteId) {
        var noteEntity = noteDao.findById(noteId);
        if (noteEntity.isPresent()){
            noteDao.delete(noteEntity.get());

            return true;
        }
        else {
           return false;
        }
    }

    @Override
    public NoteDto getNote(String note) {
        return noteDao.findById(note).map(mapping::convertToDTO).orElse(null);
    }


    @Override
    public List<NoteDto> getAllNotes() {
        return mapping.convertToDTO(noteDao.findAll());
    }
}