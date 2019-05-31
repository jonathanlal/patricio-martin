
<section class="hero">
  <div class="hero-background" style="background-image: url(https://www.lacala.com/wp-content/uploads/2018/09/Gallery-Patio-Naranjo.jpg);"></div>
  <div class="hero-overlay"></div>
  <div class="hero-nav"><%@ include file="includes/nav.jsp"%></div>
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

<%@ include file="WEB-INF/templates/contactCTA.jsp" %>
<%@ include file="WEB-INF/templates/newsletter.jsp" %>
