/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alonsorn
 */
@Entity(name = "DetalleCarrito")
@Table(name = "TSA_DETALLE_CARRITO")
public class DetalleCarritoTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_carrito")
    private int id_detalle_carrito;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "precio_detalle_carrito")
    private BigDecimal precioDetalleCarrito;

    @Column(name = "puntos_detalle_carrito")
    private int puntosDetalleCarrito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    private ProductoTO producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carrito")
    private CarritoTO carrito;

    public DetalleCarritoTO() {
    }

    public int getId_detalle_carrito() {
        return id_detalle_carrito;
    }

    public void setId_detalle_carrito(int id_detalle_carrito) {
        this.id_detalle_carrito = id_detalle_carrito;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioDetalleCarrito() {
        return precioDetalleCarrito;
    }

    public void setPrecioDetalleCarrito(BigDecimal precioDetalleCarrito) {
        this.precioDetalleCarrito = precioDetalleCarrito;
    }

    public int getPuntosDetalleCarrito() {
        return puntosDetalleCarrito;
    }

    public void setPuntosDetalleCarrito(int puntosDetalleCarrito) {
        this.puntosDetalleCarrito = puntosDetalleCarrito;
    }

    public ProductoTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoTO producto) {
        this.producto = producto;
    }

    public CarritoTO getCarrito() {
        return carrito;
    }

    public void setCarrito(CarritoTO carrito) {
        this.carrito = carrito;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_detalle_carrito;
        hash = 97 * hash + this.cantidad;
        hash = 97 * hash + Objects.hashCode(this.precioDetalleCarrito);
        hash = 97 * hash + this.puntosDetalleCarrito;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DetalleCarritoTO other = (DetalleCarritoTO) obj;
        if (this.id_detalle_carrito != other.id_detalle_carrito) {
            return false;
        }
        if (this.cantidad != other.cantidad) {
            return false;
        }
        if (this.puntosDetalleCarrito != other.puntosDetalleCarrito) {
            return false;
        }
        if (!Objects.equals(this.precioDetalleCarrito, other.precioDetalleCarrito)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DetalleCarritoTO{" + "id_detalle_carrito=" + id_detalle_carrito + ", cantidad=" + cantidad + ", precioDetalleCarrito=" + precioDetalleCarrito + ", puntosDetalleCarrito=" + puntosDetalleCarrito + '}';
    }

}
