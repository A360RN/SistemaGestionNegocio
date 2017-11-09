/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.sunshineandina.dao.AbstractDAO;
import pe.com.sunshineandina.dao.CarritoDAO;
import pe.com.sunshineandina.dto.CarritoTO;

/**
 *
 * @author alonsorn
 */
@Repository("carritoDao")
public class CarritoDaoImpl extends AbstractDAO<Integer, CarritoTO> implements CarritoDAO{

    @Override
    public CarritoTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void save(CarritoTO carrito) {
        persist(carrito);
    }

    @Override
    public List<CarritoTO> findByCliente(int idCliente) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cliente.idCliente", idCliente));
        return (List<CarritoTO>) criteria.list();
    }

    @Override
    public List<CarritoTO> findByClienteFecha(int idCliente, Date fechaInicio, Date fechaFin) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cliente.idCliente", idCliente));
        criteria.add(Restrictions.between("fechaModificacion", fechaInicio, fechaFin));
        criteria.addOrder(Order.desc("fechaModificacion"));
        return (List<CarritoTO>) criteria.list();
    }

    @Override
    public List<CarritoTO> findByClienteFechaPaginado(int idCliente, Date fechaInicio, Date fechaFin, int inicio, int cantidadPagina) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cliente.idCliente", idCliente));
        criteria.add(Restrictions.between("fechaModificacion", fechaInicio, fechaFin));
        criteria.addOrder(Order.desc("fechaModificacion"));
        criteria.setFirstResult(inicio);
        criteria.setMaxResults(cantidadPagina);
        return (List<CarritoTO>) criteria.list();
    }

    @Override
    public void destroy(CarritoTO carrito) {
        delete(carrito);
    }
    
    
}
