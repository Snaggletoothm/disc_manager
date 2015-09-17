<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="message_info_danger_disc" var="danger"/>
<spring:message code="table_head_title" var="title"/>
<spring:message code="table_head_genre" var="genre"/>
<spring:message code="table_head_owner" var="owner"/>
<spring:message code="link_delete" var="del"/>
<spring:message code="field_rent" var="rent"/>
<spring:message code="message_comments" var="headComments"/>
<spring:message code="link_create" var="create"/>
<spring:message code="table_head_description" var="desc"/>
<spring:message code="table_head_film" var="movie"/>

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">
    <div class="container text-center">
      <br/>
      <c:choose>
        <c:when test="${hasCurrUser}">
          <h3>${danger}</h3>
        </c:when>
        <c:otherwise>
        </c:otherwise>
      </c:choose>
      <hr/>

      <div class="container">
        <div class="row">
          <div class="col-md-4 col-sm-4">
            <p>
              ${movie} <b>${disc.title}(${disc.genre})</b>
            </p>
            <img src="/file-manager/photo/disc/${disc.title}" class="img-rounded img-responsive img-thumbnail discImg" width="350px" height="350px" alt=""/>
          </div>
          <div class="col-md-4 col-sm-4">
            <p><b>${desc}</b></p>
            <p>${disc.description}</p>
          </div>
          <div class="col-md-4 col-sm-4 text-right">
            <p><b>${owner}: </b>${disc.user.name}</p>
            <c:choose>
              <c:when test="${hasCurrUser}">
                <a href="/discManager/delete-${disc.id}-disc" class="btn btn-danger">${del}</a>
              </c:when>
              <c:otherwise>
                <a href="/app/take-${disc.id}-${disc.title}" class="btn btn-success">${rent}</a>
              </c:otherwise>
            </c:choose>
          </div>
        </div>
      </div>
      <br/>
      <hr/>
      <div class="text-left">
        <b>${headComments}, Кол-во ${commentCount}</b>
        <p>Оставить комментарий:</p>
        <form:form class="form-horizontal" modelAttribute="comment" method="post" action="/app/add-comment-for-disc/${disc.id}">
          <div class="container">
            <div class="row">
              <div class="col-md-2 col-sm-2">
                <img src="/file-manager/photo/user/${sessionUserName}" class="img-rounded img-responsive userPhoto" width="100px" height="100px">
              </div>
              <div class="col-md-10 col-sm-10">
                <div class="form-group">
                  <form:textarea path="userComment" class="form-control" rows="5" id="comment"/>
                </div>
                <div class="form-group">
                  <button type="submit" class="btn btn-success">${create}</button>
                </div>
              </div>
            </div>
          </div>
        </form:form>
        <hr/>
        <c:forEach items="${disc.comments}" var="comment">
          <div class="container">
            <div class="row">
              <div class="col-md-1 col-sm-1">
                <img src="/file-manager/photo/user/${comment.userName}" class="img-rounded img-responsive userPhoto" width="50px" height="50px">
              </div>
              <div class="col-md-11 col-sm-11">
                <div class="row">
                  <div class="col-md-10">
                    <p><b>${comment.userName}, ${comment.localDate}</b></p>
                    <p>${comment.userComment}</p>
                  </div>
                  <div class="col-md-2">
                    <c:choose>
                      <c:when test="${sessionUserName == comment.userName}">
                        <a href="/app/del-comment/${disc.id}/${comment.id}">удалить коммент</a>
                      </c:when>
                      <c:otherwise></c:otherwise>
                    </c:choose>
                  </div>
                </div>
                <hr/>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>

    </div>
  </tiles:putAttribute>
</tiles:insertDefinition>
