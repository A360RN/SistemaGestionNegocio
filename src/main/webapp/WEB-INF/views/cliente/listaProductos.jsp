<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

        <%@include file="../includes/headerCliente.jsp" %>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <form action="" class="form-inline">
                            <label class="mr-sm-2" for="selectCategoria">Categoría</label>
                            <select class="custom-select mb-2 mr-sm-2 mb-sm-0" id="selectCategoria">
                                <option value="1">Categoría 1</option>
                                <option value="2">Categoría 2</option>
                                <option value="3">Categoría 3</option>
                            </select>
                            <button type="submit" class="btn btn-warning">Buscar</button>
                        </form>
                        <div class="row text-center">
                            <div class="col-sm-6 col-md-3">
                                <img src="http://pe.sunshineandina.com/media/catalog/product/cache/3/small_image/9df78eab33525d08d6e5fb8d27136e95/c/a/carbo-grabbers-peru-noviembre2017.png"
                                    class="img-fluid">
                                <h4>Producto</h4>
                                <div class="text-muted">Precio: S/.100</div>
                                <button class="btn btn-warning">Agregar al carrito</button>
                                <button class="btn btn-secondary">Más Info...</button>
                            </div>
                            <div class="col-sm-6 col-md-3">
                                <img src="http://pe.sunshineandina.com/media/catalog/product/cache/3/small_image/9df78eab33525d08d6e5fb8d27136e95/c/a/carbo-grabbers-peru-noviembre2017.png"
                                    class="img-fluid">
                                <h4>Producto</h4>
                                <div class="text-muted">Precio: S/.100</div>
                                <button class="btn btn-warning">Agregar al carrito</button>
                                <button class="btn btn-secondary">Más Info...</button>
                            </div>
                            <div class="col-sm-6 col-md-3">
                                <img src="http://pe.sunshineandina.com/media/catalog/product/cache/3/small_image/9df78eab33525d08d6e5fb8d27136e95/c/a/carbo-grabbers-peru-noviembre2017.png"
                                    class="img-fluid">
                                <h4>Producto</h4>
                                <div class="text-muted">Precio: S/.100</div>
                                <button class="btn btn-warning">Agregar al carrito</button>
                                <button class="btn btn-secondary">Más Info...</button>
                            </div>
                            <div class="col-sm-6 col-md-3">
                                <img src="http://pe.sunshineandina.com/media/catalog/product/cache/3/small_image/9df78eab33525d08d6e5fb8d27136e95/c/a/carbo-grabbers-peru-noviembre2017.png"
                                    class="img-fluid">
                                <h4>Producto</h4>
                                <div class="text-muted">Precio: S/.100</div>
                                <button class="btn btn-warning">Agregar al carrito</button>
                                <button class="btn btn-secondary">Más Info...</button>
                            </div>
                        </div>
                        <br>
                        <nav aria-label="pagination">
                            <ul class="pagination justify-content-center">
                                <li class="page-item">
                                    <a class="page-link" href="#">Previous</a>
                                </li>
                                <li class="page-item">
                                    <a class="page-link" href="#">1</a>
                                </li>
                                <li class="page-item">
                                    <a class="page-link" href="#">2</a>
                                </li>
                                <li class="page-item">
                                    <a class="page-link" href="#">3</a>
                                </li>
                                <li class="page-item">
                                    <a class="page-link" href="#">4</a>
                                </li>
                                <li class="page-item">
                                    <a class="page-link" href="#">5</a>
                                </li>
                                <li class="page-item">
                                    <a class="page-link" href="#">Next</a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>

            <%@ include file="../includes/footer.jsp"%>