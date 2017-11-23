/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var botonEstadoProducto =$(".btn-cambiar-estado-producto");

botonEstadoProducto.on('click', function(e){
    let idProducto=$(this).data("idproducto");
    let data={idProducto:idProducto};
    $.ajax({
        method: 'POST',
        url: 'cambiarEstado',
        data: data
    }).done(function (e) {
        window.location.href='listaProductos';
    });
    
});
function modalConfirm(callbackP, callbackC){
  var id;
  var modalProducto = $("#modalProducto");
  var modalCategoria = $("#modalCategoria");

  $(".btn-producto").on("click", function () {
    id = $(this).data("value");
    if (id !== undefined)
      modalProducto.modal('show');
  });
  $(".btn-categoria").on("click", function () {
    id = $(this).data("value");
    if (id !== undefined)
      modalCategoria.modal('show');
  });
  $("#modalProducto-btn-si").on("click", function () {
    callbackP(true, id);
    modalProducto.modal('hide');
  });

  $("#modalProducto-btn-no").on("click", function () {
    modalProducto.modal('hide');
  });

  $("#modalCategoria-btn-si").on("click", function () {
    callbackC(true, id);
    modalCategoria.modal('hide');
  });

  $("#modalCategoria-btn-no").on("click", function () {
    modalCategoria.modal('hide');
  });
};

modalConfirm(
  function (confirm, id) {
    if (confirm) {
      window.location.href = "lista_productos.jsp?delete=" + id;
    }
  },
  function (confirm, id) {
    if (confirm) {
      window.location.href = "lista_categorias.jsp?delete=" + id;
    }
  }
);

