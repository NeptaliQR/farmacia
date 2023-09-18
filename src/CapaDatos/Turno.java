/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

/**
 *
 * @author labor
 */
public class Turno {
    private int idturno;
    private String descripcion;
    private String inicio;
    private String fin;
    private String uDniT;
    private String tuNombre;

    public Turno() {
    }

    public int getIdturno() {
        return idturno;
    }

    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getuDniT() {
        return uDniT;
    }

    public void setuDniT(String uDniT) {
        this.uDniT = uDniT;
    }

    public String getTuNombre() {
        return tuNombre;
    }

    public void setTuNombre(String tuNombre) {
        this.tuNombre = tuNombre;
    }
    
    
    
}
