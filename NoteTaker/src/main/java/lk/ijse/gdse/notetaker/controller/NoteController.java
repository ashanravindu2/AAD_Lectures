package lk.ijse.gdse.notetaker.controller;

import lk.ijse.gdse.notetaker.dto.NoteDto;
import lk.ijse.gdse.notetaker.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {


    //Todo: CRUD of the Note
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDto noteDto){
        //Todo Handle With BO

        noteDto.setNoteId(AppUtil.createNoteId());
        System.out.println(noteDto);
        return ResponseEntity.ok("Note Created Successfully");
    }


}
