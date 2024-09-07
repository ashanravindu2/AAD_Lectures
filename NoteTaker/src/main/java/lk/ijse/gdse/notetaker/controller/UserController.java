package lk.ijse.gdse.notetaker.controller;


import lk.ijse.gdse.notetaker.service.UserService;
import lk.ijse.gdse.notetaker.dto.UserDto;
import lk.ijse.gdse.notetaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    @GetMapping("health")
    public String healthCheck() {
        return "User taker is running!";
    }

    //Todo: CRUD of the Note
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> saveUser(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("profilePic") String profilePic){

        //Handle profile pic
        String base64ProfilePic = AppUtil.toBase64ProfilePic(profilePic);

        //build the user object

        UserDto buildUserDto = new UserDto();
        buildUserDto.setFirstName(firstName);
        buildUserDto.setLastName(lastName);
        buildUserDto.setEmail(email);
        buildUserDto.setPassword(password);
        buildUserDto.setProfilePic(base64ProfilePic);

        //send to the bo layer
        return new ResponseEntity<>(userService.saveUser(buildUserDto), HttpStatus.CREATED);

    }



      //
}








