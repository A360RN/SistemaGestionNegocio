/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import pe.com.sunshineandina.dao.AbstractDAO;
import pe.com.sunshineandina.dao.DistribuidorDAO;
import pe.com.sunshineandina.dto.DistribuidorTO;

/**
 *
 * @author alonsorn
 */
@Repository("distribuidorDao")
public class DistribuidorDaoImpl extends AbstractDAO<Integer, DistribuidorTO> implements DistribuidorDAO {

    @Override
    public DistribuidorTO findById(int id) {
        return getPorPk(id);
    }

    @Override
    public void save(DistribuidorTO distribuidor) {
        persist(distribuidor);
    }

    @Override
    public DistribuidorTO findByCodigoDistribuidor(String codigoDistribuidor) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("codigoDistribuidor", codigoDistribuidor));
        return (DistribuidorTO) criteria.uniqueResult();
    }

}
