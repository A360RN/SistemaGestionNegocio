let modalAddProductoPedido = $('#modalAddProductoPedido');

let btnCancelarPedido = $('#btnVentasCancelarPedido');
let btnModalAddProductoPedidoSi = $('#modalAddProductoPedido-btn-si');
let btnModalAddProductoPedidoNo = $('#modalAddProductoPedido-btn-no');
let btnModalRegistrarPedidoSi = $('#modalRegistrarPedido-btn-si');

let selectCategoria = $('.modal-body select#categoria');
let selectProducto = $('.modal-body select#producto');

btnCancelarPedido.on('click', function (e) {
    window.location.href = 'listaPedidos';
});

modalAddProductoPedido.on('show.bs.modal', function (e) {
    let modal = $(this);

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'GET',
        url: 'categoria'
    }).done(function(response){
        selectCategoria.find('option').remove();
        response.forEach(function(categoriaItem){
            selectCategoria.append($('<option>', {
                value: categoriaItem.idCategoria,
                text: categoriaItem.nombreCategoria
            }));
        });
    });
});

selectCategoria.on('change', function(e){
    let idCategoria = selectCategoria.val();
    
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'GET',
        url: `categoria/${idCategoria}/producto`
    }).done(function(response){
        selectProducto.find('option').remove();
        response.forEach(function(productoItem){
            selectProducto.append($('<option>', {
                value: productoItem.idProducto,
                text: productoItem.nombreProducto
            }));
        });
    });
});