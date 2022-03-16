package pedidos.datos;

import java.util.List;

import pedidos.entidades.Cliente;

public interface IClienteDAO 
{
    public void insertar(Cliente c);  
    public void actualizar(Cliente c);
    public void eliminar(int codigo);
    public List<Cliente> listarTodos();
}
