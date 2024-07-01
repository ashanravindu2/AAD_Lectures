package lk.ijse.gdse.aad68.intro_aad;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns = "/demo",loadOnStartup = 2)
public class Demo extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("init method called");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("Hello from Demo");

        System.out.println("Thread name: "+Thread.currentThread().getName());
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy method called");
    }

}
