/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service;

import java.util.List;
import pe.com.sunshineandina.dto.PedidoTO;

/**
 *
 * @author FERNANDO
 */
public interface VentasService {
    List<PedidoTO> findAllVentas();
    
    PedidoTO findVentasById(int id);
}
