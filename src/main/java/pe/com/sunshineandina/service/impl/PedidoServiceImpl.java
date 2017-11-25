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
import pe.com.sunshineandina.dao.ClienteDAO;
import pe.com.sunshineandina.dao.OfertaDAO;
import pe.com.sunshineandina.dao.PedidoDAO;
import pe.com.sunshineandina.dto.ClienteTO;
import pe.com.sunshineandina.dto.OfertaTO;
import pe.com.sunshineandina.dto.PedidoTO;
import pe.com.sunshineandina.service.PedidoService;

/**
 *
 * @author FERNANDO
 */
@Service("pedidoService")
@Transactional
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoDAO pedidoDao;
    
    
    @Override
    public List<PedidoTO> findAllPedidos() {
        List<PedidoTO> listaPedidos=pedidoDao.findAllPedidos();
        for(PedidoTO pedido : listaPedidos){
            Hibernate.initialize(pedido.getCliente());
        }
        return listaPedidos;
    }

    @Override
    public PedidoTO findPedidoById(int id) {
        PedidoTO pedido=pedidoDao.findById(id);
        return pedido;
    }

    @Override
    public void actualizarPedido(PedidoTO pedido) {
        if(pedido != null){
            PedidoTO pedidoUpd = pedidoDao.findById(pedido.getIdPedido());
            pedidoUpd.setEstadoPedido(pedido.getEstadoPedido());
            pedidoDao.save(pedidoUpd);
        }
    }
    
}
