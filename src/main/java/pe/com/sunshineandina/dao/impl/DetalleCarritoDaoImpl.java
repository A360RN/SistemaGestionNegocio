/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import pe.com.sunshineandina.dao.AbstractDAO;
import pe.com.sunshineandina.dao.DetalleCarritoDAO;
import pe.com.sunshineandina.dto.DetalleCarritoTO;

/**
 *
 * @author alonsorn
 */
public class DetalleCarritoDaoImpl extends AbstractDAO<Integer, DetalleCarritoTO> implements DetalleCarritoDAO {

    @Override
    public DetalleCarritoTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void save(DetalleCarritoTO detalleCarrito) {
        persist(detalleCarrito);
    }

    @Override
    public List<DetalleCarritoTO> findByCarrito(int idCarrito) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("carrito.idPedido", idCarrito));
        return (List<DetalleCarritoTO>) criteria.list();
    }

}
