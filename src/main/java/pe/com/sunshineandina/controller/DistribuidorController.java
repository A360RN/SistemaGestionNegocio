/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.sunshineandina.dto.DistribuidorTO;
import pe.com.sunshineandina.dto.UsuarioTO;
import pe.com.sunshineandina.service.DistribuidorService;

/**
 *
 * @author alonsorn
 */
@Controller
@RequestMapping("/distribuidor")
public class DistribuidorController {
    
    @Autowired
    private DistribuidorService distribuidorService;
    
    @RequestMapping(value = "/listaComisiones", method = RequestMethod.GET)
    public String listaComisiones(HttpSession session, Model model){
        UsuarioTO usuario = (UsuarioTO) session.getAttribute("usuario");
        /* Hallamos el distribuidor logeado */
        DistribuidorTO distribuidorActual = distribuidorService.findByUsuario(usuario.getIdUsuario());
        
        model.addAttribute("distribuidor", distribuidorActual);
        return "distribuidor/comisiones";
    }
    
    @RequestMapping(value = "/obtenerComisiones", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode obtenerComisiones(@RequestBody ObjectNode nodoJson){
        return null;
    }
    
    @RequestMapping(value = "/listaPedidos", method = RequestMethod.GET)
    public String listaPedidos(){
        /* ACA DEBE DIRECCIONAR A LO DE PEDIDOS EN CLIENTE */
        return null;
    }
    
    @RequestMapping(value = "/tienda", method = RequestMethod.GET)
    public String listaProductos(){
        /* ACA DEBE DIRECCIONAR A LO DE LA TIENDA EN CLIENTE */
        return null;
    }
}