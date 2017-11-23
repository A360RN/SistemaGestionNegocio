/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.sunshineandina.dto.PedidoTO;
import pe.com.sunshineandina.service.VentasService;


/**
 *
 * @author FERNANDO
 */
@Controller
@RequestMapping("/ventas")
public class VentasController {
    
    @Autowired
    private VentasService ventasService;
    
    @RequestMapping(value = "/listaPedidos", method = RequestMethod.GET)
    public String listaPedidos(Model model){
        List<PedidoTO> listaPedidos=ventasService.findAllVentas();
        model.addAttribute("listaPedidos", listaPedidos);
        return "ventas/lista_pedidos";
    }
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model){
        
        return "ventas/dashboard";
    }
    
    @RequestMapping(value = "/listaClientes", method = RequestMethod.GET)
    public String listaClientes(Model model){
        
        return "ventas/lista_clientes";
    }
    
    @RequestMapping(value = "/listaOfertas", method = RequestMethod.GET)
    public String listaOfertas(Model model){
        
        return "ventas/lista_ofertas";
    }
    
            
}
