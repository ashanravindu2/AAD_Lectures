package lk.ijse.gdse.notetaker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDto {
    public String noteId;
    public String noteTitle;
    public String noteDes;
    public String prorityLevel;
    public String noteDate;
}
