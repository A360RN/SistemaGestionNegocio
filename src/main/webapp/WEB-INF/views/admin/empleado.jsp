<%-- 
    Document   : usuario
    Created on : 01/11/2017, 07:31:50 PM
    Author     : FERNANDO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/headerAdmin.jsp" %>

<div class="container">
    <h1 class="text-center">Registrar un empleado</h1>
    <hr>
    <div class="row">
        <div class="col-6 offset-3">
            <form action="listaEmpleados" method="POST">
                <div class="row">
                    <div class="form-group col-6">
                        <label for="usuario">Usuario: </label>
                        <input type="text" class="form-control" name="usuario" id="usuario">
                    </div>
                    <div class="form-group col-6">
                        <label for="password">Contraseña: </label>
                        <input type="password" class="form-control" name="password" id="password">
                    </div>
                </div>
                <div class="row">
                    <fieldset class="form-group col-12">
                        <legend>Perfiles</legend>
                        <c:forEach items="${lstPerfiles}" var="perfil">
                        <div class="form-check">
                            <label class="form-check-label">
                                <input type="checkbox" name="perfiles" value="${perfil.codigoPerfil}">
                                <c:out value="${perfil.descPerfil}"></c:out>
                            </label>
                        </div>
                        </c:forEach>
                    </fieldset>
                </div>
                <div class="row">
                    <div class="form-group col-12">
                        <label for="ruc">RUC:</label>
                        <input type="text" class="form-control" name="ruc" id="ruc">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="primerNombre">Primer Nombre:</label>
                        <input type="text" class="form-control" name="primerNombre" id="primerNombre">
                    </div>
                    <div class="form-group col-6">
                        <label for="segundoNombre">Segundo Nombre:</label>
                        <input type="text" class="form-control" name="segundoNombre" id="segundoNombre">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="primerApellido">Primer Apellido:</label>
                        <input type="text" class="form-control" name="primerApellido" id="primerApellido">
                    </div>
                    <div class="form-group col-6">
                            <label for="segundoApellido">Segundo Apellido:</label>
                            <input type="text" class="form-control" name="segundoApellido" id="segundoApellido">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-6">
                        <label for="telFijo">Teléfono Fijo:</label>
                        <input type="text" class="form-control" name="telFijo" id="telFijo">
                    </div>
                    <div class="form-group col-6">
                        <label for="telCelular">Teléfono Celular:</label>
                        <input type="text" class="form-control" name="telCelular" id="telCelular">  
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-12">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" name="email" id="email">
                    </div>
                </div>
                <div class="form-group pull-right">
                    <input type="submit" class="form-control btn btn-warning pull-right" value="Registrar">
                </div><div class="clearfix"></div>
                <div class="form-group pull-right">
                    <a href="${pageContext.request.contextPath}/admin/listaEmpleados" class="form-control btn btn-secondary">Cancelar</a>
                </div><div class="clearfix"></div>
            </form>
        </div>
    </div>
</div>

<%@ include file="../includes/footer.jsp"%>