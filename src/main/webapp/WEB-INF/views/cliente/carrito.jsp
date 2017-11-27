<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/headerCliente.jsp" %>

<div class="container-fluid">
    <div class="row">
        <c:if test="${carrito != null}">
        <div class="offset-md-2 col-md-5 col-sm-6">
            <table class="table table-responsive table-bordered table-hover">
                <thead class="thead-inverse">
                    <tr>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th>Subtotal</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${carrito.detalleCarritos}" var="detalle">
                    <tr>
                        <td><c:out value="${detalle.producto.nombreProducto}"></c:out></td>
                        <td><c:out value="${detalle.cantidad}"></c:out></td>
                        <td>S/. <c:out value="${detalle.precioDetalleCarrito}"></c:out></td>
                        <td>
                            <button class="btn btn-sm">
                                <span class="fa fa-pencil"></span>
                            </button>
                            <button class="btn btn-sm">
                                <span class="fa fa-trash-o"></span>
                            </button>
                        </td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-md-5 col-sm-6">
            <div class="card text-center pull-left">
                <div class="card-block">
                  <h4 class="card-title">Carrito de Compras</h4>
                  <p class="card-text">El total a pagar es: S/.<c:out value="${carrito.precioAcumuladoCarrito}"></c:out></p>
                  <button class="btn btn-warning" id="btnRegistrarPedido">Registrar el pedido</button>
                </div>
            </div>
        </div>
        </c:if>
    </div>
</div>


<%@ include file="../includes/footer.jsp"%>