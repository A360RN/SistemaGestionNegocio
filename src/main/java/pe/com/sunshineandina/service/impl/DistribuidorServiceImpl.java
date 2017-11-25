/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.ComisionDAO;
import pe.com.sunshineandina.dao.DistribuidorDAO;
import pe.com.sunshineandina.dao.HistoricoDistribuidorDAO;
import pe.com.sunshineandina.dto.ComisionTO;
import pe.com.sunshineandina.dto.DistribuidorTO;
import pe.com.sunshineandina.dto.HistoricoDistribuidorTO;
import pe.com.sunshineandina.service.DistribuidorService;

/**
 *
 * @author alonsorn
 */
@Service("distribuidorService")
@Transactional
public class DistribuidorServiceImpl implements DistribuidorService{
    
    @Autowired
    private DistribuidorDAO distribuidorDao;
    
    @Autowired
    private ComisionDAO comisionDao;
    
    @Autowired
    private HistoricoDistribuidorDAO historicoDistribuidorDao;

    @Override
    public DistribuidorTO findByUsuario(int idUsuario) {
        return distribuidorDao.findByUsuario(idUsuario);
    }

    @Override
    public List<ComisionTO> findComisionesByParameters(int idDistribuidor, int mes, int anio) {
        return comisionDao.findByParameters(idDistribuidor, mes, anio);
    }

    @Override
    public List<HistoricoDistribuidorTO> findVentasByPadreAndParameters(int idPadre, int mes, int anio) {
        /* List para guardar los historicos de los descendientes */
        List<HistoricoDistribuidorTO> ventasDescendientes = new ArrayList<>();
        /* Hallamos el distribuidor padre */
        DistribuidorTO padre = distribuidorDao.findById(idPadre);
        /* Obtenemos los descendientes */
        Hibernate.initialize(padre.getDescendientes());
        List<DistribuidorTO> descendientes = padre.getDescendientes();
        
        for(DistribuidorTO descendiente: descendientes){
            System.out.println("id descendiente: " + descendiente.getIdDistribuidor());
            HistoricoDistribuidorTO historicoDescendiente = 
                    historicoDistribuidorDao.findByParameters(descendiente.getIdDistribuidor(), mes, anio).get(0);
            ventasDescendientes.add(historicoDescendiente);
        }
        return ventasDescendientes;
    }

    @Override
    public DistribuidorTO findById(int idDitribuidor) {
        return distribuidorDao.findById(idDitribuidor);
    }

    
}
