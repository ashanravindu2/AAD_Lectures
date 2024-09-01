package lk.ijse.gdse.notetaker.controller;

import lk.ijse.gdse.notetaker.bo.NoteBo;
import lk.ijse.gdse.notetaker.dto.NoteDto;
import lk.ijse.gdse.notetaker.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
@RequiredArgsConstructor
@Controller
public class NoteController {

    @Autowired
    private final NoteBo noteBo;

    @GetMapping("health")
    public String healthCheck(){
        return "Note taker is running!";
    }

    //Todo: CRUD of the Note
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createNote(@RequestBody NoteDto noteDto){ //http://localhost:8080/NoteTaker/api/v1/notes
        //Todo Handle With BO



        var saveNote = noteBo.saveNote(noteDto);

        return ResponseEntity.ok(saveNote);
    }

    @GetMapping(value = "getAllNotes",produces = MediaType.APPLICATION_JSON_VALUE) //http://localhost:8080/NoteTaker/api/v1/notes/getAllNotes
    public List<NoteDto> getAllNotes(){
        //Todo Handle With BO
       return noteBo.getAllNotes();

    }

    @GetMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE) //http://localhost:8080/NoteTaker/api/v1/notes/NOTE6221
    public NoteDto getNote(@PathVariable("noteId") String noteId){
        //Todo Handle With BO
        System.out.println("NoteId :"+ noteId);
        return noteBo.getNote(noteId);

    }

    @PutMapping(value = "/{noteId}",produces = MediaType.APPLICATION_JSON_VALUE) //http://localhost:8080/NoteTaker/api/v1/notes/N3664
    public String updateNote(@PathVariable("noteId") String noteId, @RequestBody NoteDto noteDto){
        //Todo Handle With BO
     /*   System.out.println("NoteId :"+ noteId);
        System.out.println(noteDto + " Updated");
        return "Note Updated Successfully";*/
       noteBo.updateNote(noteId,noteDto);
        return "Note Updated Successfully";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{noteId}") //http://localhost:8080/NoteTaker/api/v1/notes/NOTE6221
    public String deleteNote(@PathVariable("noteId") String noteId){
        //Todo Handle With BO
       noteBo.deleteNote(noteId);
        return "Note Deleted Successfully";
    }


}
