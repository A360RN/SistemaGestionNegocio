<%-- 
    Document   : oferta
    Created on : 03/11/2017, 02:17:07 PM
    Author     : FERNANDO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerVentas.jsp" %>

<div class="container">
    <h1 class="text-center">Registrar una oferta</h1>
    <hr>
    <form class="" action="" method="post" enctype="multipart/form-data">
        <div class="form-group pull-right">
            <input type="submit" class="form-control btn btn-warning pull-right" value="Registrar">
        </div><div class="clearfix"></div>
        <div class="form-group pull-right">
            <a href="lista_ofertas.jsp" class="form-control btn btn-secondary">Cancelar</a>
        </div><div class="clearfix"></div>
    </form>
</div>

<%@ include file="../includes/footer.jsp"%>