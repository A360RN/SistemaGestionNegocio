/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.sunshineandina.dto.CategoriaTO;
import pe.com.sunshineandina.service.CategoriaService;

/**
 *
 * @author FERNANDO
 */
@Controller
@RequestMapping("/inventario")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @RequestMapping(value = "/listaCategorias", method = RequestMethod.GET)
    public String listaEmpleados(Model model) {
        List<CategoriaTO> listaCategorias = categoriaService.findAllCategorias();
        model.addAttribute("listaCategorias", listaCategorias);

        return "inventario/lista_categorias";
    }
    
    @RequestMapping(value = "/listaCategorias", method = RequestMethod.POST)
    public String nuevaCategoria(
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion){
        CategoriaTO categoriaNew= new CategoriaTO();
        categoriaNew.setNombreCategoria(nombre);
        categoriaNew.setDescCategoria(descripcion);
        categoriaService.addCategoria(categoriaNew);
        return "redirect:listaCategorias";
    }
}
