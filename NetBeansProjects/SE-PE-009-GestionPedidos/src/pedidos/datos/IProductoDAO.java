package pedidos.datos;

import java.util.List;

import pedidos.entidades.Producto;

public interface IProductoDAO 
{
    public void insertar(Producto p);  
    public void actualizar(Producto p) ;
    public void eliminar(int codigo) ;
    public List<Producto> listarTodos() ;
}
