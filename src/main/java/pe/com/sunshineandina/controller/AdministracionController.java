/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author alonsorn
 */
@Controller
@RequestMapping("/admin")
public class AdministracionController {
    
    @RequestMapping(value = "/listaUsuarios", method = RequestMethod.GET)
    public String listaUsuarios(){
        return "admin/lista_usuarios";
    }
    
    @RequestMapping(value = "/listaPoliticas", method = RequestMethod.GET)
    public String listaPoliticas(){
        return "admin/lista_politicas";
    }
}
