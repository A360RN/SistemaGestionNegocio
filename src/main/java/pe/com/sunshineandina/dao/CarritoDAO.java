/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.dao;

import java.util.Date;
import java.util.List;
import pe.com.sunshineandina.dto.CarritoTO;

/**
 *
 * @author alonsorn
 */
public interface CarritoDAO {
    
    CarritoTO findById(int id);
    
    void save(CarritoTO carrito);
    
    void destroy(CarritoTO carrito);
    
    List<CarritoTO> findByCliente(int idCliente);
    
    List<CarritoTO> findByClienteFecha(int idCliente, Date fechaInicio, Date fechaFin);
    
    List<CarritoTO> findByClienteFechaPaginado(int idCliente, Date fechaInicio, Date fechaFin, int inicio, int cantidadPagina);
}
