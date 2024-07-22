package lk.ijse.gdse.aad68.javaeecrud.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

import java.io.IOException;

//Sample Filter Class : not related to the project security

@WebFilter(urlPatterns = "/*")
public class Security extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("Security Filter is called");
        chain.doFilter(req, res);
    }
}
