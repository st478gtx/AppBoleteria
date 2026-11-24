const formulario = document.querySelector(".formulario-login");
const campoCorreo = document.getElementById("correo");
const campoClave = document.getElementById("clave");
const errorCorreo = document.getElementById("error-correo");
const errorClave = document.getElementById("error-clave");

// Solo revisa que tenga la forma texto@texto.texto; si el correo existe lo decide el servidor.
const formatoCorreo = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

function mostrarError(campo, mensaje, error) {
  error.textContent = mensaje;
  campo.classList.add("campo-invalido");
}

function limpiarError(campo, error) {
  error.textContent = "";
  campo.classList.remove("campo-invalido");
}

function validarCorreo() {
  const correo = campoCorreo.value.trim();

  if (correo === "") {
    mostrarError(campoCorreo, "Ingresa tu correo.", errorCorreo);
    return false;
  }

  if (!formatoCorreo.test(correo)) {
    mostrarError(campoCorreo, "El correo no tiene un formato válido.", errorCorreo);
    return false;
  }

  limpiarError(campoCorreo, errorCorreo);
  return true;
}

function validarClave() {
  if (campoClave.value === "") {
    mostrarError(campoClave, "Ingresa tu contraseña.", errorClave);
    return false;
  }

  limpiarError(campoClave, errorClave);
  return true;
}

formulario.addEventListener("submit", function (evento) {
  // Se validan los dos antes de decidir para que el usuario vea todos los errores juntos.
  const correoValido = validarCorreo();
  const claveValida = validarClave();

  if (!correoValido || !claveValida) {
    evento.preventDefault();
  }
});

campoCorreo.addEventListener("input", function () {
  limpiarError(campoCorreo, errorCorreo);
});

campoClave.addEventListener("input", function () {
  limpiarError(campoClave, errorClave);
});
