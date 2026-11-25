<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Iniciar sesión - Boleteria</title>

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Geist:wght@100..900&family=Geist+Mono:wght@100..900&display=swap"
      rel="stylesheet"
    />

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.9/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-yEPZ7jP9S0QKiUQ0m3jjsO4ProIW7wvR9gXkI7JOGa2XVsw53Yke2bsdkBbjmmiX"
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
        <h1>Iniciar sesión</h1>
        <p class="login-subtitulo">Ingresa para comprar tus entradas</p>

        <form
          class="formulario-login"
          action="${pageContext.request.contextPath}/login"
          method="post"
          novalidate
        >
          <div class="campo-login">
            <label for="correo">Correo electrónico</label>
            <input
              type="email"
              id="correo"
              name="correo"
              placeholder="tucorreo@ejemplo.com"
              autocomplete="email"
            />
            <small class="error-login" id="error-correo"></small>
          </div>

          <div class="campo-login">
            <label for="clave">Contraseña</label>
            <input
              type="password"
              id="clave"
              name="clave"
              placeholder="Tu contraseña"
              autocomplete="current-password"
            />
            <small class="error-login" id="error-clave"></small>
          </div>

          <button type="submit" class="boton-login">Ingresar</button>
        </form>

        <p class="login-registro">
          ¿No tienes cuenta?
          <a href="${pageContext.request.contextPath}/Registrarse-Login.jsp">
            Regístrate
          </a>
        </p>
      </section>
    </main>

    <%@ include file="/WEB-INF/footer.jspf" %>

    <script src="${pageContext.request.contextPath}/js/login.js"></script>
  </body>
</html>
