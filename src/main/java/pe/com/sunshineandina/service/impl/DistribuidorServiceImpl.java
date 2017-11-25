/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.DistribuidorDAO;
import pe.com.sunshineandina.dto.DistribuidorTO;
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

    @Override
    public DistribuidorTO findByUsuario(int idUsuario) {
        return distribuidorDao.findByUsuario(idUsuario);
    }
    
}
