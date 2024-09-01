package lk.ijse.gdse.notetaker.dao;

import lk.ijse.gdse.notetaker.entity.NoteEntity;
import lk.ijse.gdse.notetaker.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
}
