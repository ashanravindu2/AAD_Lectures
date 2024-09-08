package lk.ijse.gdse.notetaker.service;

import lk.ijse.gdse.notetaker.customerObj.UserErrorResponse;
import lk.ijse.gdse.notetaker.customerObj.UserResponse;
import lk.ijse.gdse.notetaker.dao.UserDao;
import lk.ijse.gdse.notetaker.dto.impl.UserDto;
import lk.ijse.gdse.notetaker.entity.UserEntity;
import lk.ijse.gdse.notetaker.util.AppUtil;
import lk.ijse.gdse.notetaker.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public  class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Mapping mapping;

    @Override
    public String saveUser(UserDto userDto) {
        userDto.setUserId(AppUtil.createUserId());
        UserEntity savedUser= userDao.save(mapping.convertToUserEntity(userDto));
            if (savedUser != null && savedUser.getUserId() != null) {
                return "User Saved Successfully";
            } else {
                return "User Save Failed";
            }
    }

    @Override
    public void updateUser( UserDto userDto) {
        Optional<UserEntity> selectedUser = userDao.findById(userDto.getUserId());
        if(!selectedUser.isPresent()){
           throw new RuntimeException("User Not Found");
        } else {

            selectedUser.get().setFirstName(userDto.getFirstName());
            selectedUser.get().setLastName(userDto.getLastName());
            selectedUser.get().setEmail(userDto.getEmail());
            selectedUser.get().setPassword(userDto.getPassword());
            selectedUser.get().setProfilePic(userDto.getProfilePic());
            userDao.save(selectedUser.get());
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
    public UserResponse getUser(String userId) {
        if (userDao.existsById(userId)) {
            UserEntity userEntityByUserId = userDao.getUserEntityByUserId(userId);
            return mapping.convertToUserDTO(userEntityByUserId);
        }else {
            return new UserErrorResponse(0,"User Not Found");
        }
    }
    @Override
    public List<UserDto> getAllUser() {
            List<UserEntity> getAllUsers = userDao.findAll();
            return mapping.convertUserToDTOList(getAllUsers);
        }

}
