package rifa.presentacion;

import java.io.IOException;
import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CrearServlet", urlPatterns = "/CrearServlet")
public class CrearServlet extends HttpServlet{
    
    //@Resource(name = "jdbc/rifa")
    private DataSource ds;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/crearRifa.jsp").forward(req, resp);
    }
    
    
}
