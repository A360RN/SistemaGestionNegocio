<%-- 
    Document   : producto
    Created on : 01/11/2017, 07:31:50 PM
    Author     : FERNANDO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerInventario.jsp"%>

<div class="container">
    <h1 class="text-center">Registrar un producto</h1>
    <hr>
    <form action="listaProductos" method="POST">
        <div class="row">
            <div class="form-group col-md-3">
                <label for="nombre">Nombre*:</label>
                <input class="form-control" type="text" id="nombre" name="nombre">
            </div>
            <div class="form-group col-md-3">
                <label for="categoria">Categoría*:</label>
                <select class="form-control" id="categoria" name="categoria">
                    <option value="" selected="" disabled="">Seleccione una opción</option>
                    <c:forEach items="${listaCategorias}" var="cat">
                        <option value="${cat.idCategoria}">${cat.nombreCategoria}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label for="precio">Precio*:</label>
                <input type="text" name="precio" id="precio" class="form-control" value="">
            </div>
            <div class="form-group col-md-2">
                <label for="puntos">Puntos*:</label>
                <input type="text" name="puntos" id="puntos" class="form-control" value="">
            </div>
            <div class="form-group col-md-2">
                <label for="cantidad">Cantidad*:</label>
                <input type="text" name="cantidad" id="cantidad" class="form-control" value="">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label for="imagen">Imagen del producto:</label>
                <!-- fallé :v -->
                <input type="file" name="imagen" class="form-control" id="imagen">
            </div>
            <div class="form-group col-md-6">
                <label for="descripcion">Descripción:</label>
                <textarea name="descripcion" id="descripcion" class="form-control" rows="6"></textarea>
            </div>
        </div>
        <div class="form-group pull-right">
            <input type="submit" class="form-control btn btn-warning pull-right" value="Registrar">
        </div><div class="clearfix"></div>
        <div class="form-group pull-right">
            <a href="${pageContext.request.contextPath}/inventario/listaProductos" class="form-control btn btn-secondary">Cancelar</a>
        </div><div class="clearfix"></div>
    </form>

</div>

<%@ include file="../includes/footer.jsp"%>