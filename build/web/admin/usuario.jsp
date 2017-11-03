<%-- 
    Document   : usuario
    Created on : 01/11/2017, 07:31:50 PM
    Author     : FERNANDO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerAdmin.jsp" %>

<div class="container">
    <h1 class="text-center">Registrar un usuario</h1>
    <hr>
    <form class="" action="" method="post" enctype="multipart/form-data">
        <div class="row">
            <div class="form-group col-md-6">
                <label for="nombre">Nombre:</label>
                <input type="text" class="form-control" name="nombre" id="nombre" value="">
            </div>
            <div class="form-group col-md-6">
                <label for="correo">Correo electrónico:</label>
                <input type="text" class="form-control" name="correo" id="correo" value="">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label for="permisos">Permisos:</label>
                <select class="form-control" name="permisos" id="permisos">
                    <option value="" selected></option>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="contrasena">Contraseña:</label>
                <input type="text" class="form-control" name="contrasena" id="contrasena" value="">
            </div>
        </div>
        <div class="form-group pull-right">
            <input type="submit" class="form-control btn btn-warning pull-right" value="Registrar">
        </div><div class="clearfix"></div>
        <div class="form-group pull-right">
            <a href="lista_usuarios.jsp" class="form-control btn btn-secondary">Cancelar</a>
        </div><div class="clearfix"></div>
    </form>

</div>

<%@ include file="../includes/footer.html"%>