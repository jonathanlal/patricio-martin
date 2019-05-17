<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="includes/header.jsp"%>

<section class="hero">
  <div class="hero-background" style="background-image: url(https://ivanballiniestates.com/wp-content/themes/ivan-ballini-v4/images/hab/b1.jpg);"></div>
  <div class="hero-overlay"></div>
  <div class="hero-nav"><%@ include file="includes/include_nav.jsp"%></div>
  <div class="hero-content">
    <div class="container">
      <h1 class="title hero-title"><fmt:message key="projects.hero.title"/></h1>
		<%@ include file="WEB-INF/templates/pattern.jsp" %>
      <p class="hero-subtitle"><fmt:message key="projects.hero.subtitle"/></p>
    </div>
  </div>
</section>

<section class="main sold-properties-main">
  <div class="properties-list">
  <div class="container">
    <div id="properties-list" class="list-properties">
<%@ include file="WEB-INF/templates/projects.jsp" %>
	</div>  </div>
</div>
</section>

<%@ include file="WEB-INF/templates/contact.jsp" %>
<%@ include file="WEB-INF/templates/newsletter.jsp" %>
<%@ include file="includes/footer.jsp"%>