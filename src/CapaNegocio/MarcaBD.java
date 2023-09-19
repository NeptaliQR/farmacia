/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Marca;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author labor
 */
public class MarcaBD {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;
    
    public DefaultTableModel reportarMarca() {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"CODIGO", "NOMBRE"};
        String[] registros = new String[2];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "select idmarca,maNombre from marca";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idmarca");
                registros[1] = rs.getString("maNombre");
                tabla_temporal.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar marca", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_temporal;
    }

    public boolean registraMarca(Marca m) {
        boolean rpta = false;
        sql = "insert into marca(idmarca,maNombre)values(0,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, m.getMaNombre());
            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al registrar marca", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean modificarMarca(Marca m) {
        boolean rpta = false;
        sql = "";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, m.getMaNombre());
            pst.setInt(2, m.getIdmarca());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al modificar marca", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarMarca(int idmarca) {
        boolean rpta = false;
        sql = "";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idmarca);

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al modificar marca", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public DefaultTableModel buscarMarca(String nombre) {
        DefaultTableModel tabla_temporal;
        String[] titulos = {"CODIGO", "NOMBRE"};
        String[] registros = new String[2];
        tabla_temporal = new DefaultTableModel(null, titulos);
        sql = "";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + nombre + "%");
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                registros[0] = rs.getString("idmarca");
                registros[1] = rs.getString("maNombre");
                tabla_temporal.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error al buscar marca", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return tabla_temporal;
    }
    
}
