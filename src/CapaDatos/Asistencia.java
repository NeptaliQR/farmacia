/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

/**
 *
 * @author Neptali QR
 */
public class Asistencia {
    private int idasisencia;
    private String aFechaE;
    private String aHoraR;
    private String aHoraS;
    private String uDniA;
    private String aTurno;
    private String aEstado;
    private String aTienda;

    public Asistencia() {
    }

    public Asistencia(int idasisencia, String aFechaE, String aHoraR, String aHoraS, String uDniA, String aTurno, String aEstado, String aTienda) {
        this.idasisencia = idasisencia;
        this.aFechaE = aFechaE;
        this.aHoraR = aHoraR;
        this.aHoraS = aHoraS;
        this.uDniA = uDniA;
        this.aTurno = aTurno;
        this.aEstado = aEstado;
        this.aTienda = aTienda;
    }

    public int getIdasisencia() {
        return idasisencia;
    }

    public void setIdasisencia(int idasisencia) {
        this.idasisencia = idasisencia;
    }

    public String getaFechaE() {
        return aFechaE;
    }

    public void setaFechaE(String aFechaE) {
        this.aFechaE = aFechaE;
    }

    public String getaHoraR() {
        return aHoraR;
    }

    public void setaHoraR(String aHoraR) {
        this.aHoraR = aHoraR;
    }

    public String getaHoraS() {
        return aHoraS;
    }

    public void setaHoraS(String aHoraS) {
        this.aHoraS = aHoraS;
    }

    public String getuDniA() {
        return uDniA;
    }

    public void setuDniA(String uDniA) {
        this.uDniA = uDniA;
    }

    public String getaTurno() {
        return aTurno;
    }

    public void setaTurno(String aTurno) {
        this.aTurno = aTurno;
    }

    public String getaEstado() {
        return aEstado;
    }

    public void setaEstado(String aEstado) {
        this.aEstado = aEstado;
    }

    public String getaTienda() {
        return aTienda;
    }

    public void setaTienda(String aTienda) {
        this.aTienda = aTienda;
    }
    
    
    
}
