let btnCancelarPassword = $('#btnCancelarPassword');
let btnSubmitPassword = $('#submitPassword');
let btnModalPasswordSi = $('#modalPassword-btn-si');
let btnModalPasswordNo = $('#modalPassword-btn-no');
let btnEditarPolitica = $('.btn-editar-politica');
let btnEditarPoliticanSi = $('#modalEditarPolitica-btn-si');
let btnEditarPoliticaNo = $('#modalEditarPolitica-btn-no');
let btnModalEmpleadoInactivarSi = $('#modalEmpleadoInactivar-btn-si');
let btnModalEmpleadoInactivarNo = $('#modalEmpleadoInactivar-btn-no');
let botonEditarEmpleado=$(".btn-editar-empleado");
let botonRegistrarEmpleado=("#btn-registrar-empleado");
let modalPassword = $('#modalPassword');
let modalEditarPolitica = $('#modalEditarPolitica');
let modalEmpleadoInactivar = $('#modalEmpleadoInactivar');


botonEditarEmpleado.on('click', function (e) {
    let idEmpleado = $(this).data("idempleado");
    $("#hiddenEditarEmpleado").val(idEmpleado);
    $("#EditFormEmpleado").submit();
});
/* 
    Para regresar a la pantalla anterior cuando se cambia
    contraseÃ±a
*/
btnCancelarPassword.on('click', function (e) {
    e.preventDefault();

    window.location.href = 'perfil';
});

/* 
    Para guardar la contraseÃ±a nueva
*/
btnSubmitPassword.on('click', function (e) {
    e.preventDefault();

    modalPassword.modal('show');
});

btnModalPasswordSi.on('click', function () {
    let passwordActual = $('#passwordActual').val();
    let passwordNueva = $('#passwordNueva').val();
    let passwordConfirmacion = $('#passwordConfirmacion').val();

    let data = {
        passwordActual: passwordActual,
        passwordNueva: passwordNueva,
        passwordConfirmacion: passwordConfirmacion
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        url: 'passwordCorrecta',
        data: JSON.stringify(data)
    }).done(function (response) {
        let rpta = response.rpta;

        if (rpta != null) {
            actualizarAlertCambioPassword(rpta);
        } else {
            window.location.href = 'perfil';
        }
        modalPassword.modal('hide');
    });
});

btnModalPasswordNo.on('click', function () {
    modalPassword.modal('hide');
})

function actualizarAlertCambioPassword(rpta) {
    let alertWrapper = $('#alert-wrapper');

    let alerthtml = `
    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        ${rpta}
    </div>
    `;

    alertWrapper.html(alerthtml);
};

/* Modal editar politica */
modalEditarPolitica.on('show.bs.modal', function (e) {
    let button = $(e.relatedTarget);
    let idPolitica = button.data('idpolitica');
    let modal = $(this);
    let data = {
        idPolitica: idPolitica
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        url: 'editarPolitica',
        data: JSON.stringify(data)
    }).done(function (response) {
        modal.find('.modal-body input[type="hidden"]').val(idPolitica);
        modal.find('.modal-body input#txtPolitica').val(response.descPolitica);
        modal.find('.modal-body input#txtPuntosMinInd').val(response.minPuntosIndividual);
        modal.find('.modal-body input#txtPuntosMaxInd').val(response.maxPuntosIndividual);
        modal.find('.modal-body input#txtPuntosMinGru').val(response.minPuntosGrupal);
        modal.find('.modal-body input#txtPuntosMaxGru').val(response.maxPuntosGrupal);
        modal.find('.modal-body input#txtPorcentaje').val(response.porcentajeDescuento);
    });
});

btnEditarPoliticanSi.on('click', function (e) {
    e.preventDefault();

    let idPolitica = modalEditarPolitica.find('.modal-body input[type="hidden"]').val();
    let descPolitica = modalEditarPolitica.find('.modal-body input#txtPolitica').val();
    let minPuntosInd = modalEditarPolitica.find('.modal-body input#txtPuntosMinInd').val();
    let maxPuntosInd = modalEditarPolitica.find('.modal-body input#txtPuntosMaxInd').val();
    let minPuntosGru = modalEditarPolitica.find('.modal-body input#txtPuntosMinGru').val();
    let maxPuntosGru = modalEditarPolitica.find('.modal-body input#txtPuntosMaxGru').val();
    let porcentajeDescuento = modalEditarPolitica.find('.modal-body input#txtPorcentaje').val();

    let data = {
        idPolitica: idPolitica,
        descPolitica: descPolitica,
        minPuntosIndividual: minPuntosInd,
        maxPuntosIndividual: maxPuntosInd,
        minPuntosGrupal: minPuntosGru,
        maxPuntosGrupal : maxPuntosGru,
        porcentajeDescuento: porcentajeDescuento
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'POST',
        url: 'actualizarPolitica',
        data: JSON.stringify(data)
    }).done(function(response){
        modalEditarPolitica.modal('hide');
        window.location.href='listaPoliticas';
    });
});

/* Modal para inactivar al empleado */
modalEmpleadoInactivar.on('show.bs.modal', function(e){
    let button = $(e.relatedTarget);
    let idUsuario = button.data('value');
    let modal = $(this);

    modal.find('.modal-body input').val(idUsuario);
});

btnModalEmpleadoInactivarNo.on('click', function(e){
    modalEmpleadoInactivar.modal('hide');
});

btnModalEmpleadoInactivarSi.on('click', function(e){
    e.preventDefault();

    let idUsuario =  modalEmpleadoInactivar.find('.modal-body input').val();

    let data = {
        idUsuario: idUsuario
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: 'DELETE',
        url: 'listaEmpleados',
        data: JSON.stringify(data)
    }).done(function(response){
        window.location.href = 'listaEmpleados';
    });
});

botonRegistrarEmpleado.on('click', function (e) {
    let idEmpleado=$("#idEmpleado").val();
    let usuario = $("#usuario").val().trim();
    let password=$("#password").val().trim();
    let primerNombre = $("#primerNombre").val().trim();
    let segundoNombre = $("#segundoNombre").val().trim();
    let primerApellido = $("#primerApellido").val().trim();
    let segundoApellido = $("#segundoApellido").val().trim();
    let perfiles = $("#perfiles").val().trim();
    let telefonoCelular = $("#telCelular").val().trim();
    let telefonoFijo = $("#telFijo").val().trim();
    let ruc = $("#ruc").val().trim();
    let email = $("#email").val().trim();
    let error='';
    /*
    let patron = /^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-Z0-9À-ÿ\u00f1\u00d1]*)*[a-zA-Z0-9À-ÿ\u00f1\u00d1]+$/;
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

    }*/
    if (error === '')
    {
        /*nombre=nombre.toUpperCase();
        descripcion=descripcion.toUpperCase();*/
        let data={
            idEmpleado:idEmpleado,
            usuario:usuario,
            password:password,
            primerNombre:primerNombre,
            segundoNombre:segundoNombre,
            primerApellido:primerApellido,
            segundoApellido:segundoApellido,
            perfiles:perfiles,
            telefonoCelular:telefonoCelular,
            telefonoFijo:telefonoFijo,
            ruc:ruc,
            email:email
        };
        $.ajax({
            method: 'POST',
            url: 'saveEmpleado',
            data: data
        }).done(function (e) {
            /*if(e.respuesta==="repetido")
            {
                error += '<p class="mb-0">Producto repetido</p>';
                $("#errores-producto").html("<div class='alert alert-danger' role='alert'>"+error+"</div>");
            }else if(e.respuesta==="")*/
                window.location.href = 'listaEmpleados';
        });
    } else
        alert("AAAAAAAA");
        //$("#errores-producto").html("<div class='alert alert-danger' role='alert'>"+error+"</div>");
});