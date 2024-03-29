
<style>

.image img {
width: auto !important;
}


</style>

<section class="hero">
  <div class="hero-background" style="background-image: url('/img/about.png');"></div>
  <div class="hero-overlay"></div>
  <div class="hero-nav"><%@ include file="includes/nav.jsp"%></div>
  <div class="hero-content">
    <div class="container">
      <h1 class="title hero-title has-text-white" style="margin-bottom:10px;"><fmt:message key="about.hero.title"/></h1>
<%--       <p class="hero-subtitle"><fmt:message key="about.hero.subtitle"/></p> --%>
<%-- 	   <%@ include file="WEB-INF/templates/pattern.jsp" %>  --%>
    </div>
  </div>
</section>

<section class="main page-main">
  <div class="page-body">
    <div class="page-content">
      <div class="container">
        <div class="content">
        <p><fmt:message key="about.paragraph1"/></p>
        <p><fmt:message key="about.paragraph2"/></p>
        <p><fmt:message key="about.paragraph3"/></p>

        
        <div class="columns">
	  <div class="column">
	    <div class="box">
  <article class="media">
    <div class="media-left"><figure class="image"><img src="/img/patricio-s.jpg" alt="Image"></figure></div>
    <div class="media-content">
      <div class="content" style="text-align: center;">
        <p style="margin-bottom:0;"><strong>Patricio Martin</strong> </p>
        <small style="opacity:0.6;"><fmt:message key="about.team.patricio.role"/></small>
      </div>
    </div>
  </article>
</div>
	  </div>
	  <div class="column">
	 	    <div class="box">
  <article class="media">
    <div class="media-left"><figure class="image"><img src="/img/maribel-s.jpg" alt="Image"></figure></div>
    <div class="media-content">
      <div class="content" style="text-align: center;">
        <p style="margin-bottom:0;"><strong>Maribel Cuevas</strong> </p>
         <small style="opacity:0.6;"><fmt:message key="about.team.maribel.role"/></small>
      </div>
    </div>
  </article>
</div>
	  </div>
	  <div class="column">
	   	    <div class="box">
  <article class="media">
    <div class="media-left"><figure class="image"><img src="/img/santiagocalero.jpg" alt="Image"></figure></div>
    <div class="media-content">
      <div class="content" style="text-align: center;">
        <p style="margin-bottom:0;"><strong>Santiago Calero</strong> </p>
         <small style="opacity:0.6;"><fmt:message key="about.team.santiago.role"/></small>
      </div>
    </div>
  </article>
</div>
	  </div>
		</div>
        
        
        </div>
      </div>
    </div>
  </div>
</section>

<%@ include file="WEB-INF/templates/contactCTA.jsp" %>
<%@ include file="WEB-INF/templates/newsletter.jsp" %>