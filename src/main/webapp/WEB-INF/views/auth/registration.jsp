<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="message_auth_form_head" var="formHead"/>
<spring:message code="title_of_pages" var="title"/>
<spring:message code="text_field_message_password" var="password"/>
<spring:message code="text_field_message_login" var="loginMessage"/>
<spring:message code="text_field_message_email" var="email"/>
<spring:message code="link_registration" var="regist"/>
<spring:message code="login" var="login"/>
<spring:message code="link_checkin" var="checkin"/>
<spring:message code="link_locale_ru" var="localRu"/>
<spring:message code="link_locale_en" var="localEn"/>


<!DOCTYPE html>
<html>
<head>
    <title>${title}</title>
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
        <h3>${formHead}</h3>
      </div>

      <form:form modelAttribute="user" method="post" action="/register" class="form-horizontal" role="form">
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
            <form:input type="text" path="name" class="form-control" placeholder="${loginMessage}"/>
          </div>
          <div class="has-error">
            <form:errors path="name" class="help-inline"/>
          </div>
        </div>
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
            <form:input type="password" path="password" class="form-control" placeholder="${password}"/>
          </div>
          <div class="has-error">
            <form:errors path="password" class="help-inline"/>
          </div>
        </div>
        <div class="form-group">
          <div class="input-group">
            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
            <form:input type="text" path="email" class="form-control" placeholder="${email}"/>
          </div>
          <div class="has-error">
            <form:errors path="email" class="help-inline"/>
          </div>
        </div>
        <div class="form-group">
          <div>
            <input type="submit" value="${regist}" class="btn btn-block btn-primary btn-default"/>
          </div>
        </div>
      </form:form>

      <div class="text-center">
        <a href="/login">${checkin}</a>
      </div>
    </div>
  </div>
  <script src="<c:url value="/static/js/jquery.js" />"></script>
  <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>
</body>
</html>
