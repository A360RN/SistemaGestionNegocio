/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.PerfilDAO;
import pe.com.sunshineandina.dao.ProductoDAO;
import pe.com.sunshineandina.dao.UsuarioDAO;
import pe.com.sunshineandina.dto.PerfilTO;
import pe.com.sunshineandina.dto.ProductoTO;
import pe.com.sunshineandina.dto.UsuarioTO;
import pe.com.sunshineandina.service.PruebaService;

/**
 *
 * @author alonsorn
 */
@Service("pruebaService")
@Transactional
public class PruebaServiceImpl implements PruebaService{

    @Autowired
    private UsuarioDAO usuarioDao;
    
    @Autowired
    private PerfilDAO perfilDao;
    
    @Autowired
    private ProductoDAO productoDao;

    @Override
    public void prueba() {
        
        UsuarioTO usuario = new UsuarioTO();
        
        usuario.setRegistroUsuario("Registro1");
        usuario.setPassUsuario("pass1");
        usuario.setEstadoUsuario(1);
        usuario.setFechaRegistro(new Date());
        
        usuarioDao.saveUsuario(usuario);
    }

    @Override
    public void pruebaPerfil() {
        
        UsuarioTO usuario = usuarioDao.findById(1);
        
        List<PerfilTO> perfiles = perfilDao.findAll();
        
        usuario.setPerfiles(perfiles);
        
        usuarioDao.saveUsuario(usuario);
    }

    @Override
    public void pruebaPerfilUsuario() {
        
        UsuarioTO usuario = usuarioDao.findById(1);
        
        //usuario.getPerfiles().forEach(p -> System.out.println(p));
    }

    @Override
    public List<ProductoTO> productos() {
        return productoDao.findByCategoria(1);
    }
    
    
}
