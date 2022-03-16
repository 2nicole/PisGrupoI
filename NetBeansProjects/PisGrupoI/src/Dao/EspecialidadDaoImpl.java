
package Dao;

import Entidades.Doctor;
import Entidades.Especialidad;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class EspecialidadDaoImpl  implements EspecialidadDao{

    @Override
    public ObservableList<Especialidad> readAll(){
        ObservableList<Especialidad> EspecialidadList = FXCollections.observableArrayList();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            st = conn.createStatement();
            String sql = "select * from especialidad order by cod_especialidad";
            rs = st.executeQuery(sql);
            while(rs.next()){
                Especialidad especialidad = new Especialidad();
                especialidad.setCodigo(rs.getInt("COD_ESPECIALIDAD"));
                especialidad.setEspDoctor(rs.getString("NOMBRE"));
   
                EspecialidadList.add(especialidad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                
                if(rs != null){
                    rs.close();
                }
                
                if(st != null){
                    st.close();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(EspecialidadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return EspecialidadList;
    }
         
    @Override
    public int create(Especialidad especialidad) {
        int filas = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            st = conn.createStatement();
            
            String infoInsert = String.valueOf(especialidad.getCodigo())+
                    ", '"+especialidad.getEspDoctor().toUpperCase()+"'";
            String sql = "insert into especialidad values ("+infoInsert+")";
            
            filas = st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{

            try {
                
                if(st != null){
                    st.close();
                }
                if(rs != null){
                    rs.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(EspecialidadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return filas;
    }

    @Override
    public int update(Especialidad especialidad) {
        int filas = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            st = conn.createStatement();

            String infoUpdate = "NOMBRE ="+especialidad.getEspDoctor();

            String sql = "update especialidad set "+infoUpdate+" where cod_especialidad ="+String.valueOf(especialidad.getCodigo());
            filas = st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                
                if(st != null){
                    st.close();
                }
                if(rs != null){
                    rs.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(EspecialidadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filas;
    }

    @Override
    public int delete(int codigo) {
        int filas = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            
            conn = Conexion.getConnection();
            st = conn.createStatement();

            String sql = "delete especialidad where cod_especialidad = "+codigo;
            filas = st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                
                if(st != null){
                    st.close();
                }
                if(rs != null){
                    rs.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(EspecialidadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
       return filas;
    }

    @Override
    public Especialidad read(int codigo) {
        Especialidad especialidad = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {  
            conn = Conexion.getConnection();
            st = conn.createStatement();
            String sql = "select * from especialidad where cod_especialidad ="+codigo;
            rs = st.executeQuery(sql);
            if(rs.next()){
                especialidad = new Especialidad();
                especialidad.setCodigo(rs.getInt("COD_ESPECIALIDAD"));
                especialidad.setEspDoctor(rs.getString("NOMBRE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                
                if(rs != null){
                    rs.close();
                }
                
                if(st != null){
                    st.close();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(EspecialidadDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return especialidad;
    }
    
}
