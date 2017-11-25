/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.dto.DistribuidorTO;
import pe.com.sunshineandina.dto.OfertaTO;
import pe.com.sunshineandina.dto.PedidoTO;
import pe.com.sunshineandina.service.ClienteService;
import pe.com.sunshineandina.service.OfertaService;
import pe.com.sunshineandina.service.PedidoService;


/**
 *
 * @author FERNANDO
 */
@Controller
@RequestMapping("/ventas")
public class VentasController {
    
    @Autowired
    private PedidoService pedidoService;
    
    @Autowired
    private OfertaService ofertaService;
    
    @Autowired
    private ClienteService clienteService;
    
    @RequestMapping(value = "/listaPedidos", method = RequestMethod.GET)
    public String listaPedidos(Model model){
        List<PedidoTO> listaPedidos=pedidoService.findAllPedidos();
        model.addAttribute("listaPedidos", listaPedidos);
        return "ventas/lista_pedidos";
    }
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model){
        
        return "ventas/dashboard";
    }
    
    @RequestMapping(value = "/listaClientes", method = RequestMethod.GET)
    public String listaClientes(Model model){
        List<ClienteTO> listaClientes=clienteService.findAllClientes();
        model.addAttribute("listaClientes", listaClientes);        
        return "ventas/lista_clientes";
    }
    
    @RequestMapping(value = "/listaOfertas", method = RequestMethod.GET)
    public String listaOfertas(Model model){
        List<OfertaTO> listaOfertas=ofertaService.findAllOfertas();
        model.addAttribute("listaOfertas", listaOfertas);
        return "ventas/lista_ofertas";
    }

    @RequestMapping(value = "/editarPedido", method = RequestMethod.POST)
    @ResponseBody
    public PedidoTO editarPedido(@RequestBody ObjectNode nodoJson){
        int idPedido = nodoJson.get("idPedido").asInt();
        PedidoTO pedido = pedidoService.findPedidoById(idPedido);    
        PedidoTO pedidoJson = new PedidoTO();
        pedidoJson.setEstadoPedido(pedido.getEstadoPedido());
        return pedidoJson;
    } 
    
    @RequestMapping(value = "/actualizarPedido", method = RequestMethod.POST)
    @ResponseBody
    public void actualizarPedido(
            @RequestParam("idPedido") int idPedido,
            @RequestParam("estadoPedido") String estadoPedido){
        PedidoTO pedido = new PedidoTO();
        pedido.setIdPedido(idPedido);
        pedido.setEstadoPedido(estadoPedido);
        pedidoService.actualizarPedido(pedido);
    }
    
    @RequestMapping(value = "/editarCliente", method = RequestMethod.POST)
    @ResponseBody
    public ClienteTO editarCliente(@RequestBody ObjectNode nodoJson){
        int idCliente = nodoJson.get("idCliente").asInt();
        ClienteTO cliente = clienteService.findById(idCliente);
        ClienteTO clienteJson = new ClienteTO();
        clienteJson.setIdCliente(cliente.getIdCliente());
        clienteJson.setPrimerNombre(cliente.getPrimerNombre());
        clienteJson.setPrimerApellido(cliente.getPrimerApellido());
        DistribuidorTO distribuidorJson = new DistribuidorTO();
        if(cliente.getDistribuidor()!= null){
            distribuidorJson.setIdDistribuidor(cliente.getDistribuidor().getIdDistribuidor());
        }
        clienteJson.setDistribuidor(distribuidorJson);
        return clienteJson;
    } 
    
    @RequestMapping(value = "/actualizarCliente", method = RequestMethod.POST)
    @ResponseBody
    public void actualizarCliente(
            @RequestParam("idCliente") int idCliente,
            @RequestParam("tipoCliente") String tipoCliente){
        ClienteTO cliente = new ClienteTO();
        cliente.setIdCliente(idCliente);
        clienteService.cambiarTipoCliente(cliente,tipoCliente);
    }
}
