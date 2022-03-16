
package Dao;

import Entidades.Paciente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PacientesDaoImpl implements PacientesDao {
    
    @Override
    public ObservableList<Paciente> readAll(){
        ObservableList<Paciente> pacientesList = FXCollections.observableArrayList();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {   
            conn = Conexion.getConnection();
            st = conn.createStatement();
            String sql = "select * from pacientes order by codigo";
            rs = st.executeQuery(sql);
            while(rs.next()){
                Paciente paciente = new Paciente();
                paciente.setCodigo(rs.getInt("CODIGO"));
                paciente.setCedula(rs.getString("CEDULA"));
                paciente.setNombre(rs.getString("NOMBRE"));
                paciente.setApellido(rs.getString("APELLIDO"));
                paciente.setFecha(rs.getDate("FECHANACIMIENTO").toLocalDate());
                paciente.setEdad(rs.getInt("EDAD"));
                paciente.setSexo(rs.getString("SEXO"));
                paciente.setEstado(rs.getString("ESTADO"));
                paciente.setTelefono(rs.getString("TELEFONO"));
                paciente.setDireccion(rs.getString("DIRECCION"));
                paciente.setEmail(rs.getString("EMAIL"));
                pacientesList.add(paciente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PacientesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                
                if(rs != null){
                    rs.close();
                }
                
                if(st != null){
                    st.close();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(PacientesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pacientesList;
    }
    
    @Override
    public int create(Paciente paciente) {
        int filas = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            st = conn.createStatement();
            String fecha = paciente.getFecha().toString();
            String infoInsert = String.valueOf(paciente.getCodigo())+",'"+paciente.getCedula()
                    +"','"+paciente.getNombre()+"','"+paciente.getApellido()+"'"
                    +",to_Date('"+fecha+"','yyyy-mm-dd'),"+String.valueOf(paciente.getEdad())
                    +",'"+paciente.getSexo().toUpperCase()+"','"+paciente.getEstado().toUpperCase()
                    +"','"+paciente.getTelefono()
                    +"','"+paciente.getDireccion()
                    +"','"+paciente.getEmail()+"'";
            String sql = "insert into pacientes values ("+infoInsert+")";
            
            filas = st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(PacientesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{

            try {
                
                if(st != null){
                    st.close();
                }
                if(rs != null){
                    rs.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(PacientesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filas;
    }

    @Override
    public int update(Paciente paciente) {
        int filas = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {    
            conn = Conexion.getConnection();
            st = conn.createStatement();

            String infoUpdate = "cedula = '"+paciente.getCedula()+"', nombre ='"+paciente.getNombre()
                    +"', apellido ='"+paciente.getApellido()
                    +"', fechanacimiento = to_date('"+ paciente.getFecha().toString()+"','yyyy-mm-dd')"
                    +", edad ="+String.valueOf(paciente.getEdad())+", sexo ='"+paciente.getSexo()
                    +"', estado ='"+paciente.getEstado()+"', telefono ='"+paciente.getTelefono()
                    +"', direccion ='"+paciente.getDireccion()+"', email ='"+paciente.getEmail()+"'";

            String sql = "update pacientes set "+infoUpdate+" where codigo ="+String.valueOf(paciente.getCodigo());
            filas = st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(PacientesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                
                if(st != null){
                    st.close();
                }
                if(rs != null){
                    rs.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(PacientesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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

            String sql = "delete pacientes where codigo = "+codigo;
            filas = st.executeUpdate(sql);
            

        } catch (SQLException ex) {
            Logger.getLogger(PacientesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                
                if(st != null){
                    st.close();
                }
                if(rs != null){
                    rs.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(PacientesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filas;
    }

    @Override
    public Paciente read(int codigo) {
        Paciente paciente = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            st = conn.createStatement();
            String sql = "select * from pacientes where codigo ="+String.valueOf(codigo);
            rs = st.executeQuery(sql);
            if(rs.next()){
                paciente = new Paciente();
                paciente.setCodigo(rs.getInt("CODIGO"));
                paciente.setCedula(rs.getString("CEDULA"));
                paciente.setNombre(rs.getString("NOMBRE"));
                paciente.setApellido(rs.getString("APELLIDO"));
                paciente.setFecha(rs.getDate("FECHANACIMIENTO").toLocalDate());
                paciente.setEdad(rs.getInt("EDAD"));
                paciente.setSexo(rs.getString("SEXO"));
                paciente.setEstado(rs.getString("ESTADO"));
                paciente.setTelefono(rs.getString("TELEFONO"));
                paciente.setDireccion(rs.getString("DIRECCION"));
                paciente.setEmail(rs.getString("EMAIL"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PacientesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                
                if(rs != null){
                    rs.close();
                }
                
                if(st != null){
                    st.close();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(PacientesDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return paciente;
    }
    
}
