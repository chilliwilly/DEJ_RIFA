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
import rifa.estructura.Rifa;
import rifa.negocio.RifaService;


@WebServlet(name = "ComprarServlet", urlPatterns = {"/ComprarServlet"})
public class ComprarServlet extends HttpServlet {

    @Resource(name = "jdbc/rifa")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int nrorifa = Integer.parseInt(request.getParameter("numero"));
        
        request.setAttribute("rifaNumero", nrorifa);
        request.getRequestDispatcher("/comprarRifa.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int nrorifa = Integer.parseInt(request.getParameter("numero"));
        String nombrerifa = request.getParameter("nombre");
        
        String mensaje = "";
        String error = "";
        
        try (Connection cnx = ds.getConnection()){
            Rifa r = new Rifa(nrorifa, nombrerifa);
            RifaService rifa = new RifaService(cnx);            
            
            mensaje = rifa.comprarNumero(r);
            
            if("El numero ya ha sido comprado.".equals(mensaje)){
                error = "Error";
            }
            
            request.setAttribute("mensajeCompra",mensaje);
            request.setAttribute("error", error);
            request.getRequestDispatcher("/resultadoCompra.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new RuntimeException("Error", ex);
        }
    }
}
