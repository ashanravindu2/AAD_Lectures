package lk.ijse.gdse.notetaker.controller;

import lk.ijse.gdse.notetaker.dto.NoteDto;
import lk.ijse.gdse.notetaker.service.UserService;
import lk.ijse.gdse.notetaker.dto.UserDto;
import lk.ijse.gdse.notetaker.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

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
      var base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic);
      var buildUserDTO = new UserDto();
        buildUserDTO.setUserId(AppUtil.createUserId());
        buildUserDTO.setFirstName(firstName);
        buildUserDTO.setLastName(lastName);
        buildUserDTO.setEmail(email);
        buildUserDTO.setPassword(password);
        buildUserDTO.setProfilePic(base64ProfilePic);
        //send to the service layer
        return new ResponseEntity<>(userService.saveUser(buildUserDTO), HttpStatus.CREATED);
    }


    @DeleteMapping(value ="/{userId}" )
    public ResponseEntity<String> deleteUser(@PathVariable ("userId") String userId) {
        return userService.deleteUser(userId) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getUser(@PathVariable ("userId") String userId)  {
        return  userService.getUser(userId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDto> getAllUsers(){
        return userService.getAllUser();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/{userId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUser(@PathVariable ("userId") String userId, @RequestBody UserDto userDto) {
        return userService.updateUser(userId, userDto) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}








