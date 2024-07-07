package lk.ijse.gdse.aad68.intro_aad;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//** Exact Mapping **
//@WebServlet(urlPatterns = "/customer",loadOnStartup = 2) // This will match the URL "/customer"

//** Extention Mapping **
//@WebServlet(urlPatterns = "*.php") // This will match any URL that ends with .php

//** Empty String Mapping **
//@WebServlet(urlPatterns = "") // This will match the root URL

// ** Wildcard Mapping **
//@WebServlet(urlPatterns = "/*") // This will match any URL that starts with "/"

//// ** Ant Mapping **
//@WebServlet(urlPatterns = "/**") // This will not work with java servers like Tomcat, But it will work with Spring Boot

//// ** Default Mapping **
//@WebServlet(urlPatterns = "/") // This will match the root URL,Spring dispatcher servlet also uses this mapping

@WebServlet(urlPatterns = "/customer") // This will match the root URL,Spring dispatcher servlet also uses this mapping
public class Customer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Method name: "+req.getMethod());
        System.out.println("Context Path: "+req.getContextPath());
        System.out.println("Servlet Path: "+req.getServletPath());

        //Query String ==> The query string is the part of the URL after the "?" character. It is used to send data to the server.
        System.out.println("Query String: "+req.getQueryString());
        System.out.println("Path info: "+req.getPathInfo());
        System.out.println("Protocol: "+req.getProtocol());
        System.out.println("Scheme: "+req.getScheme());
        System.out.println("URL: "+req.getRequestURL());
        System.out.println("URI: "+req.getRequestURI());

        //Practical usage of getPathTranslated() ==> To get the absolute path of the resource, we can use getPathTranslated() method when we are working with the file system.(Ex: File uploading)
        System.out.println("Path translated: "+req.getPathTranslated());
    }
}
