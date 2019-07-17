<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cf" uri="http://example.com/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- if language is empty then get the langage of the url.  -->
<%-- <c:set var="language" value="${cf:getLanguage(not empty param.lang ? param.lang : not empty language ? language : pageContext.request.locale.language)}" scope="session" /> --%>
<c:set var="language" value="${not empty language ? language : cf:getDefaultLang()}" scope="session" />

<fmt:setLocale value="${language}" /> 
<fmt:setBundle basename="text" />

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="${language}">
<head>
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-130244260-2"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-130244260-2');
</script>


  <c:set var="url">${pageContext.request.requestURL}</c:set>
<!-- INFO ON BASE TAG: https://stackoverflow.com/questions/1889076/what-are-the-recommendations-for-html-base-tag ****This means using named/hash fragment anchors like <a href="#anchor"> should be instead:  <a href="${uri}#anchor">hash fragment</a> -->
   <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/${not empty language ? language : cf:getDefaultLang()}/" /><!--[if lte IE 6]></base><![endif]-->

<link rel="stylesheet" href="/css/bulma.min.css"/>
<link rel="stylesheet" href="/css/extras.min.css"/>
<script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>


<%@ include file="/includes/metas.jsp"%>


    </head>
<body>