<%-- 
    Document   : headerDistribuidor
    Created on : 24-nov-2017, 20:34:49
    Author     : alonsorn
--%>

<%@ include file="../includes/head.jsp"%>

<%@ include file="../includes/navhead.jsp"%>

<!-- Cuerpo nav -->
<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="#">Tienda</a>
    </li>
</ul>

<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="#">Mis pedidos</a>
    </li>
</ul>

<ul class="navbar-nav mr-auto">
    <li class="nav-item nav-item-section">
        <a class="nav-link" href="${pageContext.request.contextPath}/distribuidor/listaComisiones">Comisiones</a>
    </li>
</ul>

<!-- Fin cuerpo nav -->

<%@ include file="../includes/navfooter.jsp"%>
