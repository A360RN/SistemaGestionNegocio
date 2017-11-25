/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.com.sunshineandina.dto.CategoriaTO;
import pe.com.sunshineandina.dto.ProductoTO;
import pe.com.sunshineandina.service.CategoriaService;
import pe.com.sunshineandina.service.ProductoService;

/**
 *
 * @author FERNANDO
 */
@Controller
@RequestMapping("/inventario")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @RequestMapping(value = "/listaProductos", method = RequestMethod.GET)
    public String listaProductos(Model model){
        List<ProductoTO> listaProductos=productoService.findAllProductosInventario();
        model.addAttribute("listaProductos", listaProductos);
        return "inventario/lista_productos";
    }
    
    @RequestMapping(value="/listaProductos", method=RequestMethod.POST)
    public String addOrEditProducto(
            @RequestParam("id") int id,
            @RequestParam("categoria") int categoria,
            @RequestParam("nombre") String nombre,
            @RequestParam("descripcion") String descripcion,
            @RequestParam("precio") BigDecimal precio,
            @RequestParam("cantidad") int cantidad,
            @RequestParam("puntos") int puntos,
            Model model){
        CategoriaTO categoriaFind;
        categoriaFind=categoriaService.findCategoriaById(categoria);
        ProductoTO productoNew=new ProductoTO();
        productoNew.setCategoria(categoriaFind);
        productoNew.setNombreProducto(nombre);
        productoNew.setPrecioProducto(precio);
        productoNew.setStockProducto(cantidad);
        productoNew.setPuntosProducto(puntos);
        productoNew.setEstadoProducto(1);
        productoNew.setDescripcionProducto(descripcion);
        //Hidden agregar
        if(id==0)
        {
            productoService.addProducto(productoNew);
        }
        //Hidden editar con id
        else{
            productoNew.setIdProducto(id);
            productoService.editProducto(productoNew);
        }
        
        return "redirect:/inventario/listaProductos";
    }
    
    @RequestMapping(value = "/nuevoProducto", method = RequestMethod.GET)
    public String listarCategorias(@RequestParam(value="edit", required=false) Object id, Model model){
        List<CategoriaTO> listaCategorias = categoriaService.findAllCategorias();
        model.addAttribute("listaCategorias", listaCategorias);
        //Cuando dé click en editar
        if(id!=null)
        {
            int idProducto=Integer.parseInt((String) id) ;
            ProductoTO producto=productoService.findProductoById(idProducto);
            model.addAttribute("producto",producto);
            model.addAttribute("swEditar",1);
        }
        return "inventario/producto";
    }
    
    @RequestMapping(value = "/cambiarEstadoProducto", method = RequestMethod.POST)
    @ResponseBody
    public void cambiarEstado(@RequestParam("idProducto") int idProducto)
    {
        ProductoTO producto=productoService.findProductoById(idProducto);
        productoService.changeProductState(producto);
    }
}