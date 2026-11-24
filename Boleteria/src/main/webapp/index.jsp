<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!doctype html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Inicio-Boleteria</title>

    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/style.css"
    />

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-B/GM4XqrwHnWXNOWMbloTmrYXZg10cakYGmpfsR/bbzQ6JAJI4ihuyADKLnBgrCe"
      crossorigin="anonymous"
    />

    <title>Boleteria</title>
  </head>

  <body data-bs-theme="light">
    <%@ include file="/WEB-INF/menu.jspf" %>

    <main class="container-boleteria">
      <div class="contenido-boleteria">

        <%@ include file="/WEB-INF/Barra_seleccion.jspf" %>

        <div
          id="carousel"
          class="carousel carousel-overlay slide carousel-boleteria"
          data-bs-autoplay="true"
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

          <div class="carousel-overlay-controls">
            <div>
              <button
                class="btn-icon btn-sm btn-subtle theme-secondary"
                type="button"
                data-bs-target="#carousel"
                data-bs-slide="prev"
              >
                <span class="carousel-icon-prev" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
              </button>

              <button
                class="btn-icon btn-sm btn-subtle theme-secondary"
                type="button"
                data-bs-target="#carousel"
                data-bs-slide="next"
              >
                <span class="carousel-icon-next" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
              </button>
            </div>

            <div class="carousel-indicators">
              <button
                type="button"
                data-bs-target="#carousel"
                data-bs-slide-to="0"
                class="active"
                aria-current="true"
                aria-label="Slide 1"
              ></button>
              <button
                type="button"
                data-bs-target="#carousel"
                data-bs-slide-to="1"
                aria-label="Slide 2"
              ></button>
              <button
                type="button"
                data-bs-target="#carousel"
                data-bs-slide-to="2"
                aria-label="Slide 3"
              ></button>
              <button
                type="button"
                data-bs-target="#carousel"
                data-bs-slide-to="3"
                aria-label="Slide 4"
              ></button>
            </div>
          </div>
        </div>
      </div>

      <div class="boleteria-lateral">
        <h3>Panel lateral</h3>
      </div>
    </main>

    <%@ include file="/WEB-INF/footer.jspf" %>

    <script
      type="module"
      src="https://cdn.jsdelivr.net/npm/bootstrap@6.0.0-alpha.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-1a/pXj49ZQ1aHEmrJ+gMw1otqoVsYwlEnlD8mIfY2TV03r20Y0CN7uqx1tQogjPL"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
