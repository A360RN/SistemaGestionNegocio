/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.ProductoDAO;
import pe.com.sunshineandina.dto.ProductoTO;
import pe.com.sunshineandina.service.ProductService;

/**
 *
 * @author FERNANDO
 */
@Service("productService")  
@Transactional
public class ProductServiceImpl implements ProductService{
    
    @Autowired
    private ProductoDAO productoDao;
    
    //Lista productos en inventario
    @Override
    public List<ProductoTO> findAllProductosInventario() {
        List<ProductoTO> listaProductos= productoDao.findInventario();
        for(ProductoTO producto : listaProductos){
            Hibernate.initialize(producto.getCategoria());
        }
        return listaProductos;
    }

    @Override
    public ProductoTO findProductoById(int id) {
        ProductoTO producto=productoDao.findById(id);
        Hibernate.initialize(producto.getCategoria());
        return producto;
    }

    @Override
    public void addProducto(ProductoTO producto) {
        productoDao.save(producto);
    }

    @Override
    public void editProducto(ProductoTO producto) {
        if(producto != null){
            ProductoTO productoUpd = productoDao.findById(producto.getIdProducto());
            productoUpd.setNombreProducto(producto.getNombreProducto());
            productoUpd.setCategoria(producto.getCategoria());
            productoUpd.setDescripcionProducto(producto.getDescripcionProducto());
            productoUpd.setPrecioProducto(producto.getPrecioProducto());
            productoUpd.setPuntosProducto(producto.getPuntosProducto());
            productoUpd.setStockProducto(producto.getStockProducto());
            productoDao.save(productoUpd);
        }
    }
    
    @Override
    public void changeProductState(ProductoTO producto){
        if(producto!=null){
            ProductoTO productoUpd=productoDao.findById(producto.getIdProducto());
            if(productoUpd.getEstadoProducto()==1){
                productoUpd.setEstadoProducto(0);
            }
            else if(productoUpd.getEstadoProducto()==0){
                productoUpd.setEstadoProducto(1);
            }
            productoDao.save(productoUpd);
        }
    }
}
