/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.EmpleadoTO;
import pe.com.sunshineandina.dto.PerfilTO;

/**
 *
 * @author alonsorn
 */
public interface EmpleadoService {
    
    List<PerfilTO> findAllPerfiles();
    
    List<EmpleadoTO> findAllEmpleados();
    
    EmpleadoTO findEmpleadoById(int id);
    
    EmpleadoTO findEmpleadoByUsuario(int idUsuario);
    
    void addEmpleado(EmpleadoTO empleado, String[] perfiles);
}
