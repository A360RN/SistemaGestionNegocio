/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.sunshineandina.dao.CategoriaDAO;
import pe.com.sunshineandina.dto.CategoriaTO;
import pe.com.sunshineandina.service.CategoriaService;

/**
 *
 * @author FERNANDO
 */
@Service("categoriaService")
@Transactional
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    CategoriaDAO categoriaDao;
    
    @Override
    public List<CategoriaTO> findAllCategorias() {
        List<CategoriaTO> listaCategorias= categoriaDao.findAll();
        return listaCategorias;
    }

    @Override
    public CategoriaTO findCategoriaById(int id) {
        return categoriaDao.findById(id);
    }

    @Override
    public void addCategoria(CategoriaTO categoria) {
        categoriaDao.save(categoria);
    }
    
    @Override
    public void updateCategoria(CategoriaTO categoria) {
        if(categoria != null){
            CategoriaTO categoriaUpd = categoriaDao.findById(categoria.getIdCategoria());
            categoriaUpd.setNombreCategoria(categoria.getNombreCategoria());
            categoriaUpd.setDescCategoria(categoria.getDescCategoria());
            categoriaDao.save(categoriaUpd);
        }
    }
    
}
