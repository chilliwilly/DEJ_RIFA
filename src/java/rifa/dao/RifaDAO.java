package rifa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import rifa.estructura.Rifa;

public class RifaDAO {
    
    private Connection cnx;
    
    public RifaDAO(Connection cnx){
        this.cnx = cnx;
    }
    
    public void crearRifa(Rifa rifa){
        
        String sql = "INSERT INTO NUMERO_RIFA(RIFA_NUMERO, RIFA_NOMBRE) values(?,?)";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            stmt.setInt(1, rifa.getNro());
            stmt.setString(2, rifa.getNombre());
            stmt.executeUpdate();
            
        } catch (Exception ex) {
            throw new RuntimeException("Error al Crear Rifa", ex);
        }
    }
    
    public void deleteRifa(){
        
        String sql = "DELETE FROM NUMERO_RIFA";
        try(PreparedStatement stmt = cnx.prepareStatement(sql)){
            stmt.executeUpdate();
        } catch (Exception ex){
            throw new RuntimeException("Error al Eliminar Rifa", ex);
        }
    }
    
    public void editarNumero(Rifa rifa){
        //Timestamp ahora = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        
        Calendar calendar = Calendar.getInstance();
        java.sql.Timestamp ahora = new java.sql.Timestamp(calendar.getTime().getTime());

        
        String sql = "UPDATE NUMERO_RIFA SET RIFA_NOMBRE = ?, RIFA_FECHA = ? WHERE RIFA_NUMERO = ?";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            stmt.setString(1, rifa.getNombre());
            stmt.setTimestamp(2, ahora);
            stmt.setInt(3, rifa.getNro());
            stmt.executeUpdate();
            
        } catch (Exception ex) {
            throw new RuntimeException("Error al Actualizar Número", ex);
        }
    }
    
    public ArrayList<Rifa> listarNumeros()
    {
        ArrayList<Rifa> listado = new ArrayList<>();
        
        String sql = "SELECT * FROM NUMERO_RIFA ORDER BY RIFA_NUMERO ASC;";
        try (PreparedStatement stmt = cnx.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next())
            {
                int num = rs.getInt("RIFA_NUMERO");
                String nom = "(Disponible)";
                if(rs.getString("RIFA_NOMBRE") != null){
                    nom = rs.getString("RIFA_NOMBRE");
                }
                Date fecha = rs.getDate("RIFA_FECHA");
                
                Rifa rifa = new Rifa(num, nom);
                rifa.setFecha(rs.getTimestamp("RIFA_FECHA"));
                listado.add(rifa);
            }

            return listado;
            
        } catch (Exception ex) {
            throw new RuntimeException("Error al Buscar Número", ex);
        }
    }
    
    public Rifa buscarNumero(int numero)
    {
       Rifa rifa = new Rifa();
       
       String sql = "SELECT RIFA_NOMBRE, RIFA_FECHA, RIFA_NUMERO FROM NUMERO_RIFA WHERE RIFA_NUMERO = ?";
       try (PreparedStatement stmt = cnx.prepareStatement(sql);){
            stmt.setInt(1, numero);
            try(ResultSet rs = stmt.executeQuery()){            
                if(rs.next())//first()
                {
                    rifa.setNro(rs.getInt("RIFA_NUMERO"));
                    rifa.setNombre(rs.getString("RIFA_NOMBRE"));
                    rifa.setFecha(rs.getTimestamp("RIFA_FECHA"));
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException("Error al Buscar Número", ex);
        }
       return rifa;
    }
    
    public ArrayList<Rifa> seleccionGanadores()
    {
        ArrayList<Rifa> listado = new ArrayList<>();
        String estado = "";
        String sql = "SELECT * FROM NUMERO_RIFA WHERE RIFA_NOMBRE NOT LIKE ? ORDER BY RAND() LIMIT 3;";
        try (PreparedStatement stmt = cnx.prepareStatement(sql);){
            stmt.setString(1, estado);
            try(ResultSet rs = stmt.executeQuery())
            {            
                while(rs.next())
                {
                    int num = rs.getInt("RIFA_NUMERO");
                    String nom = rs.getString("RIFA_NOMBRE");
                    Date fecha = rs.getDate("RIFA_FECHA");

                    Rifa rifa = new Rifa(num, nom);
                    rifa.setFecha(rs.getTimestamp("RIFA_FECHA"));
                    listado.add(rifa);
                }
            }
            
            Collections.sort(listado);
          
            return listado;
            
        } catch (Exception ex) {
            throw new RuntimeException("Error al Buscar Número", ex);
        }
    }
}
