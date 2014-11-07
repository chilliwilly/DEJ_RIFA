package rifa.negocio;

import java.sql.Connection;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    public String comprarNumero(Rifa rifa)
    {
        String msg = "";
//        Date d = (Date) Calendar.getInstance().getTime();
//        DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//        String fecha = df.format(d);
        
        if(numeroExiste(rifa.getNro()))
        {
            msg = "El numero ya ha sido comprado.";
        }
        else
        {
            RifaDAO dao = new RifaDAO(cnx);
            dao.editarNumero(rifa);
            msg = "Compra de numero exitosa!.";
        }
        
        return msg;
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
    
    public ArrayList<Rifa> listaGanadores()
    {
        ArrayList<Rifa> listado = new ArrayList<Rifa>();
        RifaDAO dao = new RifaDAO(cnx);
        
        listado = dao.seleccionGanadores();

        return listado;
    }
}
