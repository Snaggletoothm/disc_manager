<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="table_head_title" var="title"/>
<spring:message code="table_head_genre" var="genre"/>
<spring:message code="link_edit" var="edit"/>
<spring:message code="table_head_description" var="desc"/>

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">
    <div class="container">
      <div class="row">
        <div class="col-md-4">
          <img src="/file-manager/photo/disc/${disc.title}" class="img-rounded img-responsive img-thumbnail discImg" width="350px" height="350px" alt=""/>
          <form method="POST" action="/file-manager/uploadPhoto/disc/${disc.title}" enctype="multipart/form-data">
            Обновить фото: <input type="file" name="photoFile" class="btn btn-default"><br />
            <input type="submit" class="btn btn-primary" value="Обновить">
          </form>
        </div>
        <div class="col-md-5">
          <form:form method="post" modelAttribute="disc" action="/discManager/edit-disc/${disc.id}" class="form-horizontal">
            <%--<form:hidden path="id"></form:hidden>--%>
            <%--<form:hidden path="comments"></form:hidden>--%>
            <%--<form:hidden path="tempOwnerName"></form:hidden>--%>
            <%--<form:hidden path="owner"></form:hidden>--%>
            <%--<form:hidden path="user"></form:hidden>--%>
            <div class="form-group">
              <label for="title" class="col-sm-2 control-label">${title}</label>
              <div class="col-sm-10">
                <form:input path="title" id="title" class="form-control" placeholder="${title}"></form:input>
              </div>
            </div>

            <div class="form-group">
              <label for="genre" class="col-sm-2 control-label">${genre}</label>
              <div class="col-sm-10">
                <form:select path="genre" id="genre" class="form-control">
                  <form:option value=""></form:option>
                  <form:options items="${genres}"/>
                </form:select>
              </div>
            </div>

            <div class="form-group">
              <label for="description" class="col-sm-2 control-label">${desc}</label>
              <div class="col-sm-10">
                <form:textarea path="description" id="description" class="form-control" rows="10" ></form:textarea>
              </div>
            </div>

            <div class="form-group">
              <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-success">${edit}</button>
              </div>
            </div>
          </form:form>
        </div>
        <div class="col-md-3"></div>
      </div>

    </div>
      </tiles:putAttribute>
</tiles:insertDefinition>

