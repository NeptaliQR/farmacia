/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Categoria;
import CapaDatos.Composicion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Neptali QR
 */
public class ComposicionBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

   public List<Composicion> reportarComposicion() {
        List<Composicion> lista = new ArrayList<>();
        sql = "select idcomposicion,coNombre,pSerie from composicion order by idcomposicion asc";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
                        
            while (rs.next()) {
                Composicion o_Composicion = new Composicion();

                o_Composicion.setIdcomposicion(rs.getInt(1));
                o_Composicion.setCoNombre(rs.getString(2));
                o_Composicion.setpSerie(rs.getString(3));

                lista.add(o_Composicion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar composicion", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return null;
        }
        return lista;
    }


    public boolean resgistarComposicion(Composicion co) {
        boolean rpta = false;
        sql = "INSERT INTO composicion(idcomposicion,coNombre,pSerie) VALUES(0,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, co.getCoNombre());
            pst.setString(2, co.getpSerie());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e, "Problemas Al Registrar Usuario BD", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return rpta;
        }
        return rpta;
    }


    public boolean eliminarComposicion(int idcomposicion) {
        boolean rpta = false;
        sql = "DELETE FROM composicion WHERE idcomposicion=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idcomposicion);

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Problemas al eliminar",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return rpta;
        }
        return rpta;
    }

}
