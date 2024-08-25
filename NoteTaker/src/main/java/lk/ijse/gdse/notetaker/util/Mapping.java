package lk.ijse.gdse.notetaker.util;

import lk.ijse.gdse.notetaker.dto.NoteDto;
import lk.ijse.gdse.notetaker.entity.NoteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //matters of NoteEntity and DTO
    public NoteDto convertToDTO(NoteEntity note) {
        return modelMapper.map(note, NoteDto.class);
    }
    public NoteEntity convertToEntity(NoteDto dto) {
        return modelMapper.map(dto, NoteEntity.class);
    }
    public List<NoteDto> convertToDTO(List<NoteEntity> notes) {
        return modelMapper.map(notes, List.class);
    }
}