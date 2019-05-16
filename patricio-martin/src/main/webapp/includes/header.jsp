<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:set var="language" value="${not empty param.lang ? param.lang : not empty language ? language : pageContext.request.locale.language}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="text" />


<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" lang="${language eq 'en' || language eq 'es' ? language : 'en'}">

<head>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.4/css/bulma.min.css">
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>


<jsp:include page="/includes/metas.jsp"/>
<jsp:include page="/includes/extra_css.jsp"/>
<%--  <c:import url="/css/main_css.html" /> --%>
<%--  <c:import url="/includes/include_fontawesome_css.html" /> --%>
<%-- <c:import url="/includes/include_jquery_js.html"/> --%>
<%-- <c:import url="/includes/include_bootstrap_js.html"/> --%>











<body>

