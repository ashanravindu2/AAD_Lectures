package lk.ijse.gdse.notetaker.customerObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteErrorResponse  implements NoteResponse {
    private int errorCode;
    private String errorMessage;
}
