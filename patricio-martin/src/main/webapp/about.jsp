<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="includes/header.jsp"%>



<section class="hero">
  <div class="hero-background" style="background-image: url(https://ivanballiniestates.com/wp-content/themes/ivan-ballini-v4/images/hab/maison-honfleur.jpg);"></div>

  <div class="hero-overlay"></div>

  <div class="hero-nav">
  <%@ include file="includes/include_nav.jsp"%>
  </div>

  <div class="hero-content">
    <div class="container">
      <h1 class="title hero-title has-text-white" style="margin-bottom:10px;"><fmt:message key="about.hero.title"/></h1>
      <p class="hero-subtitle"><fmt:message key="about.hero.subtitle"/></p>
		  <%@ include file="WEB-INF/templates/pattern.jsp" %>
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
            

            </div>
          </div>
        </div>
      </div>
    </section>
    
    
    

      

<%@ include file="WEB-INF/templates/contact.jsp" %>
<%@ include file="WEB-INF/templates/newsletter.jsp" %>




<%@ include file="includes/footer.jsp"%>