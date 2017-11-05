/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import pe.com.sunshineandina.dto.ClienteTO;

/**
 *
 * @author alonsorn
 */
public interface ClienteDAO {
    
    ClienteTO findById(int id);
    
    void save(ClienteTO cliente);
    
    ClienteTO findByDni(String dni);
}
