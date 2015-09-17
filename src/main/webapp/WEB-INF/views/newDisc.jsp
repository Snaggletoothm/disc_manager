<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="table_head_title" var="title"/>
<spring:message code="table_head_genre" var="genre"/>
<spring:message code="link_create" var="create"/>

<tiles:insertDefinition name="defaultTemplate">
  <tiles:putAttribute name="body">
    <div class="row">
      <div class="col-md-3"></div>
      <div class="col-md-5">
        <form:form method="post" modelAttribute="disc" action="/appManager/new" class="form-horizontal">
          <div class="form-group">
            <label for="title" class="col-sm-2 control-label">${title}</label>
            <div class="col-sm-10">
              <form:input path="title" id="title" class="form-control" placeholder="${title}" />
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
            <div class="col-sm-offset-2 col-sm-10">
              <button type="submit" class="btn btn-success">${create}</button>
            </div>
          </div>
        </form:form>
      </div>
      <div class="col-md-4"></div>
    </div>
  </tiles:putAttribute>
</tiles:insertDefinition>
