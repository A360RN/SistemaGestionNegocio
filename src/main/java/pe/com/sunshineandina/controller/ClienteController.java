/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import com.fasterxml.jackson.databind.JsonNode;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.sunshineandina.dto.CarritoTO;
import pe.com.sunshineandina.dto.UsuarioTO;
import pe.com.sunshineandina.mapper.ResponseMapper;
import pe.com.sunshineandina.service.CarritoService;
import pe.com.sunshineandina.service.PedidoService;

/**
 *
 * @author alonsorn
 */
@Controller
public class ClienteController {
    
    @Autowired
    private CarritoService carritoService;
    
    @Autowired
    private PedidoService pedidoService;
    
    @RequestMapping(value = "/carrito/detalle", method = RequestMethod.GET)
    public String obtenerCarrito(HttpSession session, Model model){
        
        /* Hallamos el usuario logeado */
        UsuarioTO usuario = (UsuarioTO) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();
        
        /* Carrito actual del usuario cliente o distribuidor */
        CarritoTO carrito = carritoService.findByUsuario(idUsuario);
        
        model.addAttribute("carrito", carrito);
        
        return "cliente/carrito";
        
    }
    
    @RequestMapping(value = "/pedido", method = RequestMethod.POST)
    @ResponseBody
    public JsonNode nuevoPedido(HttpSession session){
        /* Hallamos el usuario logeado */
        UsuarioTO usuario = (UsuarioTO) session.getAttribute("usuario");
        int idUsuario = usuario.getIdUsuario();
        
        /* Creamos el pedido */
        String rpta = pedidoService.nuevoPedido(idUsuario);
        JsonNode jsonRespuesta = ResponseMapper.nuevoPedidoMapper(rpta);
        
        return jsonRespuesta;
    }
}
