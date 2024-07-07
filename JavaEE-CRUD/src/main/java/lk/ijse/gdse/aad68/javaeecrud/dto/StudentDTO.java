package lk.ijse.gdse.aad68.javaeecrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private String id;
    private String name;
    private String email;
    private String address;
}
