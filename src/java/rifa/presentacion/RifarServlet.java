/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rifa.presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import rifa.estructura.Rifa;
import rifa.negocio.RifaService;

@WebServlet(name = "RifarServlet", urlPatterns = {"/RifarServlet"})
public class RifarServlet extends HttpServlet {

    @Resource(name = "jdbc/rifa")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection cnx = ds.getConnection()){
            ArrayList<Rifa> lista = new ArrayList<Rifa>();
            RifaService rifa = new RifaService(cnx);
            
            lista = rifa.listaGanadores();
            request.setAttribute("lista",lista);
            request.getRequestDispatcher("/ganadoresRifa.jsp").forward(request, response);
        } catch (Exception ex) {
            throw new RuntimeException("Error Mostrando Ganadores Rifa", ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
