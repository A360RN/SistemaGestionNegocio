<%-- 
    Document   : lista_usuarios
    Created on : 01/11/2017, 07:31:50 PM
    Author     : FERNANDO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/headerAdmin.jsp" %>

<div class="container">
    <div class="titulo">
        <h1 class="text-center">Lista de Empleados</h1>
        <a href="${pageContext.request.contextPath}/admin/nuevoEmpleado" class="btn btn-warning pull-right" id="add-usuario-btn">Registrar un empleado</a>
        <div class="clearfix"></div><hr>
    </div>
    <div class="row">
        <table class="table table-sm table-hover table-bordered">
            <thead class="thead-inverse">
            <th></th>
            <th>Nombre</th>
            <th>Correo electrónico</th>
            <th>Fecha de registro</th>
            <th>Perfiles</th>
            </thead>
            <tbody>
                <c:forEach items="${lstEmpleados}" var="empleado">
                <tr>
                    <td class="text-center icon">
                        <a href="#" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-usuario" data-value="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td><c:out value="${empleado.primerNombre}"></c:out>  <c:out value="${empleado.primerApellido}"></c:out></td>
                    <td>${empleado.email}</td>
                    <td>${empleado.usuario.fechaRegistro}</td>
                    <td>
                        <c:forEach items="${empleado.usuario.perfiles}" var="perfil">
                            <c:out value="${perfil.codigoPerfil}"></c:out>
                        </c:forEach>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="modalUsuario">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <div class="centrar-texto-modal">
                    <h4 class="modal-title" id="myModalLabel">Confirmar</h4>
                </div>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p class="text-center">¿Está seguro de eliminar al usuario?</p>
            </div>
            <div class="modal-footer">
                <div class="centrar-texto-modal">
                    <button type="button" class="btn btn-danger" id="modalUsuario-btn-si">Si</button>
                    <button type="button" class="btn btn-secondary" id="modalUsuario-btn-no">No</button>
                </div>
            </div>

        </div>
    </div>
</div>

<%@ include file="../includes/footer.jsp"%>
