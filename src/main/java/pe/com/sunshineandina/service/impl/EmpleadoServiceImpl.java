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
import pe.com.sunshineandina.dao.EmpleadoDAO;
import pe.com.sunshineandina.dao.PerfilDAO;
import pe.com.sunshineandina.dao.UsuarioDAO;
import pe.com.sunshineandina.dto.EmpleadoTO;
import pe.com.sunshineandina.dto.PerfilTO;
import pe.com.sunshineandina.service.EmpleadoService;
import pe.com.sunshineandina.util.HashPassword;

/**
 *
 * @author alonsorn
 */
@Service("empleadoService")
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoDAO empleadoDao;
    
    @Autowired
    private UsuarioDAO usuarioDao;
    
    @Autowired
    private PerfilDAO perfilDao;
    
    @Override
    public List<PerfilTO> findAllPerfiles() {
        List<PerfilTO> lstPerfiles = perfilDao.findAll();
        lstPerfiles.remove(0); // CLIENTE
        lstPerfiles.remove(0); // DISTRIBUIDOR
        return lstPerfiles;
    }

    @Override
    public EmpleadoTO findEmpleadoById(int id) {
        return empleadoDao.findById(id);
    }

    @Override
    public EmpleadoTO findEmpleadoByUsuario(int idUsuario) {
        return empleadoDao.findByUsuario(idUsuario);
    }

    @Override
    public void addEmpleado(EmpleadoTO empleado, String[] perfiles) {
        /* Hash password */
        empleado.getUsuario().setPassUsuario(HashPassword.hashPassword(empleado.getUsuario().getPassUsuario()));
        
        /* Obtenemos los Perfiles */
        List<PerfilTO> lstPerfiles = new ArrayList<>();
        for(int i = 0; i < perfiles.length; i++){
            PerfilTO perfil = perfilDao.findByCodigoPerfil(perfiles[i]);
            if(perfil != null){
                lstPerfiles.add(perfil);
            }
        }
        empleado.getUsuario().setPerfiles(lstPerfiles);
        
        empleadoDao.save(empleado);
    }

    @Override
    public List<EmpleadoTO> findAllEmpleados() {
        List<EmpleadoTO> lstEmpleados = empleadoDao.findAll();
        System.out.println("toy listando");
        for(EmpleadoTO empleado: lstEmpleados){
            Hibernate.initialize(empleado.getUsuario());
            Hibernate.initialize(empleado.getUsuario().getPerfiles());
        }
        return lstEmpleados;
    }
    
}
