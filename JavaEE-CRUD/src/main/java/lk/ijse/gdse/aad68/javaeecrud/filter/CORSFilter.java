package lk.ijse.gdse.aad68.javaeecrud.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CORSFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        //we need to add the following headers to allow CORS

        var origin = getServletContext().getInitParameter("origin");

        if (origin.contains(getServletContext().getInitParameter("origin"))) {

            res.setHeader("Access-Control-Allow-Origin", origin);

            res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");

            res.setHeader("Access-Control-Allow-Headers", "Content-Type");

            res.setHeader("Access-Control-Expose-Headers", "Content-Type");

        }

        chain.doFilter(req, res); //Passing the request to the next filter in the chain


    }
}
