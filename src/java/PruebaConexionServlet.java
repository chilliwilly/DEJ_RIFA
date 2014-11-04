/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian
 */
@WebServlet(urlPatterns = {"/PruebaConexionServlet"})
public class PruebaConexionServlet extends HttpServlet {
    private Connection cnx;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sql = "insert into numero_rifa (rifa_numero, rifa_nombre, rifa_fecha) values (?,?,?)";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)) {
                stmt.setInt(1, 1);
                stmt.setString(2, "Prueba");
                stmt.setInt(3, 3689328);

                stmt.executeUpdate();
        } catch (SQLException ex) {
                throw new RuntimeException("Error al Agregar Pasatiempo", ex);
        }
    }
}
