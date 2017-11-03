<%-- 
    Document   : lista_usuarios
    Created on : 01/11/2017, 07:31:50 PM
    Author     : FERNANDO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../includes/headerAdmin.jsp" %>

<div class="container">
    <div class="titulo">
        <h1 class="text-center">Usuarios</h1>
        <a href="usuario.jsp" class="btn btn-warning pull-right" id="add-usuario-btn">Registrar un usuario</a>
        <div class="clearfix"></div><hr>
    </div>
    <div class="row">
        <table class="table table-sm table-hover table-bordered">
            <thead class="thead-inverse">
            <th></th>
            <th>Nombre</th>
            <th>Correo electrónico</th>
            <th>Fecha de registro</th>
            <th>Permisos</th>
            </thead>
            <tbody>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                    </td>
                    <td>Luz Candelaria</td>
                    <td>cande@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>admin, editor</td>
                </tr>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-confirm" data-valueu="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td>Danielle Torres :c</td>
                    <td>danielle@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>editor</td>
                </tr>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-confirm" data-valueu="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td>Danielle Torres :c</td>
                    <td>danielle@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>admin, editor</td>
                </tr>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-confirm" data-valueu="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td>Danielle Torres :c</td>
                    <td>danielle@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>editor</td>
                </tr>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-confirm" data-valueu="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td>Danielle Torres :c</td>
                    <td>danielle@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>editor</td>
                </tr>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-confirm" data-valueu="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td>Danielle Torres :c</td>
                    <td>danielle@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>editor</td>
                </tr>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-confirm" data-valueu="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td>Danielle Torres :c</td>
                    <td>danielle@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>admin, editor</td>
                </tr>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-confirm" data-valueu="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td>Danielle Torres :c</td>
                    <td>danielle@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>editor</td>
                </tr>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-confirm" data-valueu="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td>Danielle Torres :c</td>
                    <td>danielle@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>admin, editor</td>
                </tr>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-confirm" data-valueu="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td>Danielle Torres :c</td>
                    <td>danielle@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>editor</td>
                </tr>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-confirm" data-valueu="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td>Danielle Torres :c</td>
                    <td>danielle@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>editor</td>
                </tr>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-confirm" data-valueu="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td>Danielle Torres :c</td>
                    <td>danielle@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>editor</td>
                </tr>
                <tr>
                    <td class="text-center icon">
                        <a href="usuario.jsp?edit=1" class="btn btn-sm"><span class="fa fa-pencil fa-2x"></span></a>
                        <button class="btn btn-sm btn-confirm" data-valueu="1"><span class="fa fa-times-circle fa-2x"></span></button>
                    </td>
                    <td>Danielle Torres :c</td>
                    <td>danielle@gmail.com</td>
                    <td>October 31,2017 12:04 am</td>
                    <td>editor</td>
                </tr>
            </tbody>
        </table>
    </div>

</div>

<div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="modalUsuario">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <div class="centrar-texto-modal">
                    <h4 class="modal-title" id="myModalLabel">Confirmar</h4>
                </div>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p class="text-center">¿Está seguro de eliminar al usuario?</p>
            </div>
            <div class="modal-footer">
                <div class="centrar-texto-modal">
                    <button type="button" class="btn btn-danger" id="modalUsuario-btn-si">Si</button>
                    <button type="button" class="btn btn-secondary" id="modalUsuario-btn-no">No</button>
                </div>
            </div>

        </div>
    </div>
</div>

<%@ include file="../includes/footer.html"%>
