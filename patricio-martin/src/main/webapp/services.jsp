
<style>

.card{
background-color: white !important;
}
.title svg{
color:#209cee  !important;
}
.card-content{
top:-15px !important;
background-image: none !important;
}
.is-vertical-center {
  display: flex;
  align-items: center;
}

.is-fullwidth{
width: 100% !important;
}

.is-fullwidth p.subtitle{
marign-top:30px !important;
}



</style>

<section class="hero">
  <div class="hero-background" style="background-image: url(https://ivanballiniestates.com/wp-content/themes/ivan-ballini-v4/images/hab/b1.jpg);"></div>
  <div class="hero-overlay"></div>
  <div class="hero-nav"><%@ include file="includes/nav.jsp"%></div>
  <div class="hero-content">
    <div class="container">
      <h1 class="title hero-title"><fmt:message key="services.hero.title"/></h1>
		<%@ include file="WEB-INF/templates/pattern.jsp" %>

    </div>
  </div>
</section>

<section class="main sold-properties-main ">
  <div class="container" style="padding:20px;">
        <p class="hero-subtitle"><fmt:message key="services.hero.subtitle"/></p>

<br>
<div class="columns is-centered ">

<div class="column has-text-centered ">
   <div class="card "><div class="card-content is-vertical-center"><div class="is-fullwidth">
		<p class="title is-size-2">
		<i class="fas fa-home"></i></p>
		<p class="subtitle"><fmt:message key="services.icon.1"/></p>
   </div></div></div>
</div>
  
<div class="column has-text-centered">
  <div class="card "><div class="card-content is-vertical-center"><div class="is-fullwidth">
		<p class="title is-size-2"><i class="fas fa-user-friends"></i></p>
 		<p class="subtitle"><fmt:message key="services.icon.2"/></p>
  </div></div></div>
</div>
  
<div class="column has-text-centered">
  <div class="card"><div class="card-content is-vertical-center"><div class="is-fullwidth">
 		<p class="title is-size-2"><i class="fas fa-layer-group"></i></p>
		<p class="subtitle"><fmt:message key="services.icon.3"/></p>
  </div></div></div>
</div>
  
<div class="column has-text-centered">
  <div class="card"><div class="card-content is-vertical-center"><div class="is-fullwidth">
 		<p class="title is-size-2"><i class="fas fa-route"></i></p>
 		<p class="subtitle"><fmt:message key="services.icon.4"/></p>
  </div></div></div>
</div>
  
</div>

<div class="columns is-centered ">

<div class="column has-text-centered ">
   <div class="card "><div class="card-content is-vertical-center"><div class="is-fullwidth">
		<p class="title is-size-2"><i class="fas fa-palette"></i></p>
		<p class="subtitle"><fmt:message key="services.icon.5"/></p>
   </div></div></div>
</div>
  
<div class="column has-text-centered">
  <div class="card "><div class="card-content is-vertical-center"><div class="is-fullwidth">
		<p class="title is-size-2"><i class="fas fa-drafting-compass"></i></p>
 		<p class="subtitle"><fmt:message key="services.icon.6"/></p>
  </div></div></div>
</div>
  
<div class="column has-text-centered">
  <div class="card"><div class="card-content is-vertical-center"><div class="is-fullwidth">
 		<p class="title is-size-2"><i class="fas fa-balance-scale"></i></p>
		<p class="subtitle"><fmt:message key="services.icon.7"/></p>
  </div></div></div>
</div>
  
<div class="column has-text-centered">
  <div class="card"><div class="card-content is-vertical-center"><div class="is-fullwidth">
 		<p class="title is-size-2"><i class="fas fa-stamp"></i></p>
 		<p class="subtitle"><fmt:message key="services.icon.8"/></p>
  </div></div></div>
</div>
  
</div>


<div class="columns is-centered ">

<div class="column has-text-centered ">
   <div class="card "><div class="card-content is-vertical-center"><div class="is-fullwidth">
		<p class="title is-size-2"><i class="fas fa-file-signature"></i></p>
		<p class="subtitle"><fmt:message key="services.icon.9"/></p>
   </div></div></div>
</div>
  
<div class="column has-text-centered">
  <div class="card "><div class="card-content is-vertical-center"><div class="is-fullwidth">
		<p class="title is-size-2"><i class="fas fa-comment-dollar"></i></p>
 		<p class="subtitle"><fmt:message key="services.icon.10"/></p>
  </div></div></div>
</div>
  
<div class="column has-text-centered">
  <div class="card"><div class="card-content is-vertical-center"><div class="is-fullwidth">
 		<p class="title is-size-2"><i class="fas fa-search"></i></p>
		<p class="subtitle"><fmt:message key="services.icon.11"/></p>
  </div></div></div>
</div>
  
<div class="column">
</div>
  
</div>

</div>
</section>

<%@ include file="WEB-INF/templates/contactCTA.jsp" %>
<%@ include file="WEB-INF/templates/newsletter.jsp" %>