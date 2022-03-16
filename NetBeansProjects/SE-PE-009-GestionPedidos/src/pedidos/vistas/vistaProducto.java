package pedidos.vistas;

import pedidos.datos.IProductoDAO;
import pedidos.datos.ProductoCollectionDAO;
import pedidos.entidades.Producto;

public class vistaProducto {
    public static void main(String[] args) {
        Producto p1 = new Producto(10, "MEMORIA RAM KINGSRTONG 16GB", 38.59);
        Producto p2 = new Producto(20, "DISCO DURO MAXTOR 1T", 95.86);
        Producto p3 = new Producto(30, "MONITOR VIEW SONIC 19P", 47.12);

        IProductoDAO daoProductos = new ProductoCollectionDAO();
        daoProductos.insertar(p1);
        daoProductos.insertar(p2);
        daoProductos.insertar(p3);

        System.out.println(daoProductos.listarTodos());

    }
}
