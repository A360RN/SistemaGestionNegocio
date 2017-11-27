/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.com.sunshineandina.dto.CarritoTO;
import pe.com.sunshineandina.dto.UsuarioTO;
import pe.com.sunshineandina.service.CarritoService;

/**
 *
 * @author alonsorn
 */
@Controller
@RequestMapping("/carrito")
public class ClienteController {
    
    @Autowired
    private CarritoService carritoService;
    
    @RequestMapping(value = "/detalle", method = RequestMethod.GET)
    public String obtenerCarrito(HttpSession session, Model model){
        
        /* Hallamos el usuario logeado */
        UsuarioTO usuario = (UsuarioTO) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();
        
        /* Carrito actual del usuario cliente o distribuidor */
        CarritoTO carrito = carritoService.findByUsuario(idUsuario);
        
        model.addAttribute("carrito", carrito);
        
        return "cliente/carrito";
        
    }
}
