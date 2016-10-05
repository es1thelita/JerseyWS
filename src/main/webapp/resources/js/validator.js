/**
 * Funcion JS encargada de filtrar un campo de texto para que solo se permita introducir numerosy comas,
 * sin importar orden ni que los repitan.
 */
function esNumeroComa(e) {
    var tecla = (document.all) ? e.keyCode : e.which;
    
    if (tecla == 8 || tecla == 0) return true;

    //Acepta numeros, guiones y coma
    var patron =/[0123456789,]/;
    var te = String.fromCharCode(tecla); 
	
	var element;
    if (!e) var e = window.event;
    if (e.target) element = e.target;
    else if (e.srcElement) element = e.srcElement;
    
    //Para no escribir dos comas seguidas
	if (tecla == 44){
    	var patronComa = /,$/;
    	var valor = element.value;
        if(patronComa.test(valor)) return false;
    }   
	
    return patron.test(te);
}