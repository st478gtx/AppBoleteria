<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Boleteria</title>

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

    <main class="container-boleteria">
      <div class="contenido-boleteria">

        <%@ include file="/WEB-INF/Barra_seleccion.jspf" %>

        <div
          id="carousel"
          class="carousel slide carousel-boleteria"
          data-bs-ride="carousel"
        >
          <div class="carousel-inner rounded-5 overflow-hidden">
            <div class="carousel-item active">
              <img
                src="${pageContext.request.contextPath}/img/banner/banner01.png"
                class="d-block w-100"
                alt="Coro con trajes coloridos cantando en un escenario iluminado con luces azules"
              />
            </div>

            <div class="carousel-item">
              <img
                src="${pageContext.request.contextPath}/img/banner/banner02.png"
                class="d-block w-100"
                alt="Niño sobre los hombros de su papá disfrutando un concierto al aire libre"
              />
            </div>

            <div class="carousel-item">
              <img
                src="${pageContext.request.contextPath}/img/banner/banner03.png"
                class="d-block w-100"
                alt="Guitarrista tocando frente al público en un concierto íntimo con luz roja"
              />
            </div>

            <div class="carousel-item">
              <img
                src="${pageContext.request.contextPath}/img/banner/banner04.png"
                class="d-block w-100"
                alt="Familias con niños sentadas disfrutando un espectáculo"
              />
            </div>
          </div>

          <button
            class="carousel-control-prev"
            type="button"
            data-bs-target="#carousel"
            data-bs-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Anterior</span>
          </button>

          <button
            class="carousel-control-next"
            type="button"
            data-bs-target="#carousel"
            data-bs-slide="next"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Siguiente</span>
          </button>

          <div class="carousel-indicators">
            <button
              type="button"
              data-bs-target="#carousel"
              data-bs-slide-to="0"
              class="active"
              aria-current="true"
              aria-label="Banner 1"
            ></button>
            <button
              type="button"
              data-bs-target="#carousel"
              data-bs-slide-to="1"
              aria-label="Banner 2"
            ></button>
            <button
              type="button"
              data-bs-target="#carousel"
              data-bs-slide-to="2"
              aria-label="Banner 3"
            ></button>
            <button
              type="button"
              data-bs-target="#carousel"
              data-bs-slide-to="3"
              aria-label="Banner 4"
            ></button>
          </div>
        </div>
      </div>

      <aside class="boleteria-lateral">
        <h3>¿Cómo comprar?</h3>

        <ol class="pasos-compra">
          <li>
            <span class="paso-numero">1</span>
            <div>
              <strong>Elige tu evento</strong>
              <p>Busca por nombre, fecha o categoría.</p>
            </div>
          </li>
          <li>
            <span class="paso-numero">2</span>
            <div>
              <strong>Selecciona tu zona</strong>
              <p>Escoge la zona y la cantidad de entradas.</p>
            </div>
          </li>
          <li>
            <span class="paso-numero">3</span>
            <div>
              <strong>Paga y listo</strong>
              <p>Recibe tus entradas en tu correo.</p>
            </div>
          </li>
        </ol>
      </aside>
    </main>

    <%@ include file="/WEB-INF/footer.jspf" %>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.9/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-WyOxWvTyr1QaMPfiPJSv76iReVthorl5uWlFtZPyK0IEB0hGzo9y5Bp9mYanr8Bu"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
