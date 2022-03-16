package pedidos.entidades;

public class LineaPedido 
{
    private int numero;
    private int cantidad;

    // asociacion Producto
    private Producto producto;

    //#region Metodos de acceso

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    //#endregion
    


}
