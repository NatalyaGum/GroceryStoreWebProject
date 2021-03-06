<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="pagecontent"/>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <meta charset="utf-8">

    <title><fmt:message key="title"/></title>

</head>
<body>
<header>

    <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container">
            <a href="${pageContext.request.contextPath}/controller?command=go_to_main_page" class="navbar-brand d-flex align-items-center">
                <H1><strong>&divonx;WebStore</strong></H1>
            </a>


            <c:if test="${sessionScope.role eq 'guest'}">
            <div >
                <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" method="post"
                      action="${pageContext.request.contextPath}/controller?command=sign_in">
                    <input class="form-control form-control-dark" type="email" name="email"
                           value="<c:out value="${requestScope.user_email}"/>" required placeholder=
                               <fmt:message key="sign_up.email.placeholder"/> pattern="(([A-Za-z\d._]+){5,25}@([A-Za-z]+){3,10}\.([a-z]+){2,3})"/>
                    <input class="form-control form-control-dark" type="password" name="password"
                           value="<c:out value="${requestScope.user.password}"/>" required placeholder=
                               <fmt:message key="sign_in.password.title"/> pattern="\S{6,20}"/>
                    <div class="text-end">
                        <button type="submit" class="btn btn-outline-light me-2"><fmt:message key="sign_in.title"/></button>

                        <a href="${pageContext.request.contextPath}/controller?command=go_to_registration">
                            <button type="button" class="btn btn-outline-light me-2"><fmt:message key="sign_up.submit"/></button>
                        </a>
                    </div>
                </form>

            </div>
        </div>
        </c:if>

        <c:if test="${not empty sessionScope.user}">
            <div class="text-white"><b><c:out value="${sessionScope.user.role}: ${sessionScope.user.email} "/></b><br>
                <a href="${pageContext.request.contextPath}/controller?command=go_to_update_profile" class="text-muted"><fmt:message key="user.edit"/></a>
                <p> <a href="${pageContext.request.contextPath}/controller?command=sign_out" class="text-muted"><fmt:message key="user.sign_out"/></a></p></div>
        </c:if>

        <div>
            <p><a href="${pageContext.request.contextPath}/controller?command=change_locale&language=EN" class="text-muted">EN</a>&nbsp; </p>
            <p><a href="${pageContext.request.contextPath}/controller?command=change_locale&language=RU" class="text-muted">RU</a>&nbsp;</p>
        </div>
        <c:if test="${not empty message}"><p class="text-muted"><fmt:message key="${message}"/></p></c:if>
    </div>
    </div>
</header>

<main>


        <table width="90%"align="center"> <tr ><td width="35%" align="left" valign="top">
            <jsp:include page="${sessionScope.role}.jsp"/>
        </td>
            <td>

    <div class="album py-5 bg-light">
        <div class="container">

            <p class="lead text-muted"><fmt:message key="search.result"/> "${search_value}"</p>

            <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">

<c:forEach var="product" items="${products_list}">
                <div class="col">
                    <div class="card shadow-sm">

                        <img class="bd-placeholder-img card-img-top" src="${product.picture}" class="img-thumbnail" alt="${product.title}"  width="98%"/>


                        <div class="card-body">
                            <p class="card-text">${product.title} <br>${product.description} <br>${product.manufacture}</p>
                                ${product.price} <fmt:message key="rub"/>
                            <div class="d-flex justify-content-between align-items-center">
                                <div class="btn-group">
                                    <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" method="post"
                                          action="${pageContext.request.contextPath}/controller?command=search&productId=${product.productId}&search_value=${search_value}">
                                    <button type="submit" class="btn btn-sm btn-outline-secondary"><fmt:message key="product.buy"/> </button>
                                    <input type="number" name="product_count" min="1" max="20" value="1" step="1" class="btn btn-sm btn-outline-secondary" />
                                    </form>
                                </div>
                                <small class="text-muted">#${product.productId}</small>
                            </div>
                        </div>
                    </div>
                </div>
</c:forEach>

            </div>
            </div>
     </div>
    </td></tr>
        </table>


</main>

<footer class="text-muted py-5">
    <div class="container">
        <p class="float-end mb-1">
            <a class="text-muted" href="#"><fmt:message key="top"/></a>
        </p>
        <p class="mb-1"> &copy; WebShop</p>

    </div>
</footer>


</body>
</html>

