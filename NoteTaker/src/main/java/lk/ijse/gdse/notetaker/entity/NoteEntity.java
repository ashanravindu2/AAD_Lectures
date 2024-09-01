package lk.ijse.gdse.notetaker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "notes")
@Entity
public class NoteEntity implements Serializable {
    @Id
    public String noteId;
    public String noteTitle;
    public String noteDes;
    public String prorityLevel;
    public String noteDate;
}
