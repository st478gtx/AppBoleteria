<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Registrarse - Boleteria</title>

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />

    <link
      href="https://fonts.googleapis.com/css2?family=Geist:wght@100..900&family=Geist+Mono:wght@100..900&display=swap"
      rel="stylesheet"
    />

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-B/GM4XqrwHnWXNOWMbloTmrYXZg10cakYGmpfsR/bbzQ6JAJI4ihuyADKLnBgrCe"
      crossorigin="anonymous"
    />

    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/style.css"
    />
  </head>

  <body data-bs-theme="light">
    <%@ include file="/WEB-INF/menu.jspf" %>

    <main class="contenedor-login">
      <section class="tarjeta-login">
        <h1>Crear cuenta</h1>

        <p class="login-subtitulo">
          Regístrate para descubrir y comprar tus eventos favoritos.
        </p>

        <form
          class="formulario-login"
          action="${pageContext.request.contextPath}/registro"
          method="post"
        >
          <div class="campo-login">
            <label for="nombre">Nombre completo</label>

            <input
              type="text"
              id="nombre"
              name="nombre"
              placeholder="Tu nombre completo"
              autocomplete="name"
              required
            />
          </div>

          <div class="campo-login">
            <label for="correo">Correo electrónico</label>

            <input
              type="email"
              id="correo"
              name="correo"
              placeholder="tucorreo@ejemplo.com"
              autocomplete="email"
              required
            />
          </div>

          <div class="campo-login">
            <label for="clave">Contraseña</label>

            <input
              type="password"
              id="clave"
              name="clave"
              placeholder="Crea una contraseña"
              autocomplete="new-password"
              minlength="8"
              required
            />
          </div>

          <div class="campo-login">
            <label for="confirmar-clave"> Confirmar contraseña </label>

            <input
              type="password"
              id="confirmar-clave"
              name="confirmarClave"
              placeholder="Repite tu contraseña"
              autocomplete="new-password"
              minlength="8"
              required
            />
          </div>

          <button type="submit" class="boton-login">Crear cuenta</button>
        </form>

        <p class="login-registro">
          ¿Ya tienes una cuenta?

          <a href="${pageContext.request.contextPath}/login.jsp">
            Inicia sesión
          </a>
        </p>
      </section>
    </main>

    <%@ include file="/WEB-INF/footer.jspf" %>
  </body>
</html>
