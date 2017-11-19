/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.dto.EmpleadoTO;

/**
 *
 * @author alonsorn
 */
public interface DatosPersonalesService {
    
    EmpleadoTO findEmpleadoByUsuario(int idUsuario);
    
    ClienteTO findClienteByUsuario(int idUsuario);
    
    void actualizarDatosCliente(ClienteTO cliente);
    
    void actualizarDatosEmpleado(EmpleadoTO empleado);
}
