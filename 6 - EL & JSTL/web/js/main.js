function Validar()
{
    var error=document.getElementById('Error');
    var usuario= document.getElementById('user').value;
    var contraseña= document.getElementById('pwd').value;

    var resultado= false;

    if (usuario != "" && contraseña!="")
    {
        resultado= true;
    }
    else
    {
        error.innerHTML="Debe rellenar ambos campos.";
        error.style.display="block";
    }
    return resultado;
}
