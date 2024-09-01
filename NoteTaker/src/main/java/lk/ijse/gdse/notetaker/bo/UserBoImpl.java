package lk.ijse.gdse.notetaker.bo;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.notetaker.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public  class UserBoImpl implements UserBo {

    @Override
    public String saveUser(UserDto userDto) {
        return null;
    }

    @Override
    public boolean updateUser(String userId, UserDto userDto) {
        return false;
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public UserDto getUser(String userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }
}
