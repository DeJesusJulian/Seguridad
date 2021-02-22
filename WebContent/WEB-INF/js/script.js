/**
 * 
 */
function validarForm() {

  var expRegNombre = /^[a-zA-ZÑñÁáÉéÍíÓóÚúÜü\s]+$/;
  var expRegApellidos = /^[a-zA-ZÑñÁáÉéÍíÓóÚúÜü\s]+$/;
  var emailRegex = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
  var expTelefono= /^([0-9])*$/;


  var titulo = document.getElementById("titulo");
  var comentarios = document.getElementById("descripcion");
  var nombre = document.getElementById("nombre");
  var apellidos = document.getElementById("apellidos");
  var correo = document.getElementById("email");
  var fechaI = document.getElementById("fechaInicio").value;
  var fechaF = document.getElementById("fechaFin").value;
  var telefono = document.getElementById("telefono");
  var telefono2 = document.getElementById("telefono").value;

  //Campo nombre
  if (!nombre.value) {
    alert("El campo nombre es requerido");
    console.log("El campo apellidos admite letras y espacios.");
    nombre.focus();
    return false;
  }
  if (!expRegNombre.exec(nombre.value)) {
    alert("El campo nombre admite letras y espacios.")
    console.log("El campo apellidos admite letras y espacios.");
    nombre.focus();
    return false;
  }
  //Campo apellido
  if (!apellidos.value) {
    alert("El campo apellidos es requerido");
    apellidos.focus();
    return false;
  }
  if (!expRegApellidos.exec(apellidos.value)) {
    alert("El campo apellidos admite letras y espacios.")
    apellidos.focus();
    return false;
  }


  //campo email
  if (!correo.value) {
    alert("El campo correo es requerido");
    correo.focus();
    return false;
  }
  if (!emailRegex.exec(correo.value)) {
    alert("El campo correo no tiene el formato correcto.")
    correo.focus();
    return false;
  }
  // campo asunto
  if (!titulo.value) {
    alert("El campo asunto es requerido");
    titulo.focus();
    return false;
  }
  //campo comentarios
  if (!comentarios.value) {
    alert("El campo comentarios es requerido");
    comentarios.focus();
    return false;
  }

  if(new Date(fechaF) < new Date(fechaI)){
    alert("La fecha final no puede ser menor a la de inicio");
    return false;
  }

  if (!telefono.value) {
    alert("El campo telefono es requerido");
    correo.focus();
    return false;
  }
  if (!expTelefono.exec(telefono.value)) {
    alert("El campo telefono no tiene el formato correcto.")
    correo.focus();
    return false;
  }

  if(telefono2.length < 10 || telefono2.length > 15){
    alert("El campo telefono no tiene el tamaño correcto.")
    telefono.focus();
    return false;
  }

  return true;
}
// asociacion del boton enviar con el formulario en html//
window.onload = function () {
  var formulario = document.getElementById("evento-frm");
  formulario.onsubmit = validarForm;
}