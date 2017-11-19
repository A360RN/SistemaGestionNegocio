<%-- 
    Document   : lista_politicas
    Created on : 02/11/2017, 01:39:50 AM
    Author     : FERNANDO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerAdmin.jsp" %>

<div class="container">
    <div class="titulo">
        <h1 class="text-center">Lista de Políticas de Negocio</h1>
        <hr>
    </div>
    <div class="row">
        <table class="table table-sm table-hover table-bordered">
            <thead class="thead-inverse">
            <th></th>
            <th>Política</th>
            <th>Puntos mínimos</th>
            <th>Puntos máximo</th>
            <th>Porcentaje de descuento</th>
            </thead>
            <tbody>
                <c:forEach items="${lstPoliticas}" var="politica">
                <tr>
                    <td class="text-center icon">
                        <a href="#" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                    </td>
                    <td>${politica.descPolitica}</td>
                    <td>${politica.minPuntos}</td>
                    <td>${politica.maxPuntos}</td>
                    <td>${politica.porcentajeDescuento}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<%@ include file="../includes/footer.jsp"%>
