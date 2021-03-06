<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="pagecontent"/>


<html lang="ru">
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <meta charset="utf-8">

  <title>WebShop</title>



</head>
<body>

<header>

  <div class="navbar navbar-dark bg-dark shadow-sm">
    <div class="container">
      <a href="${pageContext.request.contextPath}/controller?command=go_to_main_page" class="navbar-brand d-flex align-items-center">
        <H1> <strong>&divonx;WebStore</strong></H1>
      </a>
      <div class="col-sm-8 col-md-7 py-4">
        <h6 class="text-white">Служба поддерки круглосуточно. </h6>
        <p class="text-muted">+375170000000</p>
      </div>
    </div>
  </div>

</header>

<main>

  <div>
    Request from ${pageContext.errorData.requestURI} is failed<br/>
    Servlet name: ${pageContext.errorData.servletName}<br/>
    Status code: ${pageContext.errorData.statusCode}<br/>
    Exception: ${pageContext.exception}<br/>
    Message from exception: ${pageContext.exception.message}<br/>
    stack trace: ${pageContext.exception.stackTrace.toString}<br/>

    </div>
</main>

<footer class="text-muted py-5">
  <div class="container">
    <p class="float-end mb-1">
      <a href="#">Вернуться наверх</a>
    </p>
    <p class="mb-1"> &copy; WebShop</p>

  </div>
</footer>





</body>
</html>

