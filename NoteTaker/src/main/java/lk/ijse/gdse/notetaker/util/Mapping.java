package lk.ijse.gdse.notetaker.util;

import lk.ijse.gdse.notetaker.dto.impl.NoteDto;
import lk.ijse.gdse.notetaker.dto.impl.UserDto;
import lk.ijse.gdse.notetaker.entity.NoteEntity;
import lk.ijse.gdse.notetaker.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
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
    //User matters mapping
    public UserEntity convertToUserEntity(UserDto userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
    public UserDto convertToUserDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }
    public List<UserDto> convertUserToDTOList(List<UserEntity> userEntities) {
        return modelMapper.map(userEntities, new TypeToken<List<UserDto>>() {}.getType());
    }
}