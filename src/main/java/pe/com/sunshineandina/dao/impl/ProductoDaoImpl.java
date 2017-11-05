/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.sunshineandina.dao.AbstractDAO;
import pe.com.sunshineandina.dao.ProductoDAO;
import pe.com.sunshineandina.dto.CategoriaTO;
import pe.com.sunshineandina.dto.ProductoTO;
import pe.com.sunshineandina.util.Constantes;

/**
 *
 * @author alonsorn
 */
@Repository("productoDao")
public class ProductoDaoImpl extends AbstractDAO<Integer, ProductoTO> implements ProductoDAO {

    @Override
    public ProductoTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void save(ProductoTO producto) {
        persist(producto);
    }

    @Override
    public List<ProductoTO> findByCategoria(int idCategoria) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("estadoProducto", Constantes.ESTADO_ACTIVO));
        criteria.add(Restrictions.eq("categoria.idCategoria", idCategoria));
        return (List<ProductoTO>) criteria.list();
    }

    @Override
    public List<ProductoTO> findPaginado(int inicio, int cantidadPagina) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("estadoProducto", Constantes.ESTADO_ACTIVO));
        criteria.addOrder(Order.asc("nombreProducto"));
        criteria.setFirstResult(inicio);
        criteria.setMaxResults(cantidadPagina);
        return (List<ProductoTO>) criteria.list();
    }

    @Override
    public List<ProductoTO> findByCategoriaPaginado(int idCategoria, int inicio, int cantidadPagina) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("estadoProducto", Constantes.ESTADO_ACTIVO));
        criteria.add(Restrictions.eq("categoria.idCategoria", idCategoria));
        criteria.setFirstResult(inicio);
        criteria.setMaxResults(cantidadPagina);
        return (List<ProductoTO>) criteria.list();
    }

}
