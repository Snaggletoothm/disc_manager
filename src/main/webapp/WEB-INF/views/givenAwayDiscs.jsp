<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="page_given" var="given"/>
<spring:message code="table_head_title" var="title"/>
<spring:message code="table_head_genre" var="genre"/>
<spring:message code="table_head_owner" var="owner"/>
<spring:message code="table_head_local_now" var="localNow"/>
<spring:message code="field_give_away" var="giveAway"/>

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">
    <h2 id="disc-header" class="text-center">${given}</h2>

    <div class="container text-center">
      <table class="table table-responsive">
        <thead>
        <tr>
          <td>${title}</td>
          <td>${genre}</td>
          <td>${owner}</td>
          <td>${localNow}</td>
          <td></td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${discs}" var="disc">
          <tr>
            <td>${disc.title}</td>
            <td>${disc.genre}</td>
            <td>${disc.user.name}</td>
            <td>${disc.tempOwnerName}</td>
            <td>
              <a href="/app/return-${disc.id}">${giveAway}</a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>

  </tiles:putAttribute>
</tiles:insertDefinition>