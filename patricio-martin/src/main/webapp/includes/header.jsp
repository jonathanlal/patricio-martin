<%@ page contentType="text/html; charset=UTF-8" %>
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
  <c:set var="url">${pageContext.request.requestURL}</c:set>
<!-- INFO ON BASE TAG: https://stackoverflow.com/questions/1889076/what-are-the-recommendations-for-html-base-tag ****This means using named/hash fragment anchors like <a href="#anchor"> should be instead:  <a href="${uri}#anchor">hash fragment</a> -->
   <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/${not empty language ? language : cf:getDefaultLang()}/" /><!--[if lte IE 6]></base><![endif]-->

<link rel="stylesheet" href="/css/bulma.css?v=22"/>
<script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>


<%@ include file="/includes/metas.jsp"%>
<%@ include file="/includes/extra_css.jsp"%>

<body>