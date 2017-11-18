/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.com.sunshineandina.dto.PerfilTO;
import pe.com.sunshineandina.dto.UsuarioTO;
import pe.com.sunshineandina.service.LoginService;
import pe.com.sunshineandina.service.PruebaService;
import pe.com.sunshineandina.util.HashPassword;

/**
 *
 * @author alonsorn
 */
@Controller
@RequestMapping("/")
public class PruebaController {
    
    @Autowired
    private PruebaService pruebaService;
    
    @Autowired
    private LoginService loginService;
    
    @RequestMapping(value = "/")
    public String index(){
       //pruebaService.prueba();
        
        
        return "general/login";
    }
    
    @RequestMapping("/prueba")
    public String prueba(){
        String hex = HashPassword.hashPassword("admin");
        
        System.out.println(hex);
        
        hex = HashPassword.hashPassword("prueba");
        System.out.println(hex);
        
        return "index";
    }
    
    @RequestMapping("/login")
    public String login(){
        UsuarioTO usuario = new UsuarioTO();
        usuario.setIdUsuario(3);
        usuario.setRegistroUsuario("prueba");
        usuario.setPassUsuario("prueba");
        List<PerfilTO> perfiles = loginService.perfilesUsuario(usuario);
        System.out.println(perfiles.size());
        for(PerfilTO perfil : perfiles){
        	System.out.println(perfil);	
        }
        return "index";
    }
}
