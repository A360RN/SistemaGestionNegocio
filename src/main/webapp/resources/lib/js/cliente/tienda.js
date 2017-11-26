let modalDetalleProducto = $('#modalDetalleProducto');

modalDetalleProducto.on('show.bs.modal', function (event) {
    let button = $(event.relatedTarget);
    let idProducto = button.data('idproducto');
    let modal = $(this);

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: `productos/${idProducto}`,
        method: 'GET'
    }).done(function (response) {
        modal.find('.modal-header h4').text(response.nombreProducto);
        modal.find('.modal-body input#txtCategoria').val(response.categoria.nombreCategoria);
        modal.find('.modal-body textarea').val(response.descripcionProducto);
    });
});