<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="message_auth_form_head" var="formHead"/>
<spring:message code="message_auth_form_content" var="formContent"/>
<spring:message code="link_checkin" var="checkin"/>
<spring:message code="link_registration" var="regist"/>
<spring:message code="link_locale_ru" var="localRu"/>
<spring:message code="link_locale_en" var="localEn"/>
<spring:message code="title_of_pages" var="title"/>
<spring:message code="message_register_form" var="soGood"/>

<!DOCTYPE html>
<html>
<head>
  <title>${title}</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

  <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet">
  <link href="<c:url value='/static/css/bootstrap-theme.min.css' />" rel="stylesheet">
  <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet">
</head>
<body>
  <div class="container" style="width: 600px">
    <div class="jumbotron text-center">
      <div class="text-right">
        <a href="?lang=ru">${localRu}</a> |
        <a href="?lang=en">${localEn}</a>
      </div>
      <div class="page-header">
        <h2>${formHead}</h2>
        <p class="lead">${formContent}</p>
      </div>
      <c:if test="${not empty success}">
        <div class="alert alert-success">
          <h6>${success}, ${soGood}</h6>
        </div>
      </c:if>
      <a href="/checkUser" class="btn btn-lg btn-primary">
        <span class="glyphicon glyphicon-log-in"></span>
        <span>${checkin}</span>
      </a>

      <a href="/register" class="btn btn-lg btn-primary">${regist}</a>
    </div>
  </div>
  <script src="<c:url value="/static/js/jquery.js" />"></script>
  <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
</body>
</html>
