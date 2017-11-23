/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.PedidoDAO;
import pe.com.sunshineandina.dto.PedidoTO;
import pe.com.sunshineandina.service.VentasService;

/**
 *
 * @author FERNANDO
 */
@Service("ventasService")
@Transactional
public class VentasServiceImpl implements VentasService {

    @Autowired
    PedidoDAO pedidoDao;
    
    @Override
    public List<PedidoTO> findAllVentas() {
        List<PedidoTO> listaPedidos=pedidoDao.findAllPedidos();
        for(PedidoTO pedido : listaPedidos){
            Hibernate.initialize(pedido.getCliente());
        }
        return listaPedidos;
    }

    @Override
    public PedidoTO findVentasById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
