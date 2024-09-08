package lk.ijse.gdse.notetaker.dto.impl;

import lk.ijse.gdse.notetaker.customerObj.UserResponse;
import lk.ijse.gdse.notetaker.dto.SuperDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto implements SuperDto, UserResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String profilePic;
    private List<NoteDto> notes = new ArrayList<>();
}
