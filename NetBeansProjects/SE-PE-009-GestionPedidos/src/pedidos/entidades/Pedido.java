package pedidos.entidades;

import java.time.LocalDate;
import java.util.List;

public class Pedido 
{
    private int secuencia;
    private LocalDate fecha;
    private double subtotal;
    private double iva;
    private double total;

    // Asociaciones 
    Cliente cliente;
    Vendedor vendedor;
    List<LineaPedido> detallePedido;
    
    public int getSecuencia() {
        return secuencia;
    }
    public void setSecuencia(int secuencia) {
        this.secuencia = secuencia;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public double getIva() {
        return iva;
    }
    public void setIva(double iva) {
        this.iva = iva;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<LineaPedido> getDetallePedido() {
        return detallePedido;
    }
    public void setDetallePedido(List<LineaPedido> detallePedido) {
        this.detallePedido = detallePedido;
    }
    

    
    
}
