<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cf" uri="http://example.com/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${cf:getLanguage(not empty param.lang ? param.lang : not empty language ? language : pageContext.request.locale.language)}" scope="session" />
<fmt:setLocale value="${language}" /> 
<fmt:setBundle basename="text" />

<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" lang="${language}">
<head>

<link rel="stylesheet" href="/css/bulma.css?v=10"/>
<script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>

<!-- <link rel="stylesheet" href="https://unpkg.com/bulmaswatch/lux/bulmaswatch.min.css"> -->



<%@ include file="/includes/metas.jsp"%>
<%@ include file="/includes/extra_css.jsp"%>


<%-- <jsp:include page="/includes/metas.jsp"/> --%>
<%-- <jsp:include page="/includes/extra_css.jsp"/> --%>
<body>