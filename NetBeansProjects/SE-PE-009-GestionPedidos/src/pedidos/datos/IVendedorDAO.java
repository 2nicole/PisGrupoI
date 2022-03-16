package pedidos.datos;

import java.util.List;

import pedidos.entidades.Vendedor;

public interface IVendedorDAO 
{
    public void insertar(Vendedor p);  
    public void actualizar(Vendedor p) ;
    public void eliminar(int codigo) ;
    public List<Vendedor> listarTodos() ;
}
