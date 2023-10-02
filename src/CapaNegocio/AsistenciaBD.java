/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Asistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author labor
 */
public class AsistenciaBD {
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();   //conectar viene de la clase conexion
    private String sql;

    public List<Asistencia> buscarAsistenciaUsuario(String usuario_uDni, String tienda, String fecha) {
        List<Asistencia> lista = new ArrayList<>();
        sql = "select idasistencia,aFechaE,aHoraR,aHoraS,uDniA,aTurno,aEstado,aTienda from asistencia "
                + "where uDniA=? and aTienda=? and aFechaE=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, usuario_uDni);
            pst.setString(2, tienda);
            pst.setString(3, fecha);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Asistencia oAsistencia = new Asistencia();

                oAsistencia.setIdasisencia(rs.getInt(1));
                oAsistencia.setaFechaE(rs.getString(2));
                oAsistencia.setaHoraR(rs.getString(3));
                oAsistencia.setaHoraS(rs.getString(4));
                oAsistencia.setuDniA(rs.getString(5));
                oAsistencia.setaTurno(rs.getString(6));
                oAsistencia.setaEstado(rs.getString(7));
                oAsistencia.setaTienda(rs.getString(8));

                lista.add(oAsistencia);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al buscar Asistencia", JOptionPane.ERROR_MESSAGE);
        }
        return lista;
    }

    public int registrarAsistencia(Asistencia a) {
        int idasistencia = 0;
        sql = "insert into asistencia(idasistencia,aFechaE,aHoraR,aHoraS,uDniA,aTurno,aEstado,aTienda)values(0,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, a.getaFechaE());
            pst.setString(2, a.getaHoraR());
            pst.setString(3, a.getaHoraS());
            pst.setString(4, a.getuDniA());
            pst.setString(5, a.getaTurno());
            pst.setString(6, a.getaEstado());
            pst.setString(7, a.getaTienda());

            pst.executeUpdate();
            ResultSet resultado = (ResultSet) pst.getGeneratedKeys();
            if (resultado.next()) {
                idasistencia = resultado.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error al reportar Asistencia", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return idasistencia;

    }
  
    
}
