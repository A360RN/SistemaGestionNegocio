/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var btnEditarClienteSi = $('#modalEditarCliente-btn-si');
var btnEditarClienteNo = $('#modalEditarCliente-btn-no');
var modalEditarCliente = $('#modalEditarCliente');

var btnEditaPedidoSi = $('#modalEditarPedido-btn-si');
var btnEditarPedidoNo = $('#modalEditarPedido-btn-no');
var modalEditarPedido = $('#modalEditarPedido');

modalEditarCliente.on('show.bs.modal', function (e) {
    let button = $(e.relatedTarget);
    let idCliente = button.data('idcliente');
    let modal = $(this);
    let data = {
        idCliente: idCliente
    };

    $.ajax({
        method: 'POST',
        url: 'editarCliente',
        data: data
    }).done(function(response) {
        
    });
});

modalEditarPedido.on('show.bs.modal', function (e) {
    let button = $(e.relatedTarget);
    let idPedido = button.data('idpedido');
    let modal = $(this);
    let data = {
        idPedido: idPedido
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        url: 'editarPedido',
        data: JSON.stringify(data)
    }).done(function(response) {
        
    });
});
