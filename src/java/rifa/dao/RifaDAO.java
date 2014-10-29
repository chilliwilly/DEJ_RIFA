package rifa.dao;

import java.sql.Connection;

public class RifaDAO {
    
    private Connection cnx;
    
    public RifaDAO(Connection cnx){
        this.cnx = cnx;
    }
}
