package lk.ijse.gdse.notetaker.dao;

import lk.ijse.gdse.notetaker.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends JpaRepository<NoteEntity,String> {



}
