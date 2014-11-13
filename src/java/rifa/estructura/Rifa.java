package rifa.estructura;

import java.io.Serializable;
import java.sql.Timestamp;

public class Rifa implements Serializable, Comparable{
    private int nro;
    private String nombre;
    private Timestamp fecha;

    public Rifa() {
        //Metodo Constructor
    }

    public Rifa(int nro, String nombre) {
        this.nro = nro;
        this.nombre = nombre;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Override
    public int compareTo(Object rifa) {
        int num = ((Rifa)rifa).getNro();
        
        return nro - num;
    }
}
