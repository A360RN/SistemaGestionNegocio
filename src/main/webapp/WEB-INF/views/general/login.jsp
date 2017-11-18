<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../includes/headerLogin.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-6 offset-3">
            <h3>Ingresar a la plataforma</h3>
            <form action="login" method="POST">
                <div class="form-group">
                    <label for="usuario">Ingrese usuario: </label>
                    <input id="usuario" name="usuario" type="text" class="form-control">    
                </div>
                <div class="form-group">
                    <label for="password">Ingrese contraseña:</label>
                    <input id="password" name="password" type="password" class="form-control">
                </div>
                <button class="btn btn-primary" type="submit">Ingresar</button>
                <button class="btn btn-primary">Registrarse</button>     
            </form>     
        </div>
    </div>

    <br><br> 
</div>


<%@include file="../includes/footer.jsp" %>