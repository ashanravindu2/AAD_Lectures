package lk.ijse.gdse.notetaker.bo;

import lk.ijse.gdse.notetaker.dto.NoteDto;
import lk.ijse.gdse.notetaker.dto.UserDto;

import java.util.List;

public   interface UserBo {
    String saveUser(UserDto userDto);
    boolean updateUser(String userId, UserDto userDto);
    boolean deleteUser(String userId);
    UserDto getUser(String userId);
    List<UserDto> getAllUser();

}
