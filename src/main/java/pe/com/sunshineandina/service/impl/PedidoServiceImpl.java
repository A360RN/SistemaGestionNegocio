/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.CarritoDAO;
import pe.com.sunshineandina.dao.ClienteDAO;
import pe.com.sunshineandina.dao.DetalleCarritoDAO;
import pe.com.sunshineandina.dao.PedidoDAO;
import pe.com.sunshineandina.dao.ProductoDAO;
import pe.com.sunshineandina.dto.CarritoTO;
import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.dto.DetalleCarritoTO;
import pe.com.sunshineandina.dto.DetallePedidoTO;
import pe.com.sunshineandina.dto.PedidoTO;
import pe.com.sunshineandina.dto.ProductoTO;
import pe.com.sunshineandina.service.PedidoService;
import pe.com.sunshineandina.util.Constantes;

/**
 *
 * @author FERNANDO
 */
@Service("pedidoService")
@Transactional(rollbackFor = Exception.class)
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoDAO pedidoDao;

    @Autowired
    private CarritoDAO carritoDao;

    @Autowired
    private ProductoDAO productoDao;

    @Autowired
    private ClienteDAO clienteDao;
    
    @Autowired
    private DetalleCarritoDAO detalleCarritoDAO;

    @Override
    public List<PedidoTO> findAllPedidos() {
        List<PedidoTO> listaPedidos = pedidoDao.findAllPedidos();
        for (PedidoTO pedido : listaPedidos) {
            Hibernate.initialize(pedido.getCliente());
        }
        return listaPedidos;
    }

    @Override
    public PedidoTO findPedidoById(int id) {
        PedidoTO pedido = pedidoDao.findById(id);
        return pedido;
    }

    @Override
    public void actualizarPedido(PedidoTO pedido) {
        if (pedido != null) {
            PedidoTO pedidoUpd = pedidoDao.findById(pedido.getIdPedido());
            pedidoUpd.setEstadoPedido(pedido.getEstadoPedido());
            pedidoDao.save(pedidoUpd);
        }
    }

    @Override
    public String nuevoPedido(int idUsuario) {
        StringBuilder rpta = new StringBuilder(); 
        try {
            /* Hallamos el cliente actual */
            ClienteTO cliente = clienteDao.findByUsuario(idUsuario);
            int idCliente = cliente.getIdCliente();
            
            /* Hallamos el carrito del cliente actual */
            CarritoTO carrito = carritoDao.findByCliente(idCliente);
            
            /* Validamos el stock del producto */
            for(DetalleCarritoTO detalle: carrito.getDetalleCarritos()){
                Hibernate.initialize(detalle.getProducto());
                ProductoTO producto = detalle.getProducto();
                rpta.append(validarStock(producto, detalle.getCantidad()));
            }
            
            if(!rpta.toString().equals("")){
                return rpta.toString();
            }
            
            /* Creamos el pedido */
            PedidoTO pedido = new PedidoTO();
            pedido.setCliente(cliente);
            pedido.setEstadoPedido(Constantes.ESTADO_PEDIDO_PENDIENTE);
            pedido.setFechaCreacion(new Date());
            pedido.setFechaModificacion(new Date());
            pedido.setPrecioAcumuladoPedido(carrito.getPrecioAcumuladoCarrito());
            pedido.setPuntosAcumuladoPedido(carrito.getPuntosAcumuladoCarrito());
            
            List<DetallePedidoTO> lstDetallePedido = new ArrayList<>();
            
            for(DetalleCarritoTO detalleCarrito : carrito.getDetalleCarritos()){
                /* Agregamos los detalles del pedido */
                DetallePedidoTO detallePedido = new DetallePedidoTO();
                detallePedido.setPedido(pedido);
                detallePedido.setCantidad(detalleCarrito.getCantidad());
                detallePedido.setPrecioDetallePedido(detalleCarrito.getPrecioDetalleCarrito());
                detallePedido.setProducto(detalleCarrito.getProducto());
                detallePedido.setPuntosDetallePedido(detalleCarrito.getPuntosDetalleCarrito());
                lstDetallePedido.add(detallePedido);
                
                /* Actualizamos el stock */
                ProductoTO producto = productoDao.findById(detalleCarrito.getProducto().getIdProducto());
                producto.setStockProducto(producto.getStockProducto() - detalleCarrito.getCantidad());
                productoDao.save(producto);
            }
            /* Guardamos el pedido */
            pedido.setDetallePedidos(lstDetallePedido);
            pedidoDao.save(pedido);
            
            /* Borramos el pedido */
            CarritoTO carritoBorrar = carritoDao.findByCliente(idCliente);
            carritoDao.destroy(carrito);
            
            rpta.append(Constantes.PEDIDO_REGISTRADO_EXITO);
            
            
        } catch (Exception e) {
            rpta = new StringBuilder();
            rpta.append(Constantes.ERROR_GENERICO_PEDIDO);
            return rpta.toString();
        }
        
        return rpta.toString();
    }

    @Override
    public String validarStock(ProductoTO producto, int cantidad) throws Exception{
        try {
            String rpta = "";
            if(producto.getStockProducto() == 0){
                rpta = String.format(Constantes.ERROR_STOCK_AGOTADO, producto.getNombreProducto());
            }else if(producto.getStockProducto() < cantidad){
                rpta = String.format(Constantes.ERROR_STOCK_INSUFICIENTE, producto.getStockProducto(), producto.getNombreProducto());
            }
            return rpta;
        } catch (Exception e) {
            throw e;
        }
    }

}
