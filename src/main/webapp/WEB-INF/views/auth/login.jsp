<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="message_auth_form_head" var="formHead"/>
<spring:message code="message_auth_form_content" var="formContent"/>
<spring:message code="message_auth_form_login" var="loginAs"/>
<spring:message code="password" var="pass"/>
<spring:message code="login" var="login"/>
<spring:message code="link_checkin" var="checkin"/>
<spring:message code="link_locale_ru" var="localRu"/>
<spring:message code="link_locale_en" var="localEn"/>
<spring:message code="title_of_pages" var="title"/>
<spring:message code="checkbox_remember_my" var="rememberMy"/>
<spring:message code="message_auth_form_valid_error" var="validError"/>
<spring:message code="link_registration" var="regist"/>

<!DOCTYPE html>
<html>
<head>
  <title>${title}</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Начальная страница</title>

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
        <h6>${formHead}</h6>
        <p class="lead">${formContent}</p>
      </div>

      <form:form modelAttribute="user" method="post" action="/j_spring_security_check" class="form-horizontal" role="form">
        <c:if test="${not empty error}">
          <div class="alert alert-danger">
            <h6>${validError}</h6>
          </div>
        </c:if>
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <form:input type="text" name="name" path="name" class="form-control" placeholder="${login}"/>
          </div>
        </div>
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <form:input type="password" name="password" path="password" class="form-control" placeholder="${pass}"/>
          </div>
        </div>
          <div class="form-group">
            <div class="checkbox text-left">
              <label>
                <input name="remember_user" type="checkbox"> ${rememberMy}
              </label>
            </div>
          </div>
        <div class="form-group">
          <div>
            <input type="submit" value="${checkin}" class="btn btn-block btn-primary btn-default"/>
          </div>
        </div>
      </form:form>

      <div class="text-center">
        <a href="/register">${regist}</a>
      </div>

    </div>
  </div>
  <script src="<c:url value="/static/js/jquery.js" />"></script>
  <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
</body>
</html>
