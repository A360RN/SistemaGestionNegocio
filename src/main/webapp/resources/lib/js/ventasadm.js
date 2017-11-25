/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var estados = ["Ordenado", "Pagado", "Cancelado"];
var tipos = ["Distribuidor","Normal"];
var btnEditarClienteSi = $('#modalEditarCliente-btn-si');
var btnEditarClienteNo = $('#modalEditarCliente-btn-no');
var modalEditarCliente = $('#modalEditarCliente');
var btnEditarPedidoSi = $('#modalEditarPedido-btn-si');
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
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        url: 'editarCliente',
        data: JSON.stringify(data)
    }).done(function(response) {
        let tipoCliente=existe(response.distribuidor.idDistribuidor);
        modal.find('.modal-title').text(response.primerNombre+" "+response.primerApellido);
        modal.find('.modal-body input[type="hidden"]').val(idCliente);
        modal.find('.modal-body select#txtCliente').html(mostrarTipos(tipoCliente,tipos));
    });
});

function existe(distribuidor)
{
    if(distribuidor)
        cadena="Distribuidor";
    else
        cadena="Normal";
    return cadena;
};

btnEditarClienteSi.on('click', function (e) {
    e.preventDefault();

    let idCliente = modalEditarCliente.find('.modal-body input[type="hidden"]').val();
    let tipoCliente = modalEditarCliente.find('.modal-body select#txtCliente').val();

    let data = {
        idCliente: idCliente,
        tipoCliente: tipoCliente
    };

    $.ajax({
        method: 'POST',
        url: 'actualizarCliente',
        data: data
    }).done(function(response){
        modalEditarCliente.modal('hide');
        window.location.href='listaClientes';
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
        modal.find('.modal-title').text("Pedido: "+idPedido);
        modal.find('.modal-body input[type="hidden"]').val(idPedido);
        modal.find('.modal-body select#txtPedido').html(mostrarTipos(response.estadoPedido,estados));
    });
});

function mostrarTipos(estadoPedido,arreglo){
    let cadena="";
    for(var estado of arreglo){
        if(estado===estadoPedido)
            cadena+="<option selected value='"+estado+"'>"+estado+"</option>";
        else
            cadena+="<option value='"+estado+"'>"+estado+"</option>";  
    }
    return cadena;
}

btnEditarPedidoSi.on('click', function (e) {
    e.preventDefault();

    let idPedido = modalEditarPedido.find('.modal-body input[type="hidden"]').val();
    let estadoPedido = modalEditarPedido.find('.modal-body select#txtPedido').val();

    let data = {
        idPedido: idPedido,
        estadoPedido: estadoPedido
    };

    $.ajax({
        method: 'POST',
        url: 'actualizarPedido',
        data: data
    }).done(function(response){
        modalEditarPedido.modal('hide');
        window.location.href='listaPedidos';
    });
});