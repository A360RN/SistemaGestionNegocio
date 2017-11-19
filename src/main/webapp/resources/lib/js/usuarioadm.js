let btnCancelarPassword = $('#btnCancelarPassword');
let btnSubmitPassword = $('#submitPassword');
let btnModalPasswordSi = $('#modalPassword-btn-si');
let btnModalPasswordNo = $('#modalPassword-btn-no');
let btnEditarPolitica = $('.btn-editar-politica');
let btnEditarPoliticanSi = $('#modalEditarPolitica-btn-si');
let btnEditarPoliticaNo = $('#modalEditarPolitica-btn-no');

let modalPassword = $('#modalPassword');
let modalEditarPolitica = $('#modalEditarPolitica');

/* 
    Para regresar a la pantalla anterior cuando se cambia
    contraseña
*/
btnCancelarPassword.on('click', function (e) {
    e.preventDefault();

    window.location.href = 'perfil';
});

/* 
    Para guardar la contraseña nueva
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
        modal.find('.modal-body input#txtPuntosMin').val(response.minPuntos);
        modal.find('.modal-body input#txtPuntosMax').val(response.maxPuntos);
        modal.find('.modal-body input#txtPorcentaje').val(response.porcentajeDescuento);
    });
});

btnEditarPoliticanSi.on('click', function (e) {
    e.preventDefault();

    let idPolitica = modalEditarPolitica.find('.modal-body input[type="hidden"]').val();
    let descPolitica = modalEditarPolitica.find('.modal-body input#txtPolitica').val();
    let minPuntos = modalEditarPolitica.find('.modal-body input#txtPuntosMin').val();
    let maxPuntos = modalEditarPolitica.find('.modal-body input#txtPuntosMax').val();
    let porcentajeDescuento = modalEditarPolitica.find('.modal-body input#txtPorcentaje').val();

    let data = {
        idPolitica: idPolitica,
        descPolitica: descPolitica,
        minPuntos: minPuntos,
        maxPuntos: maxPuntos,
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
})