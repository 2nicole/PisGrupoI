
package Dao;
import Entidades.Paciente;
import javafx.collections.ObservableList;

public interface PacientesDao {
    public int create(Paciente paciente);
    public int update(Paciente paciente);
    public int delete(int codigo);
    public ObservableList<Paciente> readAll();
    public Paciente read(int codigo); 
}
