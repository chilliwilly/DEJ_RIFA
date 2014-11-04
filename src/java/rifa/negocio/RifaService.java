package rifa.negocio;

import java.sql.Connection;
import java.util.ArrayList;
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
    
    public void comprarNumero(Rifa rifa)
    {
        if(numeroExiste(rifa.getNro()))
        {
            // Debe alertar que el numero ya está ocupado por otra persona
        }
        else
        {
            // Debe reservar el numero a la persona
        }
    }
    
    public ArrayList<Rifa> listaNumeros()
    {
        ArrayList<Rifa> listado = new ArrayList<Rifa>();
        RifaDAO dao = new RifaDAO(cnx);
        
        listado = dao.listarNumeros();

        return listado;
    }
    
    public boolean numeroExiste(int numero)
    {
        boolean existe = false;
        
        Rifa nroRifa = new Rifa();
        RifaDAO dao = new RifaDAO(cnx);
        
        nroRifa = dao.buscarNumero(numero);
        
        if(nroRifa.getNombre().equals("(Disponible)"))
        {
            existe = false;
        }
        else
        {
            existe = true;
        }
        
        return existe;
    }
}
