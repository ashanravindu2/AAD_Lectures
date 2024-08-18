package lk.ijse.gdse.notetaker.controller;

import lk.ijse.gdse.notetaker.dto.NoteDto;
import lk.ijse.gdse.notetaker.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "getAllNotes",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<NoteDto> getAllNotes(){
        //Todo Handle With BO
       return null;
    }

    @GetMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public NoteDto getNote(@PathVariable("noteId") String noteId){
        //Todo Handle With BO
        System.out.println("NoteId :"+ noteId);
        return null;
    }

    @PutMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateNote(@PathVariable("noteId") String noteId, @RequestBody NoteDto noteDto){
        //Todo Handle With BO
        System.out.println("NoteId :"+ noteId);
        System.out.println(noteDto + " Updated");
        return "Note Updated Successfully";
    }

    @DeleteMapping(value = "/{noteId}")
    public String deleteNote(@PathVariable("noteId") String noteId){
        //Todo Handle With BO
        System.out.println("NoteId :"+ noteId);
        return "Note Deleted Successfully"+noteId;
    }

}
