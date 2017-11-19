let btnCancelarPassword = $('#btnCancelarPassword');
let btnSubmitPassword = $('#submitPassword');
let btnModalPasswordSi = $('#modalPassword-btn-si');
let btnModalPasswordNo = $('#modalPassword-btn-no');

let modalPassword = $('#modalPassword');



/* 
    Para regresar a la pantalla anterior cuando se cambia
    contraseña
*/
btnCancelarPassword.on('click', function(e){
    e.preventDefault();
    
    window.location.href = 'perfil';
});

/* 
    Para guardar la contraseña nueva
*/
btnSubmitPassword.on('click', function(e){
    e.preventDefault();

    modalPassword.modal('show');
});

btnModalPasswordSi.on('click', function(){
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
    }).done(function(response){
        let rpta = response.rpta;

        if(rpta != null){
            actualizarAlertCambioPassword(rpta);
        }else{
            window.location.href = 'perfil';
        }
        modalPassword.modal('hide');
    });
});

btnModalPasswordNo.on('click', function(){
    modalPassword.modal('hide');
})

function actualizarAlertCambioPassword(rpta){
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

