package rifa.negocio;

import java.sql.Connection;
import rifa.dao.RifaDAO;
import rifa.estructura.Rifa;

public class RifaService {
    
    private final String nombre = "(Disponible)";
    private Connection cnx;
    
    public RifaService(Connection cnx){
        this.cnx = cnx;
    }
    
    public void crearRifa(int cantNro){
        RifaDAO dao = new RifaDAO(cnx);
        
        dao.deleteRifa();
        Rifa rifa = new Rifa(1, nombre);
        
        for (int i = 1; i <= cantNro; i++) {
            rifa.setNro(i);
            
            dao.crearRifa(rifa);
        }
    }
}
