<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:message code="title_of_pages" var="title"/>
<spring:message code="message_info_chickin" var="infoName"/>
<spring:message code="message_info_amount_own" var="ownAmount"/>
<spring:message code="message_info_amount_hired" var="hiredAmount"/>

<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet">
        <link href="<c:url value='/static/css/bootstrap-theme.min.css' />" rel="stylesheet">
        <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet">
    </head>
    <body>
        <tiles:insertAttribute name="header" ignore="true"/>
        <div class="page-header text-center">
            <h4>${infoName} <b>${genData.getName()}</b>,
                ${ownAmount}: ${genData.getOwnDiscAmount()},
                ${hiredAmount} ${genData.getHiredDiscAmount()};
            </h4>
        </div>

        <div class="row">
            <div class="col-md-12">
                <tiles:insertAttribute name="body" ignore="true"/>
            </div>
        </div>

        <tiles:insertAttribute name="footer" ignore="true"/>

        <script src="<c:url value="/static/js/jquery.js" />"></script>
        <script src="<c:url value='/static/js/bootstrap.min.js' />"></script>

        <script type="text/javascript">
            $(document).ready(function () {
                $(".userPhoto").error(function(){
                    $(this).attr({
                        src: "<c:url value='/static/img/vault_boy_black.jpg'/>"
//                        style: 'width:180px;height:180px'
                    });
                })

                $(".discImg").error(function(){
                    $(this).attr({
                        src: "<c:url value='/static/img/film_blue.jpg'/>"
                    });
                })
            });
        </script>
    </body>
</html>
