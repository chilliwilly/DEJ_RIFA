package rifa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
