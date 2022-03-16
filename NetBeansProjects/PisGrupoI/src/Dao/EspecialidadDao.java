/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entidades.Especialidad;
import javafx.collections.ObservableList;

/**
 *
 * @author DELL
 */
public interface EspecialidadDao {
    public int create(Especialidad especialidad);
    public int update(Especialidad especialidad);
    public int delete(int codigo);
    public ObservableList<Especialidad> readAll();
    public Especialidad read(int codigo); 
}
