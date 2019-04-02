<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!-- VIEWPORT FOR RESPONSIVENESS - https://developer.mozilla.org/en-US/docs/Mozilla/Mobile/Viewport_meta_tag -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"> -->
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--  	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700,800,900|Work+Sans:400,700" rel="stylesheet"> -->
 
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    
    <c:if test="${empty metaShare}">
    <title>Patricio Martin - Costa del Sol Architects</title>
    <meta name="description" content="Patricio Martin can provide a full architectural and building service. From the initial survey and design concept, through all stages of the building process, right up to the completed project and final result.">
    <meta property="og:type" content="website">
    <meta property="og:url" content="https://patriciomartin.com/">
    <meta name="twitter:card" content="summary_large_image">
    <meta property="og:title" content="Patricio Martin - Costa del Sol Architects">
    <meta name="twitter:title" content="Patricio Martin - Costa del Sol Architects">
    <meta property="og:description" content="Patricio Martin can provide a full architectural and building service. From the initial survey and design concept, through all stages of the building process, right up to the completed project and final result.">
    <meta name="twitter:description" content="Patricio Martin can provide a full architectural and building service. From the initial survey and design concept, through all stages of the building process, right up to the completed project and final result.">
    <meta property="og:image" content="">
    <meta name="twitter:image" content="">
	</c:if>
	
	<!-- GENERATED META SHARING TAGS -->
	<c:if test="${not empty metaShare}">${metaShare}</c:if>
	<!-- CANONICAL -->
	<c:if test="${not empty canonical}">${canonical}</c:if>
	<c:if test="${empty canonical}"><link rel="canonical" href="https://patriciomartin.com${requestScope['javax.servlet.forward.request_uri']}" /></c:if>

    <!-- GOOGLE VERIFICATION -->
	<meta name="google-site-verification" content="xOZtJiKTj_b6gC5Z_4aCH7aTeRD1rW73cGlpJ7-pspI" />	
		
	<!-- FAVICONS AND COLOURS -->
<meta name="theme-color" content="#ffffff"></head>
	
	<!-- OTHER -->
<!-- 	<meta content="https://www.facebook.com/pg/TheWebsiteDevil/about/" property="fb:profile_id"> -->
    <meta name="referrer" content="unsafe-url">
<!--     <link href="https://thewebdevil.com/" rel="home"> -->
    <meta name="referrer" content="no-referrer-when-downgrade">
    <meta name="robots" content="all">