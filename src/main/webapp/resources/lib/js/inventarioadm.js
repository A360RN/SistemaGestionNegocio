/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var botonEstadoProducto = $(".btn-cambiar-estado-producto");
var botonEstadoCategoria = $(".btn-cambiar-estado-categoria");
var botonRegistrarProducto = $("#btn-registrar-producto");
var botonRegistrarCategoria=$("#btn-registrar-categoria");
var botonEditarProducto=$(".btn-editar-producto");
var botonEditarCategoria=$(".btn-editar-categoria");
botonEditarProducto.on('click', function (e) {
    let idProducto = $(this).data("idproducto");
    $("#hiddenEditarProducto").val(idProducto);
    $("#EditFormProducto").submit();
});

botonEditarCategoria.on('click', function (e) {
    let idCategoria = $(this).data("idcategoria");
    $("#hiddenEditarCategoria").val(idCategoria);
    $("#EditFormCategoria").submit();
});

botonEstadoProducto.on('click', function (e) {
    let idProducto = $(this).data("idproducto");
    let data = {idProducto: idProducto};
    $.ajax({
        method: 'POST',
        url: 'cambiarEstadoProducto',
        data: data
    }).done(function (e) {
        window.location.href = 'listaProductos';
    });

});

botonEstadoCategoria.on('click', function (e) {
    let idCategoria = $(this).data("idcategoria");
    let data = {idCategoria: idCategoria};
    $.ajax({
        method: 'POST',
        url: 'cambiarEstadoCategoria',
        data: data
    }).done(function (e) {
        window.location.href = 'listaCategorias';
    });

});


botonRegistrarCategoria.on('click', function (e) {
    let idCategoria=$("#idCategoria").val();
    let nombre = $("#nombre").val().trim();
    let descripcion = $("#descripcion").val().trim();
    let patron = /^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$/;
    let error = '';
    //Serializa los campos del formulario en notación URL para Ajax

    if (nombre === '' || descripcion === '')
    {
        error += '<p class="mb-0">Debe rellenar todos los campos</p>';

    } else {    
        // En caso de querer validar cadenas con espacios usar: /^[a-zA-Z\s]*$/
        if (nombre.search(patron))
            error += '<p class="mb-0">El nombre del producto debe ser una cadena de texto</p>';
    }
    if (error === '')
    {
        nombre=nombre.toUpperCase();
        descripcion=descripcion.toUpperCase();
        let data={
            idCategoria:idCategoria,
            nombre:nombre,
            descripcion:descripcion
        };
        $.ajax({
            method: 'POST',
            url: 'saveCategoria',
            data: data
        }).done(function (e) {
            if(e.respuesta==="repetido")
            {
                error += '<p class="mb-0">Categoria repetido</p>';
                $("#errores-producto").html("<div class='alert alert-danger' role='alert'>"+error+"</div>");
            }else if(e.respuesta==="")
                window.location.href = 'listaCategorias';
        });
    } else
        $("#errores-producto").html("<div class='alert alert-danger' role='alert'>"+error+"</div>");
});






botonRegistrarProducto.on('click', function (e) {
    let idProducto=$("#idProducto").val();
    let nombre = $("#nombre").val().trim();
    let categoria = $("#categoria").val().trim();
    let precio = $("#precio").val().trim();
    let puntos = $("#puntos").val().trim();
    let cantidad = $("#cantidad").val().trim();
    let descripcion = $("#descripcion").val().trim();
    let patron = /^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$/;
    let error = '';
    //Serializa los campos del formulario en notación URL para Ajax

    if (nombre === '' || categoria === '' || descripcion === '' || precio === '' || puntos === '' || cantidad === '')
    {
        error += '<p class="mb-0">Debe rellenar todos los campos</p>';

    } else {
       
        // En caso de querer validar cadenas con espacios usar: /^[a-zA-Z\s]*$/
        if (nombre.search(patron))
            error += '<p class="mb-0">El nombre del producto debe ser una cadena de texto</p>';
        if (isNaN(precio))
        {
            error += '<p class="mb-0">El precio del producto debe ser un numero Ej: 19.80</p>';

        }
        if (isNaN(puntos))
        {
            error += '<p class="mb-0">Los puntos del producto deben ser un numero Ej: 25</p>';
        } else if (puntos % 1 !== 0) {
            error += '<p class="mb-0">Los puntos del producto deben ser un numero entero</p>';
        }
        if (isNaN(cantidad))
        {
            error += '<p class="mb-0">La cantidad del producto debe ser un numero Ej: 50</p>';
        } else if (cantidad % 1 !== 0) {
            error += '<p class="mb-0">La cantidad del producto debe ser un numero entero</p>';
        }

    }
    if (error === '')
    {
        nombre=nombre.toUpperCase();
        descripcion=descripcion.toUpperCase();
        let data={
            idProducto:idProducto,
            nombre:nombre,
            categoria:categoria,
            precio:precio,
            puntos:puntos,
            cantidad:cantidad,
            descripcion:descripcion
        };
        $.ajax({
            method: 'POST',
            url: 'saveProducto',
            data: data
        }).done(function (e) {
            if(e.respuesta==="repetido")
            {
                error += '<p class="mb-0">Producto repetido</p>';
                $("#errores-producto").html("<div class='alert alert-danger' role='alert'>"+error+"</div>");
            }else if(e.respuesta==="")
                window.location.href = 'listaProductos';
        });
    } else
        $("#errores-producto").html("<div class='alert alert-danger' role='alert'>"+error+"</div>");
});
/*
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
 );*/



