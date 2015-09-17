<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="table_head_local_now" var="localNow"/>
<spring:message code="table_head_title" var="title"/>
<spring:message code="table_head_genre" var="genre"/>
<spring:message code="link_edit" var="edit"/>
<spring:message code="link_delete" var="del"/>

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">

    <div class="container">
      <div class="row">
        <div class="col-md-4 col-sm-4">
          <div class="row">
            <div class="col-md-12 col-sm-12">
              <img src="/file-manager/photo/user/${sessionUserName}" class="img-rounded img-responsive userPhoto" width="180px" height="180px" alt="У вас нет фото">
            </div>
          </div>
          <div class="row">
            <div class="col-md-12 col-sm-12">
              <form method="POST" action="/file-manager/uploadPhoto/user/${sessionUserName}" enctype="multipart/form-data">
                Обновить фото: <input type="file" name="photoFile" class="btn btn-default"><br />
                <input type="submit" class="btn btn-primary" value="Обновить">
              </form>
            </div>
          </div>
        </div>

        <div class="col-md-8 col-sm-8">
          <h3>Пользователь ${sessionUserName}</h3>
          Диски пользователя:

          <table class="table table-condensed">
            <thead>
              <tr>
                <th>${title}</th>
                <th>${localNow}</th>
                <th></th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${discs}" var="disc">
                <c:choose>
                  <c:when test="${disc.owner == 1}">
                    <tr>
                      <td><a href="<c:url value='/app/change-disc-${disc.id}' />">${disc.title}</a></td>
                      <td>${disc.tempOwnerName}</td>
                      <td><a href="/discManager/edit-${disc.id}-disc">${edit}</a></td>
                      <td><a href="/discManager/delete-${disc.id}-disc">${del}</a></td>
                    </tr>
                  </c:when>
                  <c:otherwise>
                    <tr class="danger">
                      <td>${disc.title}</td>
                      <td>${disc.tempOwnerName}</td>
                      <td></td>
                      <td></td>
                    </tr>
                  </c:otherwise>
                </c:choose>

              </c:forEach>
            </tbody>
          </table>

        </div>
      </div>
    </div>



  </tiles:putAttribute>
</tiles:insertDefinition>
