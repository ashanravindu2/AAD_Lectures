package lk.ijse.gdse.aad68.javaeecrud.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet(urlPatterns = "/student")
public class Student extends HttpServlet {
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

        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        reader.lines().forEach(line -> sb.append(line).append("\n"));
        System.out.println(sb);

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
