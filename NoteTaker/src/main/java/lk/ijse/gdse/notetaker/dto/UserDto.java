package lk.ijse.gdse.notetaker.dto;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lk.ijse.gdse.notetaker.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePic;
    private List<NoteEntity> notes;
}
