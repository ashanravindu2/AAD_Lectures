package lk.ijse.gdse.notetaker.util;

import lk.ijse.gdse.notetaker.dto.NoteDto;
import lk.ijse.gdse.notetaker.dto.UserDto;
import lk.ijse.gdse.notetaker.entity.NoteEntity;
import lk.ijse.gdse.notetaker.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {

    @Autowired
    private ModelMapper modelMapper;

    //Matters of noteEntity and NoteDto
    public NoteDto convertToDto(NoteEntity noteEntity){
        return modelMapper.map(noteEntity, NoteDto.class);
    }
    public NoteEntity convertToEntity(NoteDto noteDto){
        return modelMapper.map(noteDto, NoteEntity.class);
    }
    public List<NoteDto> convertToDto(List<NoteEntity> notes){
        return modelMapper.map(notes, List.class);
    }

    //User matters mapping
    public UserEntity convertToUserEntity(UserDto userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDto convertToUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }
    public List<UserDto> convertUserToDTO(List<UserEntity> userEntities) {
        return modelMapper.map(userEntities, List.class);
    }
}