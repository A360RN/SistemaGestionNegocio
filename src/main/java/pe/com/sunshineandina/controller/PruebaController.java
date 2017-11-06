/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    @RequestMapping(value = "/")
    public String index(){
       //pruebaService.prueba();
        
        
        return "index";
    }
    
    @RequestMapping("/prueba")
    public String prueba(){
        String hex = HashPassword.hashPassword("qwer0086");
        
        System.out.println(hex);
        
        return "index";
    }
}
