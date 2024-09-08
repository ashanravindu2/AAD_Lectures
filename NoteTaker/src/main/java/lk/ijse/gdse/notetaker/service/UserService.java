package lk.ijse.gdse.notetaker.service;

import lk.ijse.gdse.notetaker.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String saveUser(UserDto userDto);
    boolean updateUser(String userId, UserDto userDto);
    boolean deleteUser(String userId);
    UserDto getUser(String userId);
    List<UserDto> getAllUser();

}
