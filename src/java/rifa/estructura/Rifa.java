package rifa.estructura;

import java.sql.Date;

public class Rifa {
    private int nro;
    private String nombre;
    private Date fecha;

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
