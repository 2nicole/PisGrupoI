package pedidos.vistas;

import pedidos.datos.IVendedorDAO;
import pedidos.datos.VendedorCollectionDAO;
import pedidos.entidades.Vendedor;

public class vistaVendedor {
    public static void main(String[] args) {
        Vendedor v1 = new Vendedor(101, "0979811755", "Juan Piguave");
        Vendedor v2 = new Vendedor(102, "0953820107", "Victor Calderon");
        Vendedor v3 = new Vendedor(103, "0984758921", "Sofia Sanchez");

        IVendedorDAO daoVendedor = new VendedorCollectionDAO();

        daoVendedor.insertar(v1);
        daoVendedor.insertar(v2);
        daoVendedor.insertar(v3);

        System.out.println(daoVendedor.listarTodos());
    }
}
