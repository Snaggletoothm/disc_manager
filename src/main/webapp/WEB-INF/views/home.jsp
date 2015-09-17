<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">

    <h1>Домашняя страница</h1>
    <a href="/profile/user">Выйти</a>

  </tiles:putAttribute>
</tiles:insertDefinition>

