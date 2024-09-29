package lk.ijse.gdse.notetaker.service;

import lk.ijse.gdse.notetaker.customerObj.NoteErrorResponse;
import lk.ijse.gdse.notetaker.customerObj.NoteResponse;
import lk.ijse.gdse.notetaker.dao.NoteDao;
import lk.ijse.gdse.notetaker.dto.impl.NoteDto;
import lk.ijse.gdse.notetaker.entity.NoteEntity;
import lk.ijse.gdse.notetaker.exeption.DataPersistFailedException;
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
    public void saveNote(NoteDto noteDto) {
        noteDto.setNoteId(AppUtil.createNoteId());
        var noteEntity = mapping.convertToEntity(noteDto);
        var saveNoted = noteDao.save(noteEntity);
        if(saveNoted==null){
            throw new DataPersistFailedException("Cannot save note");
        }
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
    public void deleteNote(String noteId) {
        //        noteDao.deleteById(noteId);
        Optional<NoteEntity> findId = noteDao.findById(noteId);
        if(!findId.isPresent()){
            throw new NoteNotFound("Note not found");
        }else {
            noteDao.deleteById(noteId);
        }
    }

    @Override
    public NoteResponse getNote(String noteId) {
        if(noteDao.existsById(noteId)){
            return mapping.convertToDTO(noteDao.getReferenceById(noteId));
        }else {
            return new NoteErrorResponse(1,"Note not found");
        }
    }

    @Override
    public List<NoteDto> getAllNotes() {
        return mapping.convertToDTO(noteDao.findAll());
    }
}
