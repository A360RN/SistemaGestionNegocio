/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.util;

/**
 *
 * @author alonsorn
 */
public class Constantes {
    
    // CONSTANTES DE BASE DE DATOS
    public static final int ESTADO_ACTIVO = 1;
    public static final int ESTADO_INACTIVO = 0;
    
    public static final String PERFIL_ENCARGADO_VENTAS = "VEN";
    public static final String PERFIL_ENCARGADO_ADM = "ADM";
    public static final String PERFIL_ENCARGADO_INV = "INV";
    public static final String PERFIL_CLIENTE = "CLI";
    public static final String PERFIL_DISTRIBUIDOR = "DIS";
    public static final int TIPO_LIDER_DEFECTO=1;
    
    public static final int INICIO_PRODUCTOS_POR_PAGINA_POR_DEFECTO = 0;
    
    public static final String PARAMETRIA_PRODUCTOS_POR_PAGINA = "PRODUCTOS_POR_PAGINA";
    
    //**************************** MENSAJES ERROR *************************
    public static final String ERROR_AUTENTICACION_USERNAME = "Este usuario no existe";
    public static final String ERROR_AUTENTICACION_PASSWORD = "Contrase�a errada";

    public static final String ERROR_CONTRASE�AS_NO_COINCIDEN = "Las contrase�as no coinciden"; 
    
    public static final String ERROR_CATEGORIA_REPETIDA="La categoria ingresada ya existe";
    
    public static final String ERROR_NO_SE_ENCONTRO_CLIENTE = "No se encontro al cliente";
    public static final String ERROR_STOCK_INSUFICIENTE = "La cantidad excede al stock del producto";
    public static final String ERROR_STOCK_AGOTADO = "Lo sentimos, el stock del producto se ha agotado";
    
    /**************************** MENSAJES DE EXITO ****************************/
    public static final String PRODUCTO_CARRITO_EXITO = "Se agreg� el producto al carrito";
}
