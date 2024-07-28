package lk.ijse.gdse.aad68.javaeecrud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements Serializable {
    private String id;
    private String name;
    private String email;
    private String address;
}

