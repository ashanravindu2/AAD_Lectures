package lk.ijse.gdse.notetaker.controller;


import lk.ijse.gdse.notetaker.bo.UserBo;
import lk.ijse.gdse.notetaker.dto.NoteDto;
import lk.ijse.gdse.notetaker.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final UserBo userBo;

    @GetMapping("health")
    public String healthCheck(){
        return "User taker is running!";
    }

    //Todo: CRUD of the Note
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto){ //http://localhost:8080/NoteTaker/api/v1/notes
        //Todo Handle With BO
        var saveUser = userBo.saveUser(userDto);
        return ResponseEntity.ok(saveUser);
    }




}
