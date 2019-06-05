
<style>

.card{
background-color: white !important;
}
.title svg, .fa-li svg{
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

.box{
padding:2rem !important;
    margin: 5px !important;
    height: 100% !important;
}
.content{
padding-bottom:10px !important;
}
.title{
top: 12px !important;position:relative !important;
}

</style>

<section class="hero">
  <div class="hero-background" style="background-image: url('/img/services.png');"></div>
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
        <p class="hero-subtitle has-text-centered"><fmt:message key="services.hero.subtitle"/></p>

<br>

<c:if test="${param.v eq 1}">


<div class="columns is-multiline is-centered">
<c:forEach items="${services}" var="s" varStatus="count">

<div class="column is-one-quarter has-text-centered">
<div class="box" >
  <article class="media"><div class="media-content"><div class="content">
<p class="title is-size-2">${s.value}</p>
<p class="subtitle"><c:out value="${s.key}"/></p>
 </div></div></article>
</div>
</div>



<div class="columns">
</div>
</c:forEach>
</div>
</c:if> 

<c:if test="${empty param.v || param.v eq 2}">
<div class="box">
<div class="content">
<c:forEach items="${services}" var="s" varStatus="count">
<ul class="fa-ul is-size-4">
  <li><span class="fa-li" >${s.value}</span>${s.key}</li>
</ul>
</c:forEach>
</div>
</div>
</c:if> 


</div>
</section>

<%@ include file="WEB-INF/templates/contactCTA.jsp" %>
<%@ include file="WEB-INF/templates/newsletter.jsp" %>