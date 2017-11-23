/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pe.com.sunshineandina.dto.UsuarioTO;

/**
 *
 * @author FERNANDO
 */
public class ExampleInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("aca estoy " + request.getRequestURI());
        if (!request.getRequestURI().equals("/SistemaGestionNegocio/") &&
                !request.getRequestURI().equals("/SistemaGestionNegocio/login")) {
            System.out.println("dsp del uri");
            session = request.getSession();
            System.out.println((UsuarioTO)session.getAttribute("usuario"));
            if (session.getAttribute("usuario") == null) {
                System.out.println("dsp del usuario");
                response.sendRedirect("/SistemaGestionNegocio/");
                return false;
            }

        }
        return true;
    }

}
