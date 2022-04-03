
function Validar()
{
    var error=document.getElementById('Error');
    var cantidad= document.getElementById('cantidad').value;
    var libro= document.getElementById('libro').value;

    var resultado= false;

    if (cantidad=="")
    {
        error.innerHTML="Debe indicar una cantidad.";
        error.style.display="block";
    }
    else if (isNaN(cantidad))
    {
        error.innerHTML="La cantidad debe ser numérica.";
        error.style.display="block";
        document.getElementById('cantidad').value=""; //borrar cantidad
    }
    else if (libro=="")
    {
        error.innerHTML="Seleccione un libro, por favor...";
        error.style.display="block";
    }
    else {
        resultado = true;
        error.innerHTML="";
    }
    return resultado;
}

function Borrar()
{
    document.getElementById('cantidad').value="";
    document.getElementById('Error').value="";
}