package lk.ijse.gdse.aad68.javaeecrud.dao;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.aad68.javaeecrud.dto.StudentDTO;
import lk.ijse.gdse.aad68.javaeecrud.entity.Student;
import lk.ijse.gdse.aad68.javaeecrud.util.Util;

import java.sql.Connection;
import java.sql.SQLException;

public final class StudentDAOImpl implements StudentDAO {

    public static String SAVE_STUDENT = "INSERT INTO student VALUES(?,?,?,?)";
    public static String GET_STUDENT = "SELECT * FROM student WHERE id = ?";
    public static String UPDATE_STUDENT = "UPDATE student SET name=?, email=?, address=? WHERE id=?";
    public static String DELETE_STUDENT = "DELETE FROM student WHERE id=?";


    @Override
    public String getStudent(StudentDTO student, Connection connection) throws Exception {
        try {
            var ps = connection.prepareStatement(SAVE_STUDENT);
            ps.setString(1, student.getId());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getAddress());

            if (ps.executeUpdate() != 0) {
                return "Student save successfully!";

            } else {
                return "Failed to save the student!";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteStudent(String studentId, Connection connection) throws Exception {
        var ps = connection.prepareStatement(DELETE_STUDENT);
        ps.setString(1, studentId);
        return ps.executeUpdate() != 0;
    }

    @Override
    public boolean updateStudent(String id, StudentDTO student, Connection connection) throws Exception {
        try {
            var ps = connection.prepareStatement(UPDATE_STUDENT);
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getAddress());
            ps.setString(4, id);
            return ps.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public StudentDTO getStudent(String id, Connection connection) throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        try {
            var ps = connection.prepareStatement(GET_STUDENT);
            ps.setString(1, id);
            var rst = ps.executeQuery();
            while (rst.next()) {
                studentDTO.setId(rst.getString("id"));
                studentDTO.setName(rst.getString("name"));
                studentDTO.setEmail(rst.getString("email"));
                studentDTO.setAddress(rst.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentDTO;
    }
}
