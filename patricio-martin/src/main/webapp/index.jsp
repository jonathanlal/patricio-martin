<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="includes/header.jsp"%>






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



.property-img{
margin-bottom: -20px;margin-right: -10px;    opacity: 0.8;
    max-width: 100px;
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
  
  <%@ include file="includes/include_nav.jsp"%>
  
  
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
 <div class="hero-content front-hero-content" >
    <div id="messages" class="messages">
    <div class="message is-1 is-shown"><p class="message-surtitle"><fmt:message key="index.hero.sTitle1"/></p><h1 class="title hero-title message-title"><fmt:message key="index.hero.lTitle1"/></h1></div>
    <div class="message is-2"><p class="message-surtitle"><fmt:message key="index.hero.sTitle2"/></p><h1 class="title hero-title message-title"><fmt:message key="index.hero.lTitle2"/></h1></div>
    </div>
    
    <%@ include file="WEB-INF/templates/pattern.jsp" %>


    <div class="hero-subtitle front-hero-subtitle">
      <p><fmt:message key="index.hero.paragraph"/></p>
    </div>
    <nav class="buttons front-hero-buttons">
      <a class="button is-info" href="../projects/"><span class="button-text"><fmt:message key="index.hero.btnProjects"/></span><i class="fas fa-long-arrow-alt-right"></i></a>
      <a class="button is-white-outlined" href="../contact/"><span class="button-text"><fmt:message key="index.hero.btnContact"/></span><i class="far fa-envelope"></i></a>
    </nav>
    </div>

</section>







  
  <div class="front-properties">
  <div class="container">
  
  
    <div class="front-properties-list">
    <div id="properties-list" class="list-properties">
      
<article class="list-property">
<a href="../projects/la-cala/" class="card property post-2098 type-property status-publish has-post-thumbnail hentry type-manoir region-deauville city-benerville-sur-mer has-5-to-9-rooms has-5-bedrooms region-blue">
  <figure class="card-image property-image">
<img class="responsive-image" src="http://patriciomartin.com/img/la-cala/thumbs/3.jpg" sizes="(max-width: 540px) 100vw, 720px" srcset="http://patriciomartin.com/img/la-cala/thumbs/3.jpg 540w, http://patriciomartin.com/img/la-cala/thumbs/3.jpg 1080w, http://patriciomartin.com/img/la-cala/thumbs/3.jpg 1440w" height="480" width="720">
  </figure>
  <div class="card-content property-content clearfix">
    <div class="property-heading">
      <p class="location property-location">La Cala</p>
	<h3 class="title property-name">Golf & Country Club</h3>
    </div>
    <div class="property-info"><p class="price property-price"><img src="../img/homepage/la-cala2.png" class="property-img"></p>
    </div>
  </div>
</a>
</article>


<article class="list-property">
<a href="../projects/san-eliseo/" class="card property post-610 type-property status-publish has-post-thumbnail hentry type-chateau region-bernay city-bernay has-10-rooms has-5-bedrooms region-red">
  <figure class="card-image property-image">
<img class="responsive-image" src="http://patriciomartin.com/img/san-eliseo/thumbs/4.jpg" sizes="(max-width: 540px) 100vw, 720px" srcset="http://patriciomartin.com/img/san-eliseo/thumbs/4.jpg 540w, http://patriciomartin.com/img/san-eliseo/thumbs/4.jpg 1080w, http://patriciomartin.com/img/san-eliseo/thumbs/4.jpg 1440w" height="480" width="720">
  </figure>
  <div class="card-content property-content clearfix">
    <div class="property-heading">
      <p class="location property-location">Argentina</p>
      <h3 class="title property-name">San Eliseo</h3>
    </div>
    <div class="property-info"><p class="price property-price"><img src="../img/homepage/san-eliseo.png" class="property-img"></p>
    </div>
  </div>
</a>
</article>


<article class="list-property">
<a  href="../projects/rancho-santa-monica/" class="card property post-553 type-property status-publish has-post-thumbnail hentry type-manoir region-honfleur city-honfleur has-5-to-9-rooms has-3-to-4-bedrooms region-green">
  <figure class="card-image property-image">
<img class="responsive-image" src="http://patriciomartin.com/img/rancho-santa-monica/thumbs/6.jpg" sizes="(max-width: 540px) 100vw, 720px" srcset="http://patriciomartin.com/img/rancho-santa-monica/thumbs/6.jpg 540w, http://patriciomartin.com/img/rancho-santa-monica/thumbs/6.jpg 1080w, http://patriciomartin.com/img/rancho-santa-monica/thumbs/6.jpg 1440w" height="480" width="720">
  </figure>
  <div class="card-content property-content clearfix">
    <div class="property-heading">
      <p class="location property-location">Benalmádena</p>
      <h3 class="title property-name">Rancho Santa Monica</h3>
    </div>
        <div class="property-info">
      <p class="price property-price">
        <img src="../img/homepage/rancho.png" class="property-img">
        </p>
    </div>
  </div>
</a>
</article>


<article class="list-property">
<a href="../projects/domus-designs/" class="card property post-796 type-property status-publish has-post-thumbnail hentry type-manoir region-deauville city-tourgeville has-5-to-9-rooms has-3-to-4-bedrooms region-blue">
  <figure class="card-image property-image">
<img class="responsive-image" src="http://patriciomartin.com/img/domus-designs/thumbs/1.jpg" sizes="(max-width: 540px) 100vw, 720px" srcset="http://patriciomartin.com/img/domus-designs/thumbs/1.jpg 540w, http://patriciomartin.com/img/domus-designs/thumbs/1.jpg 1080w, http://patriciomartin.com/img/domus-designs/thumbs/1.jpg 1440w" height="480" width="720">
  </figure>
  <div class="card-content property-content clearfix">
    <div class="property-heading">
      <p class="location property-location">Costa Del Sol</p>
      <h3 class="title property-name">Domus Designs Villas</h3>
    </div>
    <div class="property-info">
      <p class="price property-price">
        <img src="../img/homepage/domus.png" class="property-img">
        </p>
    </div>
  </div>
</a>
</article>

</div>    
</div>

    <nav class="action front-properties-action">
      <a class="button is-info" href="../projects/" style="margin-bottom: 20px;">
      <span class="button-text"><fmt:message key="index.projects.btnProjects"/>
      </span><i class="fas fa-long-arrow-alt-right"></i></a>
    </nav>
    
  </div>
</div>
  
  
  
<section class="collaborate">
  <div class="collaborate-overlay"></div>
  <div class="container">
    <div class="box collaborate-box">
      <div class="box-content">
        <h4 class="title collaborate-title" style="color:black !important;"><fmt:message key="index.contact.title"/></h4>
  		  <%@ include file="WEB-INF/templates/pattern.jsp" %>
        <div class="content collaborate-content">
          <p><fmt:message key="index.contact.paragraph"/></p>
        </div>
       <div class="collaborate-buttons">
         <a class="button is-info  open-modal" data-target="contactModal" href="#"><span class="button-text" style="padding-right:8px;"><fmt:message key="index.contact.btnContact"/></span><i class="fas fa-long-arrow-alt-right"></i></a>
       </div>
      </div>
    </div>
  </div>
</section>




 <section id="newsletter" class="section is-medium" style="background-color:#E7E5E0">
  <div class="container">
    <div class="columns is-vcentered">
      <div class="column" style="    margin-top: -20px;">
        <p class="title"><fmt:message key="index.newsletter.title"/></p>
        <p class="subtitle is-4 has-text-grey-light"><fmt:message key="index.newsletter.paragraph"/></p>
      </div>




      <div class="column">
      
        <form action="../../Subscribe" method="POST" accept-charset="utf-8">
          <div class="field is-grouped">
            <div class="control has-icons-left is-expanded">
              <input type="email" value="" name="email" class="input is-medium is-flat" placeholder="<fmt:message key="index.newsletter.inputPlaceholder"/>" required>
              <span class="icon is-small is-left">
                <svg class="svg-inline--fa fa-envelope fa-w-16" aria-hidden="true" data-prefix="fas" data-icon="envelope" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512" data-fa-i2svg=""><path fill="currentColor" d="M502.3 190.8c3.9-3.1 9.7-.2 9.7 4.7V400c0 26.5-21.5 48-48 48H48c-26.5 0-48-21.5-48-48V195.6c0-5 5.7-7.8 9.7-4.7 22.4 17.4 52.1 39.5 154.1 113.6 21.1 15.4 56.7 47.8 92.2 47.6 35.7.3 72-32.8 92.3-47.6 102-74.1 131.6-96.3 154-113.7zM256 320c23.2.4 56.6-29.2 73.4-41.4 132.7-96.3 142.8-104.7 173.4-128.7 5.8-4.5 9.2-11.5 9.2-18.9v-19c0-26.5-21.5-48-48-48H48C21.5 64 0 85.5 0 112v19c0 7.4 3.4 14.3 9.2 18.9 30.6 23.9 40.7 32.4 173.4 128.7 16.8 12.2 50.2 41.8 73.4 41.4z"></path></svg><!-- <i class="fas fa-envelope"></i> -->
              </span>
              <img class="bd-drawing bd-is-spam-free" src="https://bulma.io/images/drawing/spam-free.png" width="112" height="88" style="    position: absolute !important;bottom:100% !important;right:90% !important;">

            </div>

            <div class="control">
              <div class="is-hidden">
                <input type="text" name="hp" id="hp">
              </div>
              <input type="hidden" name="list" value="So5UY3O9gHJkq892bn763Tyf4A">
              <button class="button is-medium is-info">
                <strong><fmt:message key="index.newsletter.btnSubscribe"/></strong>
              </button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</section>








<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/cookieconsent2/3.1.0/cookieconsent.min.css" />
<script src="//cdnjs.cloudflare.com/ajax/libs/cookieconsent2/3.1.0/cookieconsent.min.js"></script>
<script>
window.addEventListener("load", function(){
window.cookieconsent.initialise({
  "palette": {
    "popup": {
      "background": "#343c66",
      "text": "#cfcfe8"
    },
    "button": {
      "background": "#f71559"
    }
  },
  "theme": "classic",
  "content": {
    "message": "change this --&gt; https://cookieconsent.insites.com/download/"
  }
})});
</script>


<script>

document.addEventListener("DOMContentLoaded", function(){

	  // Messages cycle

	  const SHOWN_CLASS = 'is-shown';
	  const MESSAGES_SPEED = 3600;

	  function loopMessages() {
	    const container_el = document.getElementById('messages');
	    const items = container_el.querySelectorAll('.message');
	const current_item = container_el.getElementsByClassName("message is-shown")[0];
	    const next_item = current_item.nextElementSibling ? current_item.nextElementSibling : items[0];

	    current_item.classList.remove(SHOWN_CLASS);
	    next_item.classList.add(SHOWN_CLASS);

	    setTimeout(loopMessages, MESSAGES_SPEED);
	  }
	  setTimeout(loopMessages, MESSAGES_SPEED);

	});

</script>




<%@ include file="includes/footer.jsp"%>