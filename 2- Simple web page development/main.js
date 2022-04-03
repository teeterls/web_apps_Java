var procesoID;
//mensaje inicial 
document.getElementById('Error').innerHTML= "<span> Debe introducir algún valor de búsqueda </span>";

function borrar()
{
    document.getElementById('cajabusqueda').value="";
    document.getElementById('Error').innerHTML="<span> Debe introducir algún valor de búsqueda </span>";
}

function ValidarForm()
{
    var op = 1; //opacity inicial
    var errores =["<span> Debe introducir algún valor de búsqueda </span>","<span> Solo se pueden buscar palabras que contengan texto</span>","<span> El criterio de búsqueda debe tener entre 3 y 5 caracteres </span>"];
    var timer;
    document.getElementById('cajabusqueda').addEventListener('click',borrar);
    var caja = document.getElementById('cajabusqueda');
    caja.addEventListener('keydown', function(event) {

        if (event.keyCode == 13) {
            event.preventDefault();
            document.getElementById('botonbusqueda').click();
            location.reload();
        }

    });

    timer = setInterval(function () {
        if (op <= 0.1){
            clearInterval(timer);
            document.getElementById('Error').style.display = 'none';
            location.reload();
        }
        document.getElementById('Error').style.opacity = op;
        op -= op * 0.1;
    }, 200);
    var input = document.getElementById('cajabusqueda').value;
    var aux= /^[A-Za-z]+$/;  //variable que filtra los caracteres especiales

    if (input=="") {


        document.getElementById('Error').innerHTML = errores[0];


    }
    else if (!aux.test(input)) //true si encuentra match entre Strings, si no lo encuentra
        document.getElementById('Error').innerHTML = errores[1];



    else if (input.length<3 || input.length>5)
        document.getElementById('Error').innerHTML = errores[2];

    else
        document.getElementById('Error').innerHTML="OK!";
}


function ValidarFinal()
{
    if (document.getElementById('Error').innerHTML=="OK!")
    {
        var busqueda=document.getElementById('cajabusqueda').value;
        window.open("https://www.google.com/search?q=" + busqueda);
        location.reload();
        //window.open("https://www.google.com/search?q=" + busqueda, '_blank'); default en una nueva pantalla
    }

}

