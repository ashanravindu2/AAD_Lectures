package lk.ijse.gdse.notetaker.dto.impl;

import lk.ijse.gdse.notetaker.dto.SuperDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteDto implements SuperDto {
    private String noteId;
    private String noteTitle;
    private String noteDes;
    private String prorityLevel;
    private String noteDate;
    private String userId;
}
