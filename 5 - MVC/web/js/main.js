

function Validar()
{
    var error=document.getElementById('Error');
    var nombre = document.getElementById('nom').value;
    var usuario= document.getElementById('usr').value;
    var contraseña= document.getElementById('pwd').value;

    var resultado= false;

    if (nombre != "" && usuario != "" && contraseña!="")
    {
        resultado= true;
    }
    else
    {
        error.innerHTML="Debe rellenar todos los campos con *.";
        error.style.display="block";
    }
    return resultado;
}

function BorrarError()
{
    var error=document.getElementById('Error');
    error.innerHTML="";
}
