
package Dao;

import Entidades.Doctor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DoctorDaoImpl implements DoctorDao{

    @Override
    public ObservableList<Doctor> readAll(){
        ObservableList<Doctor> doctoresList = FXCollections.observableArrayList();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            
            conn = Conexion.getConnection();
            st = conn.createStatement();
            String sql = "select doc.codigo,doc.cedula, doc.nombre, doc.apellido, doc.fechanacimiento, doc.edad, doc.sexo, doc.estado, doc.telefono, doc.direccion, doc.email, esp.nombre as esp_doctor, esp.cod_especialidad\n" +
"from doctores doc, especialidad esp where doc.codigo = esp.cod_especialidad order by doc.codigo";
            rs = st.executeQuery(sql);
            while(rs.next()){
                Doctor doctor = new Doctor();
                doctor.setCodigo(rs.getInt("CODIGO"));
                doctor.setCedula(rs.getString("CEDULA"));
                doctor.setNombre(rs.getString("NOMBRE"));
                doctor.setApellido(rs.getString("APELLIDO"));
                doctor.setFecha(rs.getDate("FECHANACIMIENTO").toLocalDate());
                doctor.setEdad(rs.getInt("EDAD"));
                doctor.setSexo(rs.getString("SEXO"));
                doctor.setEstado(rs.getString("ESTADO"));
                doctor.setTelefono(rs.getString("TELEFONO"));
                doctor.setDireccion(rs.getString("DIRECCION"));
                doctor.setEmail(rs.getString("EMAIL"));
                doctor.setCodEsp(rs.getInt("COD_ESPECIALIDAD"));
                doctor.setEspecialidad(rs.getString("ESP_DOCTOR"));
                doctoresList.add(doctor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                if(rs != null){
                    rs.close();
                }
                
                if(st != null){
                    st.close();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return doctoresList;
    }
    
    @Override
    public int create(Doctor doctor) {
        int filas = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            st = conn.createStatement();
            
            String infoInsert = String.valueOf(doctor.getCodigo())+",'"+doctor.getCedula()+"','"
                    +doctor.getNombre()+"','"+doctor.getApellido()
                    +"',to_Date('"+doctor.getFecha().toString()+"','yyyy-mm-dd'),"+String.valueOf(doctor.getEdad())+",'"
                    +doctor.getSexo().toUpperCase()+"','"+doctor.getEstado().toUpperCase()+"','"+doctor.getTelefono()
                    +"','"+doctor.getDireccion()+"','"+doctor.getEmail()+"',"+doctor.getCodEsp();
            String sql = "insert into doctores values ("+infoInsert+")";
            
            filas = st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{

            try {
                
                if(st != null){
                    st.close();
                }
                if(rs != null){
                    rs.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filas;
    }

    @Override
    public int update(Doctor doctor) {
        int filas = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            st = conn.createStatement();

            String infoUpdate = "cedula = '"+doctor.getCedula()+"', nombre ='"+doctor.getNombre()
                    +"', apellido ='"+doctor.getApellido()
                    +"', fechanacimiento = to_date('"+ doctor.getFecha().toString()+"','yyyy-mm-dd')"
                    +", edad ="+String.valueOf(doctor.getEdad())+", sexo ='"+doctor.getSexo()
                    +"', estado ='"+doctor.getEstado()+"', telefono ='"+doctor.getTelefono()
                    +"', direccion ='"+doctor.getDireccion()+"', email ='"+doctor.getEmail()
                    +"', especialidad = "+doctor.getCodEsp();

            String sql = "update doctores set "+infoUpdate+" where codigo ="+String.valueOf(doctor.getCodigo());
            filas = st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                
                if(st != null){
                    st.close();
                }
                if(rs != null){
                    rs.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
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

            String sql = "delete doctores where codigo = "+codigo;
            filas = st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                
                if(st != null){
                    st.close();
                }
                if(rs != null){
                    rs.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return filas;
    }

    @Override
    public Doctor read(int codigo) {
        Doctor doctor = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            st = conn.createStatement();
            String sql = "select * from doctores where codigo ="+codigo;
            rs = st.executeQuery(sql);
            if(rs.next()){
                doctor = new Doctor();
                doctor.setCodigo(rs.getInt("CODIGO"));
                doctor.setCedula(rs.getString("CEDULA"));
                doctor.setNombre(rs.getString("NOMBRE"));
                doctor.setApellido(rs.getString("APELLIDO"));
                doctor.setFecha(rs.getDate("FECHANACIMIENTO").toLocalDate());
                doctor.setEdad(rs.getInt("EDAD"));
                doctor.setSexo(rs.getString("SEXO"));
                doctor.setEstado(rs.getString("ESTADO"));
                doctor.setTelefono(rs.getString("TELEFONO"));
                doctor.setDireccion(rs.getString("DIRECCION"));
                doctor.setEmail(rs.getString("EMAIL"));
                doctor.setEspecialidad(rs.getString("ESPECIALIDAD"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                
                if(rs != null){
                    rs.close();
                }
                
                if(st != null){
                    st.close();
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(DoctorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return doctor;
    }
    
}
