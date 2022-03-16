package pedidos.datos;

import java.util.ArrayList;
import java.util.List;

import pedidos.entidades.Producto;

public class ProductoCollectionDAO implements IProductoDAO{

    ArrayList<Producto> productoList = new ArrayList<Producto>();

    @Override
    public void insertar(Producto p) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actualizar(Producto p) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void eliminar(int codigo) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Producto> listarTodos() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
