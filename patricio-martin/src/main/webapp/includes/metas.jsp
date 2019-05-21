<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    
    <c:if test="${empty metaShare}">
    <fmt:bundle basename = "text">
    <title><fmt:message key="meta.title"/></title>
    <meta name="description" content="<fmt:message key="meta.description"/>">
    <meta property="og:type" content="website">
    <meta property="og:url" content="https://patriciomartin.com/">
    <meta name="twitter:card" content="summary_large_image">
    <meta property="og:title" content="<fmt:message key="meta.title"/>">
    <meta name="twitter:title" content="<fmt:message key="meta.title"/>">
    <meta property="og:description" content="<fmt:message key="meta.description"/>">
    <meta name="twitter:description" content="<fmt:message key="meta.description"/>">
    <meta property="og:image" content="">
    <meta name="twitter:image" content="">
    </fmt:bundle>
	</c:if>
	
	<!-- GENERATED META SHARING TAGS -->
	<c:if test="${not empty metaShare}">${metaShare}</c:if>
	<!-- CANONICAL -->
	<c:if test="${not empty canonical}">${canonical}</c:if>
	<c:if test="${empty canonical}"><link rel="canonical" href="https://patriciomartin.com${requestScope['javax.servlet.forward.request_uri']}" /></c:if>

    <!-- GOOGLE VERIFICATION -->
	<!-- <meta name="google-site-verification" content="ada-xxxxxxxxxxxxxxxxxxxxxxxxx" />	 -->
		
	<!-- FAVICONS AND COLOURS -->
	<link rel="apple-touch-icon" sizes="180x180" href="../../favicon/apple-touch-icon.png">
	<link rel="icon" type="image/png" sizes="32x32" href="../../favicon/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="16x16" href="../../favicon/favicon-16x16.png">
	<link rel="manifest" href="../../favicon/site.webmanifest">
	<link rel="mask-icon" href="../../favicon/safari-pinned-tab.svg" color="#5bbad5">
	<link rel="shortcut icon" href="../../favicon/favicon.ico">
	<meta name="msapplication-TileColor" content="#2d89ef">
	<meta name="msapplication-config" content="../../favicon/browserconfig.xml">
	<meta name="theme-color" content="#ffffff"></head>
	
	<!-- OTHER -->
	<!-- <meta content="https://www.facebook.com/pg/TheWebsiteDevil/about/" property="fb:profile_id"> -->
    <meta name="referrer" content="unsafe-url">
	<!-- <link href="https://thewebdevil.com/" rel="home"> -->
    <meta name="referrer" content="no-referrer-when-downgrade">
    <meta name="robots" content="all">