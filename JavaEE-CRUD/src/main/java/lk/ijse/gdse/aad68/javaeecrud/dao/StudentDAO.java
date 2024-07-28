package lk.ijse.gdse.aad68.javaeecrud.dao;


import lk.ijse.gdse.aad68.javaeecrud.dto.StudentDTO;

import java.sql.Connection;

public sealed interface StudentDAO permits StudentDAOImpl{
     String saveStudent(StudentDTO student, Connection connection) throws Exception;
     boolean deleteStudent(String studentId, Connection connection) throws Exception;
     boolean updateStudent(String id, StudentDTO student, Connection connection) throws Exception;
     StudentDTO getStudent(String id, Connection connection) throws Exception;
}
