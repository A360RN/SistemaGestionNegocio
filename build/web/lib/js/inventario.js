/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function modalConfirm(callbackP, callbackC, callbackU){
  var idP;
  var idC;
  var idU;
  var modalProducto=$("#modalProducto");
  var modalCategoria=$("#modalCategoria");
  var modalUsuario=$("#modalUsuario");
  
  $(".btn-confirm").on("click", function(){
    idP=$(this).data("valuep");  
    idC=$(this).data("valuec");
    idU=$(this).data("valueu");
    if(idP !== undefined)
        modalProducto.modal('show');
    if(idC !== undefined)
        modalCategoria.modal('show');
    if(idU !== undefined)
        modalUsuario.modal('show');
  });
  $("#modalProducto-btn-si").on("click", function(){
    callbackP(true,idP);
    modalProducto.modal('hide');
  });
  
  $("#modalProducto-btn-no").on("click", function(){
    modalProducto.modal('hide');
  });
  
  $("#modalCategoria-btn-si").on("click", function(){
    callbackC(true,idC);
    modalCategoria.modal('hide');
  });
  
  $("#modalCategoria-btn-no").on("click", function(){
    modalCategoria.modal('hide');
  });
  
  $("#modalUsuario-btn-si").on("click", function(){
    callbackU(true,idU);
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

