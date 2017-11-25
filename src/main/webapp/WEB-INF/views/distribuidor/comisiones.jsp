
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@include file="../includes/headerDistribuidor.jsp" %>

<div class="container">
    <input type="hidden" id="idDistribuidor" value="${distribuidor.idDistribuidor}">
    <div class="row">
        <div class="col-12">
            <h1>Comisión de: Nombre Apellido</h1>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <canvas id="cuadroComisiones"></canvas>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/lib/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/lib/js/comisiones.js"></script>

<%@ include file="../includes/footer.jsp"%>
