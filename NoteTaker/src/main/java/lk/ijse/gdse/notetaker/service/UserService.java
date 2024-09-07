package lk.ijse.gdse.notetaker.service;

import lk.ijse.gdse.notetaker.dto.UserDto;

import java.util.List;

public interface UserService {
    String saveUser(UserDto userDto);
    boolean updateUser(String userId, UserDto userDto);
    boolean deleteUser(String userId);
    UserDto getUser(String userId);
    List<UserDto> getAllUser();

}
