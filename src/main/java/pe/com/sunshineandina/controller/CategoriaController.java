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
import pe.com.sunshineandina.dto.CategoriaTO;
import pe.com.sunshineandina.service.CategoriaService;
import pe.com.sunshineandina.util.Constantes;

/**
 *
 * @author FERNANDO
 */
@Controller
@RequestMapping("/inventario")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @RequestMapping(value = "/listaCategorias",  method = RequestMethod.GET)
    public String listaCategorias(@RequestParam(value="edit", required=false) Object id ,Model model) {
        List<CategoriaTO> listaCategorias = categoriaService.findAllCategorias();
        model.addAttribute("listaCategorias", listaCategorias);
        //Cuando dé click en editar
        if(id!=null)
        {
            int idCategoria=Integer.parseInt((String) id) ;
            CategoriaTO categoria=categoriaService.findCategoriaById(idCategoria);
            System.out.println(categoria.getDescCategoria());
            model.addAttribute("categoria",categoria);
            model.addAttribute("swEditar",1);
            
        }
        return "inventario/lista_categorias";
    }
    
    @RequestMapping(value = "/categoria", method = RequestMethod.POST)
    public String addOrEditCategoria(
            @RequestParam("id") int id,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            Model model){
        CategoriaTO categoriaNew= new CategoriaTO();
        categoriaNew.setNombreCategoria(nombre);
        categoriaNew.setDescCategoria(descripcion);
        //Hidden agregar
        if(id==0)
        {
            categoriaService.addCategoria(categoriaNew);
        }
        //Hidden editar con id
        else{
            categoriaNew.setIdCategoria(id);
            categoriaService.updateCategoria(categoriaNew);
        }
        
        return "redirect:listaCategorias";
    }
}
