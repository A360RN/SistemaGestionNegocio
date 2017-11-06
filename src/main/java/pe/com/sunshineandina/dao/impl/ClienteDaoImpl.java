/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.sunshineandina.dao.AbstractDAO;
import pe.com.sunshineandina.dao.ClienteDAO;
import pe.com.sunshineandina.dto.ClienteTO;

/**
 *
 * @author alonsorn
 */
@Repository("clienteDao")
public class ClienteDaoImpl extends AbstractDAO<Integer, ClienteTO> implements ClienteDAO{

    @Override
    public ClienteTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void save(ClienteTO cliente) {
        persist(cliente);
    }

    @Override
    public ClienteTO findByDni(String dni) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("dni", dni));
        return (ClienteTO) criteria.uniqueResult();
    }
    
    
}