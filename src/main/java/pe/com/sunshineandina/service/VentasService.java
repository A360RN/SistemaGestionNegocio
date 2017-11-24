/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.dto.OfertaTO;
import pe.com.sunshineandina.dto.PedidoTO;

/**
 *
 * @author FERNANDO
 */
public interface VentasService {
    List<PedidoTO> findAllPedidos();
    
    PedidoTO findPedidoById(int id);
    
    List<ClienteTO> findAllClientes();
    
    List<OfertaTO> findAllOfertas();
}
