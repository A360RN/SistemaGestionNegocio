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
function modalConfirm(callbackP, callbackC, callbackU){
  var id;
  var modalProducto=$("#modalProducto");
  var modalCategoria=$("#modalCategoria");
  var modalUsuario=$("#modalUsuario");
  
  $(".btn-producto").on("click", function(){
    id=$(this).data("value");
    if(id !== undefined)
        modalProducto.modal('show');
  });
  $(".btn-usuario").on("click", function(){
    id=$(this).data("value");
    if(id !== undefined)
        modalUsuario.modal('show');
  });
  $(".btn-categoria").on("click", function(){
    id=$(this).data("value");
    if(id !== undefined)
        modalCategoria.modal('show');
  });
  $("#modalProducto-btn-si").on("click", function(){
    callbackP(true,id);
    modalProducto.modal('hide');
  });
  
  $("#modalProducto-btn-no").on("click", function(){
    modalProducto.modal('hide');
  });
  
  $("#modalCategoria-btn-si").on("click", function(){
    callbackC(true,id);
    modalCategoria.modal('hide');
  });
  
  $("#modalCategoria-btn-no").on("click", function(){
    modalCategoria.modal('hide');
  });
  
  $("#modalUsuario-btn-si").on("click", function(){
    callbackU(true,id);
    modalUsuario.modal('hide');
  });
  
  $("#modalUsuario-btn-no").on("click", function(){
    modalUsuario.modal('hide');
  });
};

modalConfirm(
        function(confirm, id){
            if(confirm){
                window.location.href="lista_productos.jsp?delete="+id;
            }
        },
        function(confirm,id){
            if(confirm){
                window.location.href="lista_categorias.jsp?delete="+id;
            }
        },
        function(confirm,id){
            if(confirm){
                window.location.href="lista_usuarios.jsp?delete="+id;
            }
        });

