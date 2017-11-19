/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.sunshineandina.dto.EmpleadoTO;
import pe.com.sunshineandina.dto.PerfilTO;
import pe.com.sunshineandina.dto.UsuarioTO;
import pe.com.sunshineandina.service.EmpleadoService;
import pe.com.sunshineandina.util.Constantes;

/**
 *
 * @author alonsorn
 */
@Controller
@RequestMapping("/admin")
public class AdministracionController {

    @Autowired
    private EmpleadoService empleadoService;

    @RequestMapping(value = "/listaEmpleados", method = RequestMethod.GET)
    public String listaEmpleados(Model model) {
        /* Hallamos todos los empleados OJO HAY QUE CAMBIAR POR PAGINADO*/
        List<EmpleadoTO> lstEmpleados = empleadoService.findAllEmpleados();
        model.addAttribute("lstEmpleados", lstEmpleados);
        
        return "admin/lista_empleados";
    }

    @RequestMapping(value = "/listaEmpleados", method = RequestMethod.POST)
    public String nuevoEmpleado(
            @RequestParam("ruc") String ruc,
            @RequestParam("primerNombre") String primerNombre,
            @RequestParam(value = "segundoNombre", defaultValue = "") String segundoNombre,
            @RequestParam("primerApellido") String primerApellido,
            @RequestParam("segundoApellido") String segundoApellido,
            @RequestParam("telFijo") String telefonoFijo,
            @RequestParam("telCelular") String telCelular,
            @RequestParam("email") String email,
            @RequestParam("usuario") String usuario,
            @RequestParam("password") String password,
            @RequestParam("perfiles") String[] perfiles) {
        
        /* Creamos el usuario */
        UsuarioTO usuarioEntity = new UsuarioTO();
        usuarioEntity.setRegistroUsuario(usuario);
        usuarioEntity.setPassUsuario(password);
        usuarioEntity.setEstadoUsuario(Constantes.ESTADO_ACTIVO);
        usuarioEntity.setFechaRegistro(new Date());      
        
        /* Creamos el empleado */
        EmpleadoTO empleadoEntity = new EmpleadoTO();
        empleadoEntity.setPrimerNombre(primerNombre.toUpperCase());
        empleadoEntity.setSegundoNombre(segundoNombre.toUpperCase());
        empleadoEntity.setPrimerApellido(primerApellido.toUpperCase());
        empleadoEntity.setSegundoApellido(segundoApellido.toUpperCase());
        empleadoEntity.setRuc(ruc);
        empleadoEntity.setTelefonoCelular(telCelular);
        empleadoEntity.setTelefonoFijo(telefonoFijo);
        empleadoEntity.setEmail(email.toUpperCase());
        
        empleadoEntity.setUsuario(usuarioEntity);
        /* Guardamos el nuevo empleado */
        empleadoService.addEmpleado(empleadoEntity, perfiles);

        return "redirect:/admin/listaEmpleados";
    }

    @RequestMapping(value = "/listaPoliticas", method = RequestMethod.GET)
    public String listaPoliticas() {
        return "admin/lista_politicas";
    }

    @RequestMapping(value = "/nuevoEmpleado", method = RequestMethod.GET)
    public String nuevoUsuario(Model model) {
        /* Obtenemos lista de perfiles */
        List<PerfilTO> lstPerfiles = empleadoService.findAllPerfiles();

        model.addAttribute("lstPerfiles", lstPerfiles);
        return "admin/empleado";
    }
}
