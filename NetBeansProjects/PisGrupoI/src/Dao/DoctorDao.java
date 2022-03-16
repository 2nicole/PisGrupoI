
package Dao;

import Entidades.Doctor;
import javafx.collections.ObservableList;

public interface DoctorDao {
    
    public int create(Doctor doctor);
    public int update(Doctor doctor);
    public int delete(int codigo);
    public ObservableList<Doctor> readAll();
    public Doctor read(int codigo); 
}
