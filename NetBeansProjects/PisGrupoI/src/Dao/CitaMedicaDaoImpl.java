
package Dao;

import Entidades.CitaMedica;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CitaMedicaDaoImpl implements CitaMedicaDao{
    
    @Override
    public ObservableList<CitaMedica> readAll(){
        ObservableList<CitaMedica> citasList = FXCollections.observableArrayList();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            
            conn = Conexion.getConnection();
            st = conn.createStatement();
            
            String sql = "select ci.cod_cita, ci.cod_paciente, pac.nombre as nombre_paciente, pac.apellido as apellido_paciente, ci.cod_doctor , doc.nombre as nombre_doctor, doc.apellido as apellido_doctor\n" +
",esp.nombre as especialidad_doctor, ci.fecha, ci.hora, ci.nota, ci.estado, ci.estado_pago, ci.costo\n" +
"from citas ci, doctores doc, pacientes pac, especialidad esp where ci.cod_doctor = doc.codigo and ci.cod_paciente = pac.codigo and doc.especialidad = esp.cod_especialidad order by ci.cod_cita";
            
            rs = st.executeQuery(sql);
            while(rs.next()){
                CitaMedica cita = new CitaMedica();
                cita.setCodigo(rs.getInt("COD_CITA"));
                cita.setPaciente(rs.getInt("COD_PACIENTE"));
                cita.setNombrePaciente(rs.getString("NOMBRE_PACIENTE")+" "+rs.getString("APELLIDO_PACIENTE"));
                cita.setDoctor(rs.getInt("COD_DOCTOR"));
                cita.setNombreDoctor(rs.getString("NOMBRE_DOCTOR")+" "+rs.getString("APELLIDO_DOCTOR"));
                cita.setEspDoctor(rs.getString("ESPECIALIDAD_DOCTOR"));
                cita.setFechaCita(rs.getDate("FECHA").toLocalDate());
                cita.setHora(rs.getString("HORA"));
                cita.setNota(rs.getString("NOTA"));
                cita.setEstadoCita(rs.getString("ESTADO"));
                cita.setEstadoPago(rs.getString("ESTADO_PAGO"));
                cita.setCosto(rs.getFloat("COSTO"));
                citasList.add(cita);
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
        return citasList;
    }
    
    @Override
    public int create(CitaMedica cita) {
        int filas = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            
            conn = Conexion.getConnection();
            st = conn.createStatement();
            
            String infoInsert = String.valueOf(cita.getPaciente()) +", "+String.valueOf(cita.getDoctor())
                    +",to_Date('"+cita.getFechaCita().toString()+"','yyyy-mm-dd'),'"+cita.getHora()
                    +"', '"+cita.getNota()+"', '"+cita.getEstadoCita()
                    +"', '"+cita.getEstadoPago()+"', "+cita.getCosto()+", "+cita.getCodigo();
            String sql = "insert into citas values ("+infoInsert+")";
            
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
    public int update(CitaMedica cita) {
        int filas = 0;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            st = conn.createStatement();

            String infoUpdate = "COD_PACIENTE ="+cita.getPaciente()+", COD_DOCTOR ="+cita.getDoctor()
                    +", FECHA = to_Date('"+cita.getFechaCita().toString()+"','yyyy-mm-dd')"
                    +", HORA = '"+cita.getHora()+"', NOTA = '"+cita.getNota()
                    +"', ESTADO = '"+cita.getEstadoCita()+"', ESTADO_PAGO = '"+cita.getEstadoPago()
                    +"', COSTO ="+cita.getCosto();

            String sql = "update citas set "+infoUpdate+" where cod_cita ="+String.valueOf(cita.getCodigo());
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

            String sql = "delete citas where cod_cita = "+codigo;
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
    public CitaMedica read(int codigo) {
        CitaMedica cita = null;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            st = conn.createStatement();
            String sql = "select ci.cod_cita, ci.cod_paciente, pac.nombre as nombre_paciente, pac.apellido as apellido_paciente, ci.cod_doctor , doc.nombre as nombre_doctor, doc.apellido as apellido_doctor\n" +
",esp.nombre as especialidad_doctor, ci.fecha, ci.hora, ci.nota, ci.estado, ci.estado_pago, ci.costo\n" +
"from citas ci, doctores doc, pacientes pac, especialidad esp where ci.cod_doctor = doc.codigo and ci.cod_paciente = pac.codigo and doc.especialidad = esp.cod_especialidad and ci.cod_cita ="+codigo;
            rs = st.executeQuery(sql);
            if(rs.next()){
                cita = new CitaMedica();
                cita.setCodigo(rs.getInt("COD_CITA"));
                cita.setPaciente(rs.getInt("COD_PACIENTE"));
                cita.setNombrePaciente(rs.getString("NOMBRE_PACIENTE")+" "+rs.getString("APELLIDO_PACIENTE"));
                cita.setDoctor(rs.getInt("COD_DOCTOR"));
                cita.setNombreDoctor(rs.getString("NOMBRE_DOCTOR")+" "+rs.getString("APELLIDO_DOCTOR"));
                cita.setEspDoctor(rs.getString("ESPECIALIDAD_DOCTOR"));
                cita.setFechaCita(rs.getDate("FECHA").toLocalDate());
                cita.setHora(rs.getString("HORA"));
                cita.setNota(rs.getString("NOTA"));
                cita.setEstadoCita(rs.getString("ESTADO"));
                cita.setEstadoPago(rs.getString("ESTADO_PAGO"));
                cita.setCosto(rs.getFloat("COSTO"));
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
        return cita;
    }
    
}
