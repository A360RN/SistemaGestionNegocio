<%-- 
    Document   : producto
    Created on : 01/11/2017, 07:31:50 PM
    Author     : FERNANDO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ include file="../includes/head.html"%>

<%@ include file="../includes/navhead.html"%>

<!-- Cuerpo nav -->
<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="lista_productos.jsp">Productos</a>
    </li>
</ul>
<ul class="navbar-nav mr-auto">
    <li class="linea"></li>
</ul>
<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="lista_categorias.jsp">Categorías</a>
    </li>
</ul>
<ul class="navbar-nav mr-auto">
    <li class="linea"></li>
</ul>
<!-- Fin cuerpo nav -->

<%@ include file="../includes/navfooter.html"%>

<div class="container">
    <h1 class="text-center">Agregar un producto</h1>
    <hr>
    <form class="" action="" method="post" enctype="multipart/form-data">
        <div class="row">
            <div class="form-group col-md-4">
                <label for="title">Nombre*:</label>
                <input type="text" name="title" class="form-control" id="title" value="">
            </div>
            <div class="form-group col-md-4">
                <label for="brand">Categoría*:</label>
                <select class="form-control" id="brand" name="brand">
                    <option value=""  selected></option>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label for="price">Precio*:</label>
                <input type="text" name="price" id="price" class="form-control" value="">
            </div>
            <div class="form-group col-md-2">
                <label for="list_price">Cantidad*:</label>
                <input type="text" name="list_price" id="list_price" class="form-control" value="">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-6">
                <label for="photo">Imagen del producto:</label>
                <!-- fallé :v -->
                <input type="file" name="photo" class="form-control" id="photo">
            </div>
            <div class="form-group col-md-6">
                <label for="description">Descripción:</label>
                <textarea name="description" id="description" class="form-control" rows="6"></textarea>
            </div>
        </div>
        <div class="form-group pull-right">
            <input type="submit" class="form-control btn btn-warning pull-right" value="Agregar">
        </div><div class="clearfix"></div>
        <div class="form-group pull-right">
            <a href="lista_productos.jsp" class="form-control btn btn-secondary">Cancelar</a>
        </div><div class="clearfix"></div>
    </form>

</div>

<%@ include file="../includes/footer.html"%>