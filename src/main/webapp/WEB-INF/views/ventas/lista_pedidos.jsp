<%-- 
    Document   : lista_ventas
    Created on : 03/11/2017, 12:55:43 PM
    Author     : FERNANDO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerVentas.jsp" %>

<div class="container">
    <div class="titulo">
        <h1 class="text-center">Pedidos</h1>
        <a href="pedido.jsp" class="btn btn-warning pull-right" id="add-pedido-btn">Registrar un pedido</a>
        <div class="clearfix"></div><hr>
    </div>
    <div class="row">
        <table class="table table-sm table-hover table-bordered">
            <thead class="thead-inverse">
            <th></th>
            <th>Nº de pedido</th>
            <th>Cliente</th>
            <th>Importe total</th>
            <th>Fecha de registro</th>
            <th>Estado</th>
            </thead>
            <tbody>
                <c:forEach items="${listaPedidos}" var="pedido">
                <tr>
                    <td class="text-center icon">
                        <a href="pedido.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                    </td>
                    <td>${pedido.idPedido}</td>
                    <td><c:out value="${pedido.cliente.primerNombre}"></c:out> <c:out value="${pedido.cliente.primerApellido}"></c:out></td>
                    <td>${pedido.precioAcumuladoPedido}</td>
                    <td>${pedido.fechaCreacion}</td>
                    <td>${pedido.estadoPedido}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<%@ include file="../includes/footer.jsp"%>
