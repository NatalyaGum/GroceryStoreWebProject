<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="pagecontent"/>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<html>
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
        <strong>&divonx;WebStore</strong>
      </a>
      <div class="col-sm-8 col-md-7 py-4">
        <h6 class="text-white"><fmt:message key="help"/></h6>
        <p class="text-muted">+375170000000</p>
      </div>
      <div>
        <p><a href="${pageContext.request.contextPath}/controller?command=change_locale&language=EN">EN</a>
        </p><p>
        <a href="${pageContext.request.contextPath}/controller?command=change_locale&language=RU">RU</a></p>
      </div>
    </div>
  </div>

</header>

<main>

  <div class="py-5 text-center container">

          <div class="card shadow-sm">
            <h1 class="fw-light"><fmt:message key="add_product"/></h1>
            <fieldset>
              <form action="${pageContext.request.contextPath}/controller?command=add_product" method="post" enctype="multipart/form-data">
                <input type="hidden" name="command" value="add_product"/><br>
                <input type="text" name="title" value="<c:out value="${requestScope.product.title}"/>" required placeholder=<fmt:message key="add_product.title.placeholder"/> pattern="[A-Za-zА-Яа-я-,.!?""%()\s]{2,75}" class="form-control input-lg"/><br><br>
                <TEXTAREA name="description" value="<c:out value="${requestScope.product.description}"/>" required placeholder=<fmt:message key="add_product.description.placeholder"/> pattern=".{10,500}" class="form-control input-lg"/><fmt:message key="add_product.description.placeholder"/></TEXTAREA><br><br>
                <input type="text" name="manufacture" value="<c:out value="${requestScope.product.manufacture}"/>" required placeholder=<fmt:message key="add_product.manufacture.placeholder"/> pattern="[A-Za-zА-Яа-я-,.!?""%()\s]{3,100}" class="form-control input-lg"/><br><br>
                <fmt:message key="add_product.type.placeholder"/><br>
                <select name="type"  class="form-select" required placeholder=<fmt:message key="add_product.type.placeholder"/>>
                  <c:forEach var="element" items="${product_types_list}">
                    <option value="${element.productTypeName}">${element.productTypeName}</option>
                  </c:forEach>
                </select><br><br>

                <input type="text" name="price" value="<c:out value="${requestScope.product.price}"/>" required placeholder="<fmt:message key="add_product.price.placeholder"/>" pattern="\d{1,5}\,\d{1,2}" class="form-control input-lg"/><br><br>
                <input type="file" name="image" value="<c:out value="${requestScope.product.image}"/>" required placeholder=<fmt:message key="add_product.image.placeholder"/> pattern="([^s]+(.(?i)(jpg|png|gif|bmp))$)" class="form-control input-lg"/><br><br>
                <c:if test="${not empty message}"> <p><fmt:message key="${message}"/></p>  </c:if>
                <input type="submit"  value=<fmt:message key="add_product.add"/> >
              </form>
            </fieldset>


      </div>

  </div>

</main>

<footer class="text-muted py-5">
  <div class="container">
    <p class="float-end mb-1">
      <a href="#"><fmt:message key="top"/></a>
    </p>
    <p class="mb-1"> &copy; WebStore</p>

  </div>
</footer>

</body>
</html>
