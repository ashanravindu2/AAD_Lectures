package lk.ijse.gdse.aad68.javaeecrud.controller;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.aad68.javaeecrud.dto.StudentDTO;
import lk.ijse.gdse.aad68.javaeecrud.util.Util;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.UUID;

@WebServlet(urlPatterns = "/student")
public class Student extends HttpServlet {

    Connection connection;

    public static String SAVE_STUDENT = "INSERT INTO student ( id, name, email, address ) VALUES (?, ?, ?, ?)" ;
    public static String GET_STUDENT = "SELECT * FROM student WHERE id = ?";
    public static String UPDATE_STUDENT = "UPDATE student SET name=?, email=?, address=? WHERE id=?";
    public static String DELETE_STUDENT = "DELETE FROM student WHERE id=?";

    @Override
    public void init() throws ServletException {
//        var initParameter = getServletConfig().getInitParameter("Hello my param");
//        System.out.println(initParameter);

        //Database Configuration
       try{
//           var dbClass = getServletContext().getInitParameter("db-class");
//           var dbUrl = getServletContext().getInitParameter("db-url");
//           var dbUserName = getServletContext().getInitParameter("db-username");
//           var dbPassword = getServletContext().getInitParameter("db-password");
//
//           Class.forName(dbClass);

           InitialContext ctx = new InitialContext();
           DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/studentManagement");

           this.connection = pool.getConnection();

       } catch (Exception e) {
           throw new RuntimeException(e);
       }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //Todo: Get Student

        try ( var writer = resp.getWriter()){
            var studentDTO = new StudentDTO();
            Jsonb jsonb = JsonbBuilder.create();
            var studentId = req.getParameter("id"); //Send the exact parameter name from the postmen
            var ps = connection.prepareStatement(GET_STUDENT);
            ps.setString(1,studentId);
            var rst = ps.executeQuery();
            while(rst.next()){

                studentDTO.setId(rst.getString( "id"));
                studentDTO.setName(rst.getString("name"));
                studentDTO.setEmail(rst.getString("email"));
                studentDTO.setAddress(rst.getString("address"));

            }
            resp.setContentType("application/json");
            jsonb.toJson(studentDTO, writer );

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Todo: Save Student

        // ** This is how you can get the parameters from the request
//        var id = req.getParameter("id");
//        var name = req.getParameter("name");
//        var email = req.getParameter("email");
//        var address = req.getParameter("address");
//
//        System.out.println(id);
//        System.out.println(name);
//        System.out.println(email);
//        System.out.println(address);



        // ** This is how you can get the JSON from the request
        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);

        }

        /* ** BufferedReader is used to read the JSON from the request
         and StringBuilder is used to append the JSON */

//        BufferedReader reader = req.getReader();
//        StringBuilder sb = new StringBuilder();
//        reader.lines().forEach(line -> sb.append(line).append("\n"));
//        System.out.println(sb);


//    // ** Process the JSON using the parsson library
//        JsonReader reader = Json.createReader(req.getReader());
//        JsonObject jsonObject = reader.readObject();
//
//        String id = jsonObject.getString("id");
//        String name = jsonObject.getString("name");
//        String email = jsonObject.getString("email");
//        String address = jsonObject.getString("address");
//
//        System.out.println(id);
//        System.out.println(name);
//        System.out.println(email);
//        System.out.println(address);
//
//        // Send data(response) to the client
//        var writer = resp.getWriter();
//        writer.write("Student Saved Successfully");

//        // Optional ==> =====JSON Array Processing=====
//        JsonReader reader = Json.createReader(req.getReader());
//        JsonArray jsonArray = reader.readArray();
//
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JsonObject object = jsonArray.getJsonObject(i);
//
//            String id = object.getString("id");
//            String name = object.getString("name");
//            String email = object.getString("email");
//            String address = object.getString("address");
//
//            System.out.println(id);
//            System.out.println(name);
//            System.out.println(email);
//            System.out.println(address);
//
//        }

        // Object binding of the JSON

        try(var writer = resp.getWriter()){  //try-with-resource(Best Practise)

            Jsonb jsonb = JsonbBuilder.create();
            StudentDTO student = jsonb.fromJson(req.getReader(), StudentDTO.class);
            student.setId(Util.idGenerator());
            System.out.println(student);

            //Save data in the DB
            var ps = connection.prepareStatement(SAVE_STUDENT);
            ps.setString(1,student.getId());
            ps.setString(2,student.getName());
            ps.setString(3,student.getEmail());
            ps.setString(4,student.getAddress());

            if(ps.executeUpdate() != 0){
                resp.setStatus(HttpServletResponse.SC_CREATED);
                writer.write("Student saved successfully!");

            }else{
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                writer.write("Failed to save the student!");
            }

//            // Create Response
//            resp.setContentType("application/json");
//            jsonb.toJson(student, writer);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Todo: Update Student

        try(var writer = resp.getWriter()){
            var studentId = req.getParameter("id");
            Jsonb jsonb = JsonbBuilder.create();
            StudentDTO student = jsonb.fromJson(req.getReader(), StudentDTO.class);
            var ps = connection.prepareStatement(UPDATE_STUDENT);
            ps.setString(1,student.getName());
            ps.setString(2,student.getEmail());
            ps.setString(3,student.getAddress());
            ps.setString(4, studentId);

            if ( ps.executeUpdate() != 0 ){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                writer.write("Student updated successfully!"); // we are not sending any content when deleting and updating data
            }else{
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                writer.write("Student update failed!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Todo: Delete Student

        try(var writer = resp.getWriter()){
            var studentId = req.getParameter("id");
            var ps = connection.prepareStatement(DELETE_STUDENT);
            ps.setString(1,studentId);

            if ( ps.executeUpdate() != 0 ){
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT); // we are not sending any content when deleting and updating data
                writer.write("Student deleted successfully!");
            }else{
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                writer.write("Student delete failed!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }



    // ** MDN W
//    https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses

    // ** HTTP Status Codes
//  https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses

    // ** Pre-flight request
//  https://developer.mozilla.org/en-US/docs/Glossary/Preflight_request

    // ** Simple request

}
