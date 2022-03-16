
package Dao;

import Entidades.CitaMedica;
import javafx.collections.ObservableList;

public interface CitaMedicaDao {
    public int create(CitaMedica cita);
    public int update(CitaMedica cita);
    public int delete(int codigo);
    public ObservableList<CitaMedica> readAll();
    public CitaMedica read(int codigo); 
}
