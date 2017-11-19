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
    
    @Override
    public List<ProductoTO> findAllProductos() {
        List<ProductoTO> listaProductos= productoDao.findPaginado(0,10);
        for(ProductoTO producto : listaProductos){
            Hibernate.initialize(producto.getCategoria());
        }
        return listaProductos;
    }

    @Override
    public ProductoTO findProductoById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addProducto(ProductoTO producto) {
        productoDao.save(producto);
    }
}
