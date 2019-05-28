
<style>
.message{
background-color: transparent !important;
}
.message-surtitle, .title{
color: white !important;
font-family:'Soleil Bold' !important;
}
.is-white-outlined{
    background-color: transparent !important;
}
.is-white-outlined:hover{
    background-color: white !important;
    color:black !important;
}
.control.has-icons-left .icon, .control.has-icons-right .icon{
top: 3px !important;
}
</style>

<section class="hero front-hero">
 <div class="front-hero-media">
    <video class="front-hero-video" muted autoplay loop playsinline>
      <source src="https://storage.googleapis.com/patricio-martin.appspot.com/plot-6-2018.mp4" data-store="https://ivanballiniestates.com/wp-content/themes/ivan-ballini-v4/videos/20190322-jt.mp4" type="video/mp4">
    </video>
 </div>
 	<div class="hero-overlay front-hero-overlay __web-inspector-hide-shortcut__"></div>
 	<%@ include file="includes/nav.jsp"%>
 <div class="hero-content front-hero-content" >
    <div id="messages" class="messages">
    <div class="message is-1 is-shown"><p class="message-surtitle"><fmt:message key="index.hero.sTitle1"/></p><h1 class="title hero-title message-title"><fmt:message key="index.hero.lTitle1"/></h1></div>
    <div class="message is-2"><p class="message-surtitle"><fmt:message key="index.hero.sTitle2"/></p><h1 class="title hero-title message-title"><fmt:message key="index.hero.lTitle2"/></h1></div>
    </div>
    <%@ include file="WEB-INF/templates/pattern.jsp" %>
    <div class="hero-subtitle front-hero-subtitle"><p><fmt:message key="index.hero.paragraph"/></p></div>
    <nav class="buttons front-hero-buttons">
      <a class="button is-info" href="<fmt:message key="url.projects"/>"><fmt:message key="index.hero.btnProjects"/><i class="fas fa-long-arrow-alt-right"></i></a>
      <a class="button is-white-outlined" href="<fmt:message key="url.contact"/>"><fmt:message key="index.hero.btnContact"/><i class="far fa-envelope"></i></a>
    </nav>
    </div>
</section>

<div class="front-properties">
<div class="container">
<div class="front-properties-list">
<div id="properties-list" class="list-properties"><%@ include file="WEB-INF/templates/projects.jsp" %></div></div>
<nav class="action front-properties-action"><a class="button is-info" href="<fmt:message key="url.projects"/>" style="margin-bottom: 40px;margin-top:10px;">
<fmt:message key="index.projects.btnProjects"/><i class="fas fa-long-arrow-alt-right"></i></a>
</nav></div></div>

<script>
//hero message cycle
document.addEventListener("DOMContentLoaded",function(){const e="is-shown",s=3600;setTimeout(function t(){const n=document.getElementById("messages"),o=n.querySelectorAll(".message"),i=n.getElementsByClassName("message is-shown")[0],m=i.nextElementSibling?i.nextElementSibling:o[0];i.classList.remove(e),m.classList.add(e),setTimeout(t,s)},s)});
</script>

<%@ include file="WEB-INF/templates/contact.jsp" %>
<%@ include file="WEB-INF/templates/newsletter.jsp" %>