package rifa.presentacion;

import java.io.IOException;
import java.sql.Connection;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import rifa.negocio.RifaService;



@WebServlet(name = "CrearServlet", urlPatterns = "/CrearServlet")
public class CrearServlet extends HttpServlet{
    
    @Resource(name = "jdbc/rifa")
    private DataSource ds;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int cantNro = Integer.parseInt(req.getParameter("cboCantNro"));
        
        try (Connection cnx = ds.getConnection()){
            RifaService rifa = new RifaService(cnx);
            rifa.crearRifa(cantNro);

            req.setAttribute("estado", "Rifa Registrada Exitosamente!");
            req.getRequestDispatcher("/crearRifa.jsp").forward(req, resp);
        } catch (Exception ex) {
            throw new RuntimeException("Error, En Creación de la Rifa", ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/crearRifa.jsp").forward(req, resp);
    }
    
    
}
