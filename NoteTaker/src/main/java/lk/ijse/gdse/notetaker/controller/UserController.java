package lk.ijse.gdse.notetaker.controller;


import lk.ijse.gdse.notetaker.bo.UserBo;
import lk.ijse.gdse.notetaker.dto.NoteDto;
import lk.ijse.gdse.notetaker.dto.UserDto;
import lk.ijse.gdse.notetaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Controller
public class UserController {

    @Autowired
    private final UserBo userBo;

    @GetMapping("health")
    public String healthCheck() {
        return "User taker is running!";
    }

    //Todo: CRUD of the Note
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveUser(
            @RequestParam("userId") String userId,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("profilePic") String profilePic){

        //Handle profile pic
        String base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic);

        //build the user object

        var buildUserDto = new UserDto();
        buildUserDto.setFirstName(firstName);
        buildUserDto.setLastName(lastName);
        buildUserDto.setEmail(email);
        buildUserDto.setPassword(password);
        buildUserDto.setProfilePic(base64ProfilePic);

        //send to the bo layer
        userBo.saveUser(buildUserDto);
    }


      //
}







}
