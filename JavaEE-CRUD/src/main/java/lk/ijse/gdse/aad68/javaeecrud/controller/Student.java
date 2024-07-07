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

import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

@WebServlet(urlPatterns = "/student")
public class Student extends HttpServlet {

    @Override
    public void init() throws ServletException {
        var initParameter = getServletConfig().getInitParameter("myparam");
        System.out.println(initParameter);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //Todo: Get Student

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
        Jsonb jsonb = JsonbBuilder.create();
        StudentDTO student = jsonb.fromJson(req.getReader(), StudentDTO.class);
        student.setId(Util.idGenerator());
        System.out.println(student);

        // Create Response
        resp.setContentType("application/json");
        jsonb.toJson(student, resp.getWriter());


    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Todo: Update Student
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Todo: Delete Student
    }



    // ** MDN Web Docs
//    https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses

    // ** HTTP Status Codes
//  https://developer.mozilla.org/en-US/docs/Web/HTTP/Status#client_error_responses

}
