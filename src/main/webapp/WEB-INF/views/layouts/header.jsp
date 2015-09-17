<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="header_name" var="headName"/>
<spring:message code="link_new_disc" var="newDisc"/>
<spring:message code="link_free_disc" var="freeDisc"/>
<spring:message code="link_hired_disc" var="hiredDisc"/>
<spring:message code="link_given_away_discs" var="givenDisc"/>
<spring:message code="link_lang" var="lang"/>
<spring:message code="message_menu_lang" var="menuLang"/>
<spring:message code="link_locale_en" var="eng"/>
<spring:message code="link_locale_ru" var="rus"/>
<spring:message code="link_profile" var="profile"/>
<spring:message code="link_checkout" var="out"/>
<spring:message code="link_admin_area" var="admin"/>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".collapseNavBar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">${headName}</a>
    </div>
    <div class="navbar-collapse collapse collapseNavBar">
      <ul class="nav navbar-nav">
        <li>
          <a href="/discManager/new">
            <span class="glyphicon glyphicon-plus"></span>
            <span>${newDisc}</span>
          </a>
        </li>
        <li>
          <a href="/app/free">
            <span class="glyphicon glyphicon-transfer"></span>
            <span>${freeDisc}</span>
          </a>
        </li>
        <li>
          <a href="/app/hired">
            <span class="glyphicon glyphicon-floppy-save"></span>
            <span>${hiredDisc}</span>
          </a>
        </li>
        <li>
          <a href="/app/given">
            <span class="glyphicon glyphicon-floppy-open"></span>
            <span>${givenDisc}</span>
          </a>
        </li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <span class="glyphicon glyphicon-globe"></span>
            <span>${lang}<b class="caret"></b></span>
          </a>
          <ul class="dropdown-menu">
            <li class="dropdown-header">${menuLang}</li>
            <li><a href="?lang=en">${eng}</a></li>
            <li><a href="?lang=ru">${rus}</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <span class="glyphicon glyphicon-star-empty" />
            <span>${profile}<b class="caret"></b></span>
          </a>
          <ul class="dropdown-menu">
            <li>
              <a href="/j_spring_security_logout">
                <span class="glyphicon glyphicon-log-out"></span>
                <span>${out} <b>${sessionUserName}</b></span>
              </a>
            </li>
            <li>
              <a href="/profile/user">
                <span class="glyphicon glyphicon-lock"></span>
                <span>${admin}</span>
              </a>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</div>