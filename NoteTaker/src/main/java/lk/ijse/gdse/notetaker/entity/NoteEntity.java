package lk.ijse.gdse.notetaker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "notes")
@Entity
public class NoteEntity implements SuperEntity {
    @Id
    private String noteId;
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private UserEntity user;
    private String noteTitle;
    private String noteDes;
    private String prorityLevel;
    private String noteDate;
}
