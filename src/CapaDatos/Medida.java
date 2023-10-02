/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaDatos;

/**
 *
 * @author Neptali QR
 */
public class Medida {
    
    private int idmedida;
    private String mPresentacion;
    private String mEquivalencia;

    public Medida() {
    }

    public Medida(int idmedida, String mPresentacion, String mEquivalencia) {
        this.idmedida = idmedida;
        this.mPresentacion = mPresentacion;
        this.mEquivalencia = mEquivalencia;
    }

    public int getIdmedida() {
        return idmedida;
    }

    public void setIdmedida(int idmedida) {
        this.idmedida = idmedida;
    }

    public String getmPresentacion() {
        return mPresentacion;
    }

    public void setmPresentacion(String mPresentacion) {
        this.mPresentacion = mPresentacion;
    }

    public String getmEquivalencia() {
        return mEquivalencia;
    }

    public void setmEquivalencia(String mEquivalencia) {
        this.mEquivalencia = mEquivalencia;
    }
    
    
    
    
}
