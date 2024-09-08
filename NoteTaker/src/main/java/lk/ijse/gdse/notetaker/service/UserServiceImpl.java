package lk.ijse.gdse.notetaker.service;

import lk.ijse.gdse.notetaker.dao.UserDao;
import lk.ijse.gdse.notetaker.dto.UserDto;
import lk.ijse.gdse.notetaker.entity.UserEntity;
import lk.ijse.gdse.notetaker.util.AppUtil;
import lk.ijse.gdse.notetaker.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public  class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapping mapping;

    @Override
    public String saveUser(UserDto userDto) {
        userDto.setUserId(AppUtil.createUserId());
        userDao.save(mapping.convertToUserEntity(userDto));
        return "User saved successfully";
    }

    @Override
    public boolean updateUser(String userId, UserDto userDto) {
        Optional<UserEntity> selectedUser = userDao.findById(userId);
        if(!selectedUser.isPresent()){
           return false;
        } else {
            selectedUser.get().setUserId(userId);
            selectedUser.get().setFirstName(userDto.getFirstName());
            selectedUser.get().setLastName(userDto.getLastName());
            selectedUser.get().setEmail(userDto.getEmail());
            selectedUser.get().setPassword(userDto.getPassword());
            selectedUser.get().setProfilePic(userDto.getProfilePic());
            userDao.save(selectedUser.get());
            return true;
        }

    }

    @Override
    public boolean deleteUser(String userId) {
        var userEntity = userDao.findById(userId);
        if (userEntity.isPresent()){
            userDao.delete(userEntity.get());
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public UserDto getUser(String userId) {
        UserEntity userEntityByUserId = userDao.getUserEntityByUserId(userId);
        return mapping.convertToUserDTO(userEntityByUserId);
    }
    @Override
    public List<UserDto> getAllUser() {
        return mapping.convertUserToDTO(userDao.findAll());
    }
}
