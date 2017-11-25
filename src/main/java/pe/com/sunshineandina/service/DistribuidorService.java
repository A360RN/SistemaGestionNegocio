/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import pe.com.sunshineandina.dto.DistribuidorTO;

/**
 *
 * @author alonsorn
 */
public interface DistribuidorService {
    
    public DistribuidorTO findByUsuario(int idUsuario);
}
