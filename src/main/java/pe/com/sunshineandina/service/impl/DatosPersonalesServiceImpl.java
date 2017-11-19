/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.ClienteDAO;
import pe.com.sunshineandina.dao.EmpleadoDAO;
import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.dto.EmpleadoTO;
import pe.com.sunshineandina.service.DatosPersonalesService;

/**
 *
 * @author alonsorn
 */
@Service("datosPersonalesService")
@Transactional
public class DatosPersonalesServiceImpl implements DatosPersonalesService{

    @Autowired
    private ClienteDAO clienteDao;
    
    @Autowired
    private EmpleadoDAO empleadoDao;
    
    @Override
    public EmpleadoTO findEmpleadoByUsuario(int idUsuario) {
        return empleadoDao.findByUsuario(idUsuario);
    }

    @Override
    public ClienteTO findClienteByUsuario(int idUsuario) {
        return clienteDao.findByUsuario(idUsuario);
    }

    @Override
    public void actualizarDatosCliente(ClienteTO cliente) {
        if(cliente != null){
            ClienteTO entity = clienteDao.findById(cliente.getIdCliente());
            entity.setDireccion(cliente.getDireccion());
            entity.setEmail(cliente.getEmail());
            entity.setTelefonoCelular(cliente.getTelefonoCelular());
            entity.setTelefonoFijo(cliente.getTelefonoFijo());
            clienteDao.save(entity);
        }
    }

    @Override
    public void actualizarDatosEmpleado(EmpleadoTO empleado) {
        if(empleado != null){
            EmpleadoTO entity = empleadoDao.findById(empleado.getIdEmpleado());
            entity.setEmail(empleado.getEmail());
            entity.setTelefonoCelular(empleado.getTelefonoCelular());
            entity.setTelefonoFijo(empleado.getTelefonoFijo());
            empleadoDao.save(entity);
        }
    }
    
}
