<%-- 
    Document   : usuario
    Created on : 01/11/2017, 07:31:50 PM
    Author     : FERNANDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="../includes/head.html"%>

<%@ include file="../includes/navhead.html"%>

<!-- Cuerpo nav -->
<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="lista_usuarios.jsp">Usuarios</a>
    </li>
</ul>
<ul class="navbar-nav mr-auto">
    <li class="linea"></li>
</ul>
<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="lista_politicas.jsp">Políticas de negocio</a>
    </li>
</ul>
<ul class="navbar-nav mr-auto">
    <li class="linea"></li>
</ul>
<!-- Fin cuerpo nav -->

<%@ include file="../includes/navfooter.html"%>

<div class="container">
    <h1 class="text-center">Agregar un usuario</h1>
    <hr>
    <form class="" action="" method="post" enctype="multipart/form-data">
        <div class="row">
            <div class="form-group col-md-6">
                <label for="">Nombre:</label>
                <input type="text" class="form-control" name="nombre" id="nombre" value="">
            </div>
            <div class="form-group col-md-6">
                <label for="">Correo electrónico:</label>
                <input type="text" class="form-control" name="correo" id="correo" value="">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label for="">Permisos:</label>
                <select class="form-control" name="permisos" id="permisos">
                    <option value="" selected></option>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="">Contraseña:</label>
                <input type="text" class="form-control" name="contrasena" id="contrasena" value="">
            </div>
        </div>
        <div class="form-group pull-right">
            <input type="submit" class="form-control btn btn-warning pull-right" value="Agregar">
        </div><div class="clearfix"></div>
        <div class="form-group pull-right">
            <a href="lista_usuarios.jsp" class="form-control btn btn-secondary">Cancelar</a>
        </div><div class="clearfix"></div>
    </form>

</div>

<%@ include file="../includes/footer.html"%>