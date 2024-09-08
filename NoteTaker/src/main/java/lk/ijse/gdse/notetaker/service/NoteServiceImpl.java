package lk.ijse.gdse.notetaker.service;

import lk.ijse.gdse.notetaker.dao.NoteDao;
import lk.ijse.gdse.notetaker.dto.impl.NoteDto;
import lk.ijse.gdse.notetaker.entity.NoteEntity;
import lk.ijse.gdse.notetaker.exeption.NoteNotFound;
import lk.ijse.gdse.notetaker.util.AppUtil;
import lk.ijse.gdse.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
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
    public void updateNote(String noteId, NoteDto noteDto) {
        Optional<NoteEntity> noteEntity = noteDao.findById(noteId);
        if (!noteEntity.isPresent()){
          throw new NoteNotFound("Note Not Found");
        }
        else {
           noteEntity.get().setNoteTitle(noteDto.getNoteTitle());
           noteEntity.get().setNoteDes(noteDto.getNoteDes());
           noteEntity.get().setNoteDate(noteDto.getNoteDate());
           noteEntity.get().setProrityLevel(noteDto.getProrityLevel());

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
