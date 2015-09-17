<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="table_head_title" var="title"/>
<spring:message code="table_head_genre" var="genre"/>
<spring:message code="table_head_owner" var="owner"/>

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">

    <div class="container text-center">
      <table class="table table-striped table-hover table-condensed">
        <thead>
        <tr>
          <td><b>${title}</b></td>
          <td><b>${genre}</b></td>
          <td><b>${owner}</b></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${discs}" var="disc">
          <tr>
            <td>
              <a href="<c:url value='/app/change-disc-${disc.id}' />">${disc.title}</a>
            </td>
            <td>${disc.genre}</td>
            <td>
                ${disc.user.name}
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>

  </tiles:putAttribute>
</tiles:insertDefinition>
