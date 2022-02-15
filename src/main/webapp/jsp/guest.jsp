<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}" scope="session"/>
<fmt:setBundle basename="pagecontent"/>


<div class="col-sm-4 offset-md-1 py-4">
    <a href="${pageContext.request.contextPath}/controller?command=go_to_velcome" > <h4 class= "text-muted"><fmt:message key="order.cart"/></h4></a>
    <ul class="list-unstyled">
        <li><a href="${pageContext.request.contextPath}/controller?command=go_to_authorization" class= "text-muted">&divonx;<fmt:message key="orders"/></a></li>
        <li><a href="${pageContext.request.contextPath}/controller?command=go_to_authorization" class="text-muted">&divonx;<fmt:message key="user.edit"/></a></li>
        <li><a href="${pageContext.request.contextPath}/controller?command=go_to_authorization" class= "text-muted">&divonx;<fmt:message key="user.logout"/></a></li>

    </ul>
</div>