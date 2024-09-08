package lk.ijse.gdse.notetaker.service;

import lk.ijse.gdse.notetaker.customerObj.UserResponse;
import lk.ijse.gdse.notetaker.dto.impl.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String saveUser(UserDto userDto);
    void updateUser(UserDto userDto);
    boolean deleteUser(String userId);
    UserResponse getUser(String userId);
    List<UserDto> getAllUser();

}
