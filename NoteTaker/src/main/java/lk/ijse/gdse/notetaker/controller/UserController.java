package lk.ijse.gdse.notetaker.controller;

import lk.ijse.gdse.notetaker.customerObj.UserResponse;
import lk.ijse.gdse.notetaker.exeption.DataPersistFailedException;
import lk.ijse.gdse.notetaker.exeption.UserNotFoundException;
import lk.ijse.gdse.notetaker.service.UserService;
import lk.ijse.gdse.notetaker.dto.impl.UserDto;
import lk.ijse.gdse.notetaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("health")
    public String healthCheck(){
        return "Controller taker is running!";
    }

    //Todo: CRUD of the Note
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveUser(
            @RequestPart("firstName") String firstName,
            @RequestPart ("lastName") String lastName,
            @RequestPart ("email") String email,
            @RequestPart ("password") String password,
            @RequestPart ("profilePic") String profilePic) {

        try {
            var base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic);
            var buildUserDTO = new UserDto();
            buildUserDTO.setUserId(AppUtil.createUserId());
            buildUserDTO.setFirstName(firstName);
            buildUserDTO.setLastName(lastName);
            buildUserDTO.setEmail(email);
            buildUserDTO.setPassword(password);
            buildUserDTO.setProfilePic(base64ProfilePic);

            userService.saveUser(buildUserDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping(value ="/{userId}" )
    public ResponseEntity<String> deleteUser(@PathVariable ("userId") String userId) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getUser(@PathVariable ("userId") String userId)  {
        return userService.getUser(userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAllUsers(){
        return userService.getAllUser();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUser(@PathVariable ("userId") String userId, @RequestBody UserDto userDto) {
        try {
            userService.updateUser(userId, userDto);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{userId}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public  ResponseEntity<String> updateUser(
                                                            @RequestPart("firstName") String firstName,
                                                            @RequestPart ("lastName") String lastName,
                                                            @RequestPart ("email") String email,
                                                            @RequestPart ("password") String password,
                                                            @RequestPart ("profilePic") String profilePic,
                                                            @PathVariable ("userId") String userId) {
        try {
            var base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic);
            UserDto buildUserDTO = new UserDto();
            buildUserDTO.setUserId(userId);
            buildUserDTO.setFirstName(firstName);
            buildUserDTO.setLastName(lastName);
            buildUserDTO.setEmail(email);
            buildUserDTO.setPassword(password);
            buildUserDTO.setProfilePic(base64ProfilePic);
            userService.updateUser( buildUserDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}








